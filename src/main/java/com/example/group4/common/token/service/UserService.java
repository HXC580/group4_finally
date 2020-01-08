package com.example.group4.common.token.service;

import com.example.group4.bean.Business;
import com.example.group4.bean.Manager;
import com.example.group4.bean.Student;
import com.example.group4.mapper.BusinessMapper;
import com.example.group4.mapper.ManagerMapper;
import com.example.group4.mapper.StudentMapper;
import com.example.group4.common.token.bean.User;
import com.example.group4.common.token.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private static ManagerMapper managerMapper;
    @Autowired
    private static StudentMapper studentMapper;
    @Autowired
    private static BusinessMapper businessMapper;
    @Autowired
    private UserMapper userMapper;

    public static User findByUsername(User user){
        String password;
        int ID=Integer.parseInt(user.getId());
        switch (user.getType()){
            case "business":
                Business business=businessMapper.selectByPrimaryKey(ID);
                password=business.getPass();
                user.setId(business.getId()+"");
                user.setPassword(password);
                return user;
            case "student":
                Student student=studentMapper.selectByPrimaryKey(ID);
                password=student.getPassword();
                user.setId(student.getId()+"");
                user.setPassword(password);
                return user;
            case "manager":
                Manager manager=managerMapper.selectByPrimaryKey(ID);
                password=manager.getPassword();
                return user;
            default:
                return user;
        }
    }
    public User findUserById(String userId,String type) {
        return userMapper.findUserById(userId,type);
    }
    public static User login(User user){
//        user
        return user;
    }
}
