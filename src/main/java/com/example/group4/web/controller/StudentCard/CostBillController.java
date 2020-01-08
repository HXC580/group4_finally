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

    @GetMapping("/findById")
    @ApiOperation(value = "查询学生全部消费记录")
    public Message findById(int id,int start, int pagesize){
        return MessageUtil.success(costBillService.findById(id,(start-1)*pagesize,pagesize));
    }

    @GetMapping("/findByMoney")
    @ApiOperation(value = "查询消费金额大于等于输入值的记录")
    public Message findByMoney(int id,double money){
        return MessageUtil.success(costBillService.findByMoney(id,money));
    }

    @GetMapping("/sumById")
    @ApiOperation(value = "总消费金额")
    public Message sumById(int id){
        return MessageUtil.success(costBillService.sumById(id));
    }

    @GetMapping("/findByTime")
    @ApiOperation(value = "查询至今输入天数的消费记录")
    public Message findByTime(int id,int day){
        return MessageUtil.success(costBillService.findByTime(id,day));
    }

    @GetMapping("/sumByTime")
    @ApiOperation(value = "查询输入天数以来消费总金额")
    public Message sumByTime(int id,int day){
        return MessageUtil.success(costBillService.sumByTime(id,day));
    }

}
