package com.example.group4.service.impl;

import com.example.group4.bean.Business;
import com.example.group4.bean.Manager;
import com.example.group4.bean.Student;
import com.example.group4.mapper.BusinessMapper;
import com.example.group4.mapper.ManagerMapper;
import com.example.group4.mapper.StudentMapper;
import com.example.group4.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginImpl implements LoginService {

@Autowired
private  ManagerMapper managerMapper;
@Autowired
private  StudentMapper studentMapper;
@Autowired
private  BusinessMapper businessMapper;
@Override
    public  boolean login(String id, String pass, String type)throws RuntimeException {
        int ID=Integer.parseInt(id);
        String password=null;
        switch (type){
             case "business":
                         Business business=businessMapper.selectByPrimaryKey(ID);
                         break;
            case "student":
                        Student student=studentMapper.selectByPrimaryKey(ID);
                        password=student.getPassword();
                        break;
            case "manager":
                        Manager manager=managerMapper.selectByPrimaryKey(ID);
                        password=manager.getPassword();
                        break;
            default:
                break;
}
if (password.trim().equals(pass)){
return false;
}else {
    return false;

}
    }

}
