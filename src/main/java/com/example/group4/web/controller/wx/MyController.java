package com.example.group4.web.controller.wx;

import com.example.group4.bean.Student;
import com.example.group4.common.setData.setDataToMysql;
import com.example.group4.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class MyController {
    @Autowired
    private StudentMapper studentMapper;
    @GetMapping(value = "myBang")
    public String myBang(String open_id,String pass,String id){
        Student student=studentMapper.selectByPrimaryKey(Integer.parseInt(id));
        if (student.getPassword().equals(pass)){
            String sql="UPDATE group4_3.wx SET studentId='"+id+"' where open_id="+open_id;
            setDataToMysql.InsertOrUpdateDataToMysql(sql);
            return "true";
        }else {
            return "false";

        }

    }
}
