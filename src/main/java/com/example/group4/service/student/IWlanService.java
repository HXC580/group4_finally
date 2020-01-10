package com.example.group4.service.Student;


import java.util.ArrayList;
import java.util.HashMap;

public interface IWlanService {
    String selectPwdByStuId(int sid);
    void bindIdAndPwd(int id,String pwd);
    ArrayList<HashMap<String,Double>> getMessage(int sid , String pwd);
}
