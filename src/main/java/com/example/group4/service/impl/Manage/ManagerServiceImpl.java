package com.example.group4.service.impl.Manage;

import com.example.group4.bean.*;
import com.example.group4.mapper.*;

import com.example.group4.mapper.ex.ManagerEXMapper;
import com.example.group4.mapper.ex.MealcardEXMapper;
import com.example.group4.service.Manage.IManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
    private ManagerEXMapper managerEXMapper;
    @Autowired
    private BusinessMapper businessMapper;
    @Autowired
    private DormitoryMapper dormitoryMapper;
    @Autowired
    private MealcardEXMapper mealcardEXMapper;
    @Autowired
    private MealcardMapper mealcardMapper;

    @Override
    public void ModifyStudent(Student student) {
        StudentExample studentExamples = new StudentExample();
        studentExamples.createCriteria().andIdEqualTo(student.getId());
        studentMapper.updateByExample(student, studentExamples);

    }

    @Override
    public List<Student> selectAllStudent() {

        StudentExample example = new StudentExample();
        return studentMapper.selectByExample(example);
    }

    @Override
    public Student searchBy1() {
        return null;
    }

    public void freeze(int card_id, int manager_id) {
        Manager_Operation_List operation = new Manager_Operation_List();
        //设置时间
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        Date date = new Date();
//        SimpleDateFormat dateFormat_min=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");//设置当前时间的格式，为年-月-日 时-分-秒
//        dateFormat_min.format(date);
        operation.setTime(date);
        //插入操作数据记录
        operation.setCardId(card_id);
        operation.setManagerId(manager_id);
        operation.setType("freeze");
        manager_operation_listMapper.insert(operation);
        //修改学生卡信息
        mealcardEXMapper.freeze(card_id);

    }

    public void abfreeze(int card_id, int manager_id) {
        Manager_Operation_List operation = new Manager_Operation_List();
        //设置时间
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        Date date = new Date();
//        SimpleDateFormat dateFormat_min=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");//设置当前时间的格式，为年-月-日 时-分-秒
//        dateFormat_min.format(date);
        operation.setTime(date);
        //插入操作数据记录
        operation.setCardId(card_id);
        operation.setManagerId(manager_id);
        operation.setType("abfreeze");
        manager_operation_listMapper.insert(operation);
        //修改学生卡信息
        mealcardEXMapper.abfreeze(card_id);

    }

    @Override
    public List<Mealcard> selectAllMealcard() {
        MealcardExample example = new MealcardExample();
        return mealcardMapper.selectByExample(example);
    }

    @Override
    public Mealcard searchBy2() {
        return null;
    }

    @Override
    public void modify(Manager manager) {
        managerEXMapper.updatebyId(manager.getId(), manager.getPhonenumber());
    }

    @Override
    public Manager selectManageown(int id) {
        return managerMapper.selectByPrimaryKey(id);
    }

    @Override
    public void logout(int student_id, int card_id, int manager_id) {

    }

    @Override
    public void addBusiness(Business business) {
        businessMapper.insert(business);
    }

    @Override
    public List<Business> selectAllBusiness() {
        BusinessExample example = new BusinessExample();
        return businessMapper.selectByExample(example);
    }

    @Override
    public Business searchBy3() {
        return null;
    }

    @Override
    public void modify(Dormitory dormitory) {
        dormitoryMapper.updateByPrimaryKey(dormitory);
    }

    @Override
    public List<Dormitory> selectAllDormitory() {
        DormitoryExample example = new DormitoryExample();
        return dormitoryMapper.selectByExample(example);
    }

    @Override
    public void modifyBusiness(Business business) {
        if (business == null) {
            throw new RuntimeException("参数为空");
        }
        if (business.getId() == null) {
            businessMapper.insert(business);

        } else {

            businessMapper.updateByPrimaryKey(business);

        }

    }
}