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
import org.springframework.stereotype.Service;

@Service
public class WlanServiceImpl implements IWlanService {
    @Autowired
    private WlanEXMapper wlanEXMapper;
   /* @Autowired
    private WlanMapper wlanMapper;
*/

    @Override
    public String selectPwdByStuId(int sid) {
        String pwd = wlanEXMapper.selectPwdByStuId(sid);
        return pwd;
    }

    @Override
    public void bindPwdByStuId(int id,String pwd) {
        wlanEXMapper.bindPwdByStuId(id,pwd);

    }
}
