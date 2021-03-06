package com.example.group4.service.impl.merchantServiceImpl;

import com.example.group4.bean.*;
import com.example.group4.mapper.Cost_billMapper;
import com.example.group4.mapper.MachineMapper;
import com.example.group4.mapper.MealcardMapper;
import com.example.group4.mapper.ex.CostbillEXMapper;
import com.example.group4.service.imerchantService.IMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MachineServiceImpl implements IMachineService {
    @Autowired
    private MachineMapper machineMapper;
    @Autowired
    private MealcardMapper mealcardMapper;
    @Autowired
    private CostbillEXMapper costbillEXMapper;
    @Autowired
    private Cost_billMapper cost_billMapper;

    @Override
    public List<Machine> findById(int id) throws RuntimeException {
        MachineExample example = new MachineExample();
        example.createCriteria().andBusinessIdEqualTo(id);
        return machineMapper.selectByExample(example);
    }

    @Override
    public void editOrAddMac(Machine machine) throws RuntimeException {
        if(machine==null){
            new RuntimeException("参数错误");
        }
        System.out.println(machine);
        machine.setTime(new Date());
        if(machine.getId()==null){
            machineMapper.insert(machine);
        }
        else {
            machineMapper.updateByPrimaryKey(machine);
        }
    }

    @Override
    public void delMac(int[] ids) throws RuntimeException {
        for (int i = 0; i < ids.length; i++) {
            machineMapper.deleteByPrimaryKey(ids[i]);
        }
    }

    @Override
    public String recordBill(int cardId, double money, int machineId) throws RuntimeException {
        //饭卡状态是否异常
        Mealcard mealcard = mealcardMapper.selectByPrimaryKey(cardId);
        //饭卡是否限额
        double[] bills = costbillEXMapper.consume(cardId, new Date());
        double s = 0;
        for (double bill : bills) {
            s += bill;
        }
        //饭卡状态是否异常
        if (!"normal".equals(mealcard.getType())) {
            return "饭卡异常";
        }//饭卡是否限额
        else if (s + money > mealcard.getCeiling()) {
            return "超过饭卡限额";
        }
        //饭卡余额是否足够
        else if (mealcard.getMoney() < money) {
            return "余额不足，请充值！";
        } else {
            //新增消费记录
            Cost_bill cost_bill = new Cost_bill();
            cost_bill.setCardId(cardId);
            cost_bill.setMachineId(machineId);
            cost_bill.setMoney(money);
            cost_bill.setTime(new Date());
            cost_billMapper.insert(cost_bill);
            //更新该饭卡已消费金额及余额数
            mealcard.setMoney(mealcard.getMoney() - money);
            mealcardMapper.updateByPrimaryKey(mealcard);
            return "成功";
        }

    }

    //根据商户id查找机器
    @Override
    public List<Machine> selectMacByBusId(int busId) throws RuntimeException {
        MachineExample example =new MachineExample();
        example.createCriteria().andBusinessIdEqualTo(busId);
        return machineMapper.selectByExample(example);
    }

    @Override
    public Machine findMacByMacId(int macId) throws RuntimeException {
        return machineMapper.selectByPrimaryKey(macId);
    }

    @Override
    public List<Machine> fuzzyQueMacByAddr(String word, int busId) throws RuntimeException {
        if (word==null){
            return findById(busId);
        }else {
            word = "%"+word+"%";
            MachineExample example = new MachineExample();
            example.createCriteria().andBusinessIdEqualTo(busId).andAddressLike(word);
            return machineMapper.selectByExample(example);
        }

    }


}
