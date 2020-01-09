package com.example.group4.service.Student.impl;

import com.example.group4.mapper.student.ex.WlanEXMapper;
import com.example.group4.service.Student.IWlanService;
import com.example.group4.util.TestJsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

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
        //wlanEXMapper.bindPwdByStuId(id,pwd);
        wlanEXMapper.setBind(id,pwd);

    }

    @Override
    public ArrayList<HashMap<String,Double>> getMessage(int sid, int pwd) {
        TestJsoup testJsoup=new TestJsoup();
        ArrayList<String> test=new ArrayList();
        ArrayList<HashMap<String,Double>> meg=new ArrayList();
        HashMap<String,Double> hashMap=new HashMap<>();
        try {
            test = testJsoup.test(String.valueOf(sid), String.valueOf(pwd));

//
            hashMap.put("time",Double.valueOf(test.get(0)));
            hashMap.put("flow",Double.valueOf(test.get(1))/1024);
            hashMap.put("money",Double.valueOf(test.get(2))/10000);
            meg.add(hashMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  meg;
    }
}
