package com.example.group4.web.controller.StudentCard;

import com.example.group4.service.impl.StudentCardService.CostBillServiceImpl;
import com.example.group4.util.Message;
import com.example.group4.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "消费记录管理")
public class CostBillController {
    @Autowired
    private CostBillServiceImpl costBillService;

    @GetMapping("/findAll")
    @ApiOperation(value = "查询全部消费记录")
    public Message findAll(int start, int pagesize){
        return MessageUtil.success(costBillService.findAll((start-1)*pagesize,pagesize));
    }

    @GetMapping("/findByMoney")
    @ApiOperation(value = "查询消费金额大于等于输入值的记录")
    public Message findByMoney(double money){
        return MessageUtil.success(costBillService.findByMoney(money));
    }

    @GetMapping("/sum")
    @ApiOperation(value = "总消费金额")
    public Message sum(){
        return MessageUtil.success(costBillService.sum());
    }

    @GetMapping("/findByTime")
    @ApiOperation(value = "查询至今输入天数的消费记录")
    public Message findByTime(int day){
        return MessageUtil.success(costBillService.findByTime(day));
    }

    @GetMapping("/sumByTime")
    @ApiOperation(value = "查询输入天数以来消费总金额")
    public Message sumByTime(int day){
        return MessageUtil.success(costBillService.sumByTime(day));
    }

}
