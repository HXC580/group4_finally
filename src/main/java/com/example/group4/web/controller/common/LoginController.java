//package com.example.group4.web.controller.common;
//
//import com.example.group4.common.token.util.TokenUtil;
//import com.example.group4.service.LoginService;
//import com.example.group4.service.impl.LoginImpl;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
////@GetMapping("Login")
//public class LoginController {
//    @PostMapping("Login")
//    public String Login(String pass,String id,String type)   {
//
//        boolean flag= LoginService.login(id,pass,type);
//        if (flag){
//          TokenUtil.createJwtToken(id,type);
//        }
//        return flag+"";
//    }
//}
