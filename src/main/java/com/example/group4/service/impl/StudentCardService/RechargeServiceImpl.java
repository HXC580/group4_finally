package com.example.group4.service.impl.StudentCardService;

import com.example.group4.bean.Mealcard;
import com.example.group4.bean.Po;
import com.example.group4.bean.Recharge_bill;
import com.example.group4.mapper.MealcardMapper;
import com.example.group4.mapper.PoMapper;
import com.example.group4.mapper.Recharge_billMapper;
import com.example.group4.service.StudentCardService.IRechargeService;
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
    private PoMapper poMapper;
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
    public void insertPrepay(int id, double money) {
        Po po = new Po();
        po.setPrice(""+money+"");
        poMapper.insert(po);
    }


}
