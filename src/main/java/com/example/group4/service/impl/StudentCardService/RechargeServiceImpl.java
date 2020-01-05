package com.example.group4.service.impl.StudentCardService;

import com.example.group4.bean.Mealcard;
import com.example.group4.bean.Po;
import com.example.group4.bean.Recharge_bill;
import com.example.group4.mapper.MealcardMapper;
import com.example.group4.mapper.PoMapper;
import com.example.group4.mapper.Recharge_billMapper;
import com.example.group4.mapper.ex.PoEXMapper;
import com.example.group4.service.StudentCardService.IRechargeService;
import org.omg.PortableServer.POA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RechargeServiceImpl implements IRechargeService {
    @Autowired
    private Recharge_billMapper recharge_billMapper;
    @Autowired
    private MealcardMapper mealcardMapper;
    @Autowired
    private PoEXMapper poEXMapper;
    public void AddSum(int id, double money){
        if(mealcardMapper.selectByPrimaryKey(id).getType()=="normal"){
            //添加充值表中的记录
            Recharge_bill recharge_bill=new Recharge_bill();
            recharge_bill.setMoney(money);
            recharge_bill.setCardId(id);
            recharge_bill.setTime(new Date());
            recharge_bill.setType("normal");
            recharge_billMapper.updateByPrimaryKey(recharge_bill);
            //修改饭卡中的余额
            double sum=mealcardMapper.selectByPrimaryKey(id).getMoney()+money;
            Mealcard mealcard=mealcardMapper.selectByPrimaryKey(id);
            mealcard.setMoney(sum);
            mealcardMapper.updateByPrimaryKey(mealcard);

        }

    }

    @Override
    public Po insertPrepay(int id, double money) {
        Po po = new Po();
        po.setPrice(""+money+"");
        po.setPoState("待支付");
        po.setPrdName("续费一年");
        po.setSysName("测试系统3");
        poEXMapper.insertPrepay(po);
        return po;
    }


}
