package com.example.group4.web.controller.business;

import com.example.group4.bean.Machine;
import com.example.group4.service.imerchantService.IMachineService;
import com.example.group4.util.Message;
import com.example.group4.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/machine")
@Api(description = "商户机器管理")
public class MachineController {
    @Autowired
    private IMachineService machineService;

    @ApiImplicitParam(name = "id",value = "商户id",required = true,paramType = "query", dataType = "int")
    @GetMapping("/findMacById")
    @ApiOperation(value = "根据商户id查询机器")
    public Message findMacById(int id){
        return MessageUtil.success(machineService.findById(id));
    }

    @ApiImplicitParam(name = "macId",value = "机器id",required = true,paramType = "query",dataType = "int")
    @GetMapping("/findMacByMacId")
    @ApiOperation(value = "根据机器id找机器")
    public Message findMacByMacId(int macId){
        return MessageUtil.success(machineService.findMacByMacId(macId));
    }

    @GetMapping("/fuzzyQueMacByAddr")
    @ApiOperation("根据地址模糊查询机器")
    public Message fuzzyQueMacByAddr(String word,int busId){
        return MessageUtil.success(machineService.fuzzyQueMacByAddr(word,busId));
    }

    @PostMapping("/editMac")
    @ApiOperation(value = "修改机器")
    public Message editMac(Machine machine){
        machineService.editOrAddMac(machine);
        return MessageUtil.success();
    }

    @PostMapping("/addMac")
    @ApiOperation(value = "增加机器")
    public Message addMac(Machine machine){
        machineService.editOrAddMac(machine);
        return MessageUtil.success();
    }

    @ApiImplicitParam(name = "ids",value = "机器id",required = true,paramType = "query",allowMultiple=true, dataType = "int")
    @ApiOperation(value = "批量删除机器")
    @GetMapping("delMac")
    public Message delMac(int[] ids){
        machineService.delMac(ids);
        return MessageUtil.success();
    }

    @GetMapping("recordBill")
    @ApiOperation(value = "记录饭卡消费")
    public Message recordBill(int cardId,double money,int machineId){
        String result = machineService.recordBill(cardId,money,machineId);
        if ("饭卡异常"==result){
            return MessageUtil.error(200,"饭卡异常");
        }
        if ("超过饭卡限额"==result){
            return MessageUtil.error(200,"超过饭卡限额");
        }else if ("余额不足，请充值！"==result){
            return MessageUtil.error(200,"余额不足，请充值！");
        }else {
            return MessageUtil.success();
        }
    }
}
