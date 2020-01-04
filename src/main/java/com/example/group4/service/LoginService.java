package com.example.group4.service;

public interface LoginService {
    boolean login(String id,String pass,String type);
    boolean changePass(String NewPass);
}
