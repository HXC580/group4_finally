package com.example.group4.web.controller.student;

import com.example.group4.service.student.IWlanService;

import com.example.group4.util.Message;
import com.example.group4.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;


@Controller
@RequestMapping("/MarginQuery")
@Api(description = "余量查询")
public class MarginQueryController {

    @Autowired
    private IWlanService iWlanService;


    @GetMapping("marginQuery")
    @ApiOperation(value="余量查询")
    public String  marginQuery(int  sid){
        String pwd = null;
        String  url;
        pwd=iWlanService.selectPwdByStuId(sid);

        if(pwd==null||pwd.trim().equals("")){

            url = "error2.html";
        }else {
            url = "redirect:http://10.126.1.30/login?DDDDD=" + sid + "&upass=" + pwd + "&R1=0&R2=&R3=0&R6=0&para=00&0MKKey=123456&buttonClicked=&redirect_url=&err_flag=&username=&password=&user=&cmd=&Login=&v6ip=";
        }
        return url;
    }



    @GetMapping("getMessage")
    @ResponseBody()
    @ApiOperation(value="得到流量信息")
    public Message bind(int  sid, int pwd){
        ArrayList<HashMap<String,Double>>  list= iWlanService.getMessage(sid, pwd);
        System.out.println(list);
        return MessageUtil.success(list);

    }

    @GetMapping("binding")
    @ResponseBody()
    @ApiOperation(value="绑定")
    public Message bind(int  sid, String pwd){
        iWlanService.bindPwdByStuId(sid,pwd);
        return MessageUtil.success();

    }




}
