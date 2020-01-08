package com.example.group4.service.impl.MerchantServiceImpl;

import com.example.group4.bean.*;
import com.example.group4.bean.ex.Cost_billEX;
import com.example.group4.mapper.BusinessMapper;
import com.example.group4.mapper.Cost_billMapper;
import com.example.group4.mapper.MachineMapper;
import com.example.group4.service.IMerchantService.IMerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MerchantServiceImpl implements IMerchantService {
    @Autowired
    private BusinessMapper businessMapper;
    @Autowired
    private Cost_billMapper cost_billMapper;
    @Autowired
    private MachineMapper machineMapper;
    private int macId;

    @Override
    public Business queById(int id) {
        return businessMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(Business business) throws RuntimeException {
        if(business==null){
            new RuntimeException("参数错误");
        }
        if(business.getId()==null){
            businessMapper.insert(business);
        }
        else {
            businessMapper.updateByPrimaryKey(business);
        }
    }

    @Override
    public List<Cost_billEX> selectCollectionRecords(Date startDate,Date endDate,int id) throws RuntimeException {
        //查询数据
        Cost_billExample example = new Cost_billExample();
        example.createCriteria().andMachineIdEqualTo(id).andTimeBetween(startDate,endDate);
        List<Cost_bill> cost_bills = cost_billMapper.selectByExample(example);

        List<Cost_billEX> cost_billEXList = new ArrayList<>();

        double profit=0;
        //计算收益记录的总额
        for (Cost_bill cost_bill : cost_bills) {
            profit += cost_bill.getMoney();
        }
        //将cost_bill和profit封装到cost_billEX集合中
        for (int i = 0; i < cost_bills.size(); i++) {
            cost_billEXList.add(new Cost_billEX(cost_bills.get(i).getId(),cost_bills.get(i).getCardId(),cost_bills.get(i).getMoney(),cost_bills.get(i).getTime(),cost_bills.get(i).getMachineId(),profit));
        }
        return cost_billEXList;
    }

    @Override
    public double getProfit(Date startDate, Date endDate, int id) throws RuntimeException {
        double profit= 0;
        List<Cost_billEX> cost_bills = selectCollectionRecords(startDate, endDate, id);
        for (Cost_billEX cost_bill : cost_bills) {
            profit += cost_bill.getMoney();
        }
        return profit;
    }

    @Override
    public List<Cost_bill> downloadProfitSheet(int busId, int macId) throws RuntimeException {
        List<Machine> machines = selectMacId(busId);
        List<Cost_bill> cost_bills = new ArrayList<>();
        //全部收益
        if(macId==-1){
            for (int i = 0; i < machines.size(); i++) {
                Cost_billExample example = new Cost_billExample();
                example.createCriteria().andMachineIdEqualTo(machines.get(i).getId());
               cost_bills.addAll(cost_billMapper.selectByExample(example));
            }
            return cost_bills;
        }//某台机器的收益
        else {
            Cost_billExample example = new Cost_billExample();
            example.createCriteria().andMachineIdEqualTo(macId);
            return cost_billMapper.selectByExample(example);
        }
    }

    @Override
    public List<Machine>  selectMacId(int id) throws RuntimeException {
        MachineExample example = new MachineExample();
        example.createCriteria().andBusinessIdEqualTo(id);
        return machineMapper.selectByExample(example);
    }


}

