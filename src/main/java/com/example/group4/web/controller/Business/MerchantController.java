package com.example.group4.web.controller.Business;

import com.example.group4.bean.Business;
import com.example.group4.service.IMerchantService.IMerchantService;
import com.example.group4.util.Message;
import com.example.group4.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
