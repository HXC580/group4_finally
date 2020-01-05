package com.example.group4.service.Student.impl;

import com.example.group4.bean.Mealcard;
import com.example.group4.bean.Student;
import com.example.group4.bean.Wlan;
import com.example.group4.mapper.MealcardMapper;
import com.example.group4.mapper.StudentMapper;
import com.example.group4.mapper.WlanMapper;
import com.example.group4.mapper.student.ex.WlanEXMapper;
import com.example.group4.service.Student.IWlanService;
import org.springframework.beans.factory.annotation.Autowired;

public class WlanServiceImpl implements IWlanService {
    @Autowired
    private WlanEXMapper wlanEXMapper;
    @Autowired
    private StudentMapper studentMapper;


    @Override
    public String selectpwdByStuId(int sid) {
        String pwd=  wlanEXMapper.selectPwdByStuId(sid);
        return pwd;
    }
}
