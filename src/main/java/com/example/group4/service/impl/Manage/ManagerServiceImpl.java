package com.example.group4.service.impl.Manage;

import com.example.group4.bean.Manager_Operation_List;
import com.example.group4.bean.Student;
import com.example.group4.bean.StudentExample;
import com.example.group4.mapper.Manager_Operation_ListMapper;
import com.example.group4.mapper.MealcardMapper;
import com.example.group4.mapper.StudentMapper;
import com.example.group4.mapper.ManagerMapper;

import com.example.group4.service.Manage.IManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

@Service
public class ManagerServiceImpl implements IManagerService {
    @Autowired
    private ManagerMapper managerMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private Manager_Operation_ListMapper manager_operation_listMapper;
    @Autowired
    private MealcardMapper mealcardMapper;
    @Override
    public void ModifyStudent(Student student) {
        StudentExample studentExamples=new StudentExample();
        studentExamples.createCriteria().andIdEqualTo(student.getId());
        studentMapper.updateByExample(student,studentExamples);

    }

    public void freeze(int card_id,int manager_id){
        Manager_Operation_List operation=new Manager_Operation_List();
        //设置时间
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        Date date=new Date();
//        SimpleDateFormat dateFormat_min=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");//设置当前时间的格式，为年-月-日 时-分-秒
//        dateFormat_min.format(date);
        operation.setTime(date);

        //插入操作数据记录

        operation.setCardId(card_id);
        operation.setManagerId(manager_id);
        operation.setType("freeze");
        manager_operation_listMapper.insert(operation);
        //修改学生卡信息


        mealcardMapper.updateByExample();



    }
}
