package com.example.group4.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class loginconfig {

    public static   String appID;//开发者ID
    public static   String appSecret;//开发者密码
    public static String loginUrl;//官方url
    public static String code;//微信授权登录微信给定的临时code

    public static void setCode(String code) {        loginconfig.code = code;    }

    @Value("${wx.loginUrl}")
    public  void setLoginUrl(String loginUrl) {        this.loginUrl = loginUrl;    }

    @Value("${wx.appSecret}")
    public  void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    @Value("${wx.appID}")
    public  void setAppID(String appID) {
        this.appID = appID;
    }


}
