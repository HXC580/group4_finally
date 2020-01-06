package com.example.group4.service.Student;


public interface IWlanService {
    String selectPwdByStuId(int sid);
    void bindPwdByStuId(int id,String pwd);
}
