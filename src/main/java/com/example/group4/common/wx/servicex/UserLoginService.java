package com.example.group4.common.wx.servicex;

public interface UserLoginService {
    boolean login(String id, String pass);
    boolean changePass(String NewPass);
}
