package com.example.group4.common.token;

import com.example.group4.common.token.all_interface.CurrentUser;
import com.example.group4.common.token.all_interface.LoginRequired;
import com.example.group4.common.token.bean.User;
import com.example.group4.common.token.service.UserService;
import com.example.group4.common.token.util.TokenUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class test {
    @LoginRequired
    @RequestMapping(value = "/token")
    public String token(@CurrentUser User userBase, String account, String token) {

//        Claims claims= Jwts.(token);
        if (UserService.findByUsername(userBase) == null) {
            return "账号不存在";
        } else {
            User result = null;
            result = UserService.login(userBase);
            if (result == null) {
                return  "密码错误";
            } else {

                return "SUCCESS";
            }
        }
    }

}
