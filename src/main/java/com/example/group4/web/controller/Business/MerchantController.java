package com.example.group4.web.controller.Business;

import com.example.group4.bean.Business;
import com.example.group4.bean.Cost_bill;
import com.example.group4.service.IMerchantService.IMerchantService;
import com.example.group4.util.Message;
import com.example.group4.util.MessageUtil;
import com.google.common.base.Utf8;
import io.swagger.annotations.ApiImplicitParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/business")
public class MerchantController {
    @Autowired
    private IMerchantService merchantService;

    @GetMapping("/detail")
    public Message queById(int id){
        return MessageUtil.success(merchantService.queById(id));
    }

    @GetMapping("/update")
    public Message update(Business business){
        System.out.println(business.getPhonenumber().getClass().toString());
        //有问题

        merchantService.saveOrUpdate(business);
        return MessageUtil.success();
    }

    @PostMapping("/selectCollectionRecords")
    public Message selectCollectionRecords(@RequestBody Date startDate,@RequestBody Date endDate, int id){
        return MessageUtil.success(merchantService.selectCollectionRecords(startDate,endDate,id));
    }

    @GetMapping("/profit")
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
