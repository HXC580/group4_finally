package com.example.group4.web.controller.StudentCard;

import com.example.group4.bean.Po;
import com.example.group4.service.impl.StudentCardService.RechargeServiceImpl;
import com.example.group4.util.Message;
import com.example.group4.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Api(description = "充值控制器")
public class RechargeController {
    private int id;
    private double money;
    private Boolean ef=false;
    @Autowired
    private RechargeServiceImpl rechargeService;

    @ApiOperation(value = "充值")
    @GetMapping("/Recharge")
    public Message Recharge(boolean flag){
        if(flag)
        {
            rechargeService.AddSum(id,money);
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
