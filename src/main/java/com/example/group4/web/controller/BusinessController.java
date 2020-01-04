package com.example.group4.web.controller;

import com.example.group4.service.IMerchantService;
import com.example.group4.util.Message;
import com.example.group4.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("business")
public class BusinessController {
    @Autowired
    IMerchantService merchantService;

    @GetMapping("/detail")
    public Message detail(int id){
        return MessageUtil.success(merchantService.queById(id));
    }


}
