package com.example.group4.web.controller.student;

import com.example.group4.bean.Lend_list;
import com.example.group4.bean.Mealcard;
import com.example.group4.bean.Student;
import com.example.group4.mapper.WlanMapper;
import com.example.group4.service.Student.IWlanService;
import com.example.group4.util.Message;
import com.example.group4.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/MarginQuery")
@Api(description = "余量查询")
public class MarginQueryController {

    @Autowired
    private IWlanService iWlanService;


    @GetMapping("/displayAllWaln")
    @ApiOperation(value="余量查询")
    public String  selectAllWlan(int  sid){
        String pwd = iWlanService.selectpwdByStuId(sid);


        String  url="redirect:http://10.126.1.30/login?DDDDD="+sid+"&upass="+pwd+"&R1=0&R2=&R3=0&R6=0&para=00&0MKKey=123456&buttonClicked=&redirect_url=&err_flag=&username=&password=&user=&cmd=&Login=&v6ip=";
        return url;

    }

}
