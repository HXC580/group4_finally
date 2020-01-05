package com.example.group4.web.controller.Business;

import com.example.group4.bean.Business;
import com.example.group4.service.IMerchantService.IMerchantService;
import com.example.group4.util.Message;
import com.example.group4.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/business")
@Api(description = "商户管理")
public class MerchantController {
    @Autowired
    private IMerchantService merchantService;

    @GetMapping("/detail")
    @ApiOperation(value = "查询商户信息")
    @ApiImplicitParam(name = "id",value = "商户id",dataType = "int", paramType = "query")
    public Message queById(int id){
        return MessageUtil.success(merchantService.queById(id));
    }

    @GetMapping("/update")
    @ApiOperation(value = "修改商户信息")
    public Message update(Business business){
        System.out.println(business.getPhonenumber().getClass().toString());
        //有问题

        merchantService.saveOrUpdate(business);
        return MessageUtil.success();
    }

    @PostMapping("/selectCollectionRecords")
    @ApiOperation(value = "查询收款记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "商户id",paramType = "query",dataType = "int"),
            @ApiImplicitParam(name = "startDate",value = "开始日期"),
            @ApiImplicitParam(name = "endDate", value = "结束日期")
    })
    public Message selectCollectionRecords(@RequestBody Date startDate,@RequestBody Date endDate, int id){
        return MessageUtil.success(merchantService.selectCollectionRecords(startDate,endDate,id));
    }

    @GetMapping("/profit")
    @ApiOperation(value = "查询总收入")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "商户id",paramType = "query",dataType = "int"),
            @ApiImplicitParam(name = "startDate",value = "开始日期"),
            @ApiImplicitParam(name = "endDate", value = "结束日期")
    })
    public Message profit(Date startDate,Date endDate,int id){
       return MessageUtil.success(merchantService.getProfit(startDate,endDate,id));
    }


    public Message message(Object object,int code){
        if(object == null){
            return MessageUtil.error(200,"参数为空");
        }
        else {
            if(code==0)
                return MessageUtil.success();
            else
                return MessageUtil.success(object);
        }
    }
}
