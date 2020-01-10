package com.example.group4.web.controller.studentCard;

import com.example.group4.bean.Po;
import com.example.group4.common.getData.getDataFromMysql;
import com.example.group4.common.setData.setDataToMysql;
import com.example.group4.service.impl.studentCardService.RechargeServiceImpl;
import com.example.group4.util.Message;
import com.example.group4.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
@Api(description = "充值控制器")
public class RechargeController {
    private static int id;
    private  static double money;
    private Boolean ef=false;
    @Autowired
    private RechargeServiceImpl rechargeService;

    @ApiOperation(value = "充值")
    @RequestMapping(value = "Recharge",method = RequestMethod.GET)
    public Message Recharge(boolean flag){
        System.out.println(flag);
        if(flag)
        {
            String sql="select money from group4_3.mealcard where id='"+id+"'";
            ArrayList<String> arrayList=getDataFromMysql.getOnecolumnDataNoMap(sql,"money");
            System.out.println(            arrayList.get(0)+"");
            System.out.println("money:"+money);
            double money2=Double.parseDouble(arrayList.get(0)+"");
            money2+=money;
             money2 = new BigDecimal(money2).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

            sql="update group4_3.mealcard set money="+money2+" where id='"+id+"'";
            setDataToMysql.InsertOrUpdateDataToMysql(sql);
            sql="insert into group4_3.recharge_bill (type,card_id,money) values (\"normal\","+id+","+money+")";
            setDataToMysql.InsertOrUpdateDataToMysql(sql);
            return MessageUtil.success();
        }else {
            return  MessageUtil.error(1128,"支付失败");
        }
    }

    @ApiOperation(value = "设置每日消费上限")
    @ResponseBody
    @GetMapping("/updateCeiling")
    public Message updateCeiling(int id,double money){
        rechargeService.updateCeiling(id,money);
        return MessageUtil.success();
    }


    @GetMapping("/po")
    public String po(int id1,double money1){
        id=id1;
        money=money1;
        Po po=rechargeService.insertPrepay(id1, money1);
        return "redirect:/From?PO_NO="+po.getPoNo();
    }

}
