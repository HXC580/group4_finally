package com.example.group4.service.student;


import java.util.ArrayList;
import java.util.HashMap;

public interface IWlanService {
    String selectPwdByStuId(int sid);
    void bindPwdByStuId(int id,String pwd);
    ArrayList<HashMap<String,Double>> getMessage(int sid , int pwd);
}
