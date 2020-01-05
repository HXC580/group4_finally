package com.example.group4.web.controller.Manage;


import com.example.group4.bean.Business;
import com.example.group4.bean.Dormitory;
import com.example.group4.bean.Manager;
import com.example.group4.bean.Student;

import com.example.group4.service.Manage.IManagerService;
import com.example.group4.util.Message;
import com.example.group4.util.MessageUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Manage")
@Api(description = "管理员功能")
public class ManageController {
    @Autowired
    private IManagerService managerService;
    @PostMapping("/修改大学生信息")
    public Message modifyStudent(Student student){
        managerService.ModifyStudent(student);
        return MessageUtil.success();
    }
    @GetMapping("/查询所有大学生信息")
    public Message selectAllStudent(){
        return MessageUtil.success(managerService.selectAllStudent());
    }

    @GetMapping("冻结")
    public Message freeze(int card_id,int manager_id){
        managerService.freeze(card_id,manager_id);
        return MessageUtil.success();

    }
    @GetMapping("解冻")
    public Message abfreeze(int card_id,int manager_id){
        managerService.abfreeze(card_id,manager_id);
        return MessageUtil.success();
    }
    @GetMapping("查询所有饭卡信息")
    public Message selectAllcard(){
        return MessageUtil.success(managerService.selectAllMealcard());
    }
    @GetMapping("销户")
    public Message logout(int student_id,int card_id,int manager_id){
        managerService.logout(student_id,card_id,manager_id);
        return MessageUtil.success();
    }
    @GetMapping("管理个人信息")
    public Message modify(Manager manager){
        managerService.modify(manager);
        return MessageUtil.success();
    }

    @GetMapping("查询本人信息")
    public Message selectManageown(int id){
        return MessageUtil.success(managerService.selectManageown(id));
    }
    @PostMapping("添加商户")
    public Message addBusiness(Business business){
        managerService.addBusiness(business);
        return MessageUtil.success();
    }
    @GetMapping("查询商户")
    public Message selectAllBusiness(){
        return MessageUtil.success(managerService.selectAllBusiness());
    }
    @PostMapping("修改楼长")
    public Message modifyDormitory(Dormitory dormitory){
        managerService.modify(dormitory);
        return MessageUtil.success();
    }
    @GetMapping("查询宿舍楼信息")
    public Message selectAllDormitory(){
        return MessageUtil.success(managerService.selectAllDormitory());
    }


}
