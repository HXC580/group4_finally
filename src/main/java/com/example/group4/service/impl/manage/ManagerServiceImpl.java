package com.example.group4.service.impl.manage;

import com.example.group4.bean.*;
import com.example.group4.bean.ex.dangerEX;
import com.example.group4.mapper.*;

import com.example.group4.mapper.ex.Dormitory_ioEXMapper;
import com.example.group4.mapper.ex.ManagerEXMapper;
import com.example.group4.mapper.ex.MealcardEXMapper;
import com.example.group4.service.manage.IManagerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


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
    @Autowired
    private Dormitory_ioMapper dormitory_ioMapper;
    @Autowired
    private Dormitory_ioEXMapper dormitory_ioEXMapper;

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
    public List<Student> searchByS(String key, String word) {

        if(word==null||"".equals(word)){
            StudentExample example=new StudentExample();
            return studentMapper.selectByExample(example);
        }else if ("id".equals(key)&&!"".equals(word)){
            int a=Integer.parseInt(word);
            StudentExample example=new StudentExample();
            example.createCriteria().andIdEqualTo(a);
            System.out.println("id");
            return studentMapper.selectByExample(example);
        } else if ("name".equals(key)&&!"".equals(word)){
            word="%"+word+"%";

            System.out.println("name");

            return  managerEXMapper.search(word);
        }
        System.out.println("最后");

        return  null;
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

    @Override
    public void IOrecord(int card_id, String condition) {
        Dormitory_io io = new Dormitory_io();
        io.setId(null);
        io.setIotype(condition);
        io.setCardId(card_id);
        Date time = new Date();
        io.setTime(time);
        //io.setTime(null);
        dormitory_ioMapper.insert(io);

    }

    @Override
    public List<dangerEX> danger(String date) {

        String dateB=date+" 00:00:00";
        String dateE=date+" 23:59:59";


        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date DateB = null;
        Date DateE = null;
        try {
            DateB = df.parse(dateB);
            DateE = df.parse(dateE);

        } catch (ParseException e) {
            e.printStackTrace();
        }

//        Date date = new Date();//取时间
//        Calendar calendar = new GregorianCalendar();
//        calendar.add(calendar.DATE, 1);//把日期往后增加一天.整数往后推,负数往前移动

        return dormitory_ioEXMapper.danger(DateB,DateE);

    }

    @Override
    public List<Manager_Operation_List> list() {
        Manager_Operation_ListExample example = new Manager_Operation_ListExample();
        return manager_operation_listMapper.selectByExample(example);
    }
    //*****************************************************************************************************************************************************8
    public static String Later() {
        Date date = new Date();//取时间
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.YEAR, 1);//把日期往后增加一年.整数往后推,负数往前移动
        calendar.add(calendar.DAY_OF_MONTH, 1);//把日期往后增加一个月.整数往后推,负数往前移动
        calendar.add(calendar.DATE, 1);//把日期往后增加一天.整数往后推,负数往前移动
        return null;
    }

    //获取系统当前时间，字符串类型
    public static String getStrDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//设置为东八区
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        Date newDate = new Date();
        String dateStr = sdf.format(newDate);
        return dateStr;
    }

    //获取系统当前时间Date类型，需要将字符串类型转成时间
    public static Date getDaDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//设置为东八区
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        Date date = new Date();
        String dateStr = sdf.format(date);


//将字符串转成时间
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date newDate = null;
        try {
            newDate = df.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return newDate;
    }
    //CURRENT_TIMESTAMP

}