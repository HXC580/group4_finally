package com.example.group4.web.controller.StudentCard;

import com.example.group4.service.impl.StudentCardService.RechargeServiceImpl;
import com.example.group4.util.Message;
import com.example.group4.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Api(description = "充值控制器")
public class RechargeController {
    private int id;
    private double money;
    @Autowired
    private RechargeServiceImpl rechargeService;

    @ApiOperation(value = "充值")
    @GetMapping("/Recharge")
    public Message Recharge(){
        rechargeService.AddSum(id,money);
        return MessageUtil.success();
    }
    @GetMapping("/test")
    public String test(int id){
        return "redirect:/From?PO_NO=id";
    }

    @GetMapping("/po")
    public String po(int id1,double money1){
        id=id1;
        money=money1;
        rechargeService.AddSum(id1,money1);
        return "redirect:/From?PO_NO=id1";
    }
}
