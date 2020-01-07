package com.example.group4.web.controller.Manage;


import com.example.group4.bean.Business;
import com.example.group4.bean.Dormitory;
import com.example.group4.bean.Manager;
import com.example.group4.bean.Student;

import com.example.group4.service.Manage.IManagerService;
import com.example.group4.util.Message;
import com.example.group4.util.MessageUtil;
import io.swagger.annotations.Api;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Manage")
@Api(description = "管理员功能")
public class ManageController {
    @Autowired
    private IManagerService managerService;
    @PostMapping("/modifyStudent")
    @ApiOperation(value = "修改学生信息")
    public Message modifyStudent(Student student){
        managerService.ModifyStudent(student);
        return MessageUtil.success();
    }
    @GetMapping("/selectAllStudent")
    @ApiOperation(value = "查询所有学生信息")
    public Message selectAllStudent(){
        return MessageUtil.success(managerService.selectAllStudent());
    }

    @GetMapping("/freeze")
    @ApiOperation(value = "冻结")
    public Message freeze(int card_id,int manager_id){
        managerService.freeze(card_id,manager_id);
        return MessageUtil.success();

    }
    @GetMapping("/abfreeze")
    @ApiOperation(value = "解冻")
    public Message abfreeze(int card_id,int manager_id){
        managerService.abfreeze(card_id,manager_id);
        return MessageUtil.success();
    }
    @GetMapping("/selectAllcard")
    @ApiOperation(value = "查询所有饭卡信息")
    public Message selectAllcard(){
        return MessageUtil.success(managerService.selectAllMealcard());
    }
    @GetMapping("销户(未实现)")
    @ApiOperation(value = "销户(未实现)")
    public Message logout(int student_id,int card_id,int manager_id){
        managerService.logout(student_id,card_id,manager_id);
        return MessageUtil.success();
    }
    @GetMapping("/modify")
    @ApiOperation(value = "管理个人信息")
    public Message modify(Manager manager){
        managerService.modify(manager);
        return MessageUtil.success();
    }

    @GetMapping("/selectManageown")
    @ApiOperation(value = "查询本人信息")

    public Message selectManageown(int id){
        return MessageUtil.success(managerService.selectManageown(id));
    }


    @PostMapping("/addBusiness")
    @ApiOperation(value = "添加商户")
    public Message addBusiness(Business business){
        managerService.addBusiness(business);
        return MessageUtil.success();
    }
    @PostMapping("/ModifyBusiness")
    @ApiOperation(value = "修改商户信息")
    public Message ModifyBusiness(Business business){
        managerService.modifyBusiness(business);
        return MessageUtil.success();
    }


    @GetMapping("/selectAllBusiness()")
    @ApiOperation(value = "查询商户")
    public Message selectAllBusiness(){
        return MessageUtil.success(managerService.selectAllBusiness());
    }
    @PostMapping("/modifyDormitory")
    @ApiOperation(value = "修改楼长")

    public Message modifyDormitory(Dormitory dormitory){
        managerService.modify(dormitory);
        return MessageUtil.success();
    }
    @GetMapping("/selectAllDormitory")
    @ApiOperation(value = "查询宿舍楼信息")
    public Message selectAllDormitory(){
        return MessageUtil.success(managerService.selectAllDormitory());
    }

    @PostMapping("/IOrecord")
    @ApiOperation(value = "进出宿舍")
    public Message IOrecord(int id,String condition){
        managerService.IOrecord(id,condition);
        return MessageUtil.success();
    }
    @GetMapping("/danger")
    @ApiOperation(value = "查询夜不归宿 yy-MM-dd")
    public Message danger(String date){
        return MessageUtil.success( managerService.danger(date));
    }
    @GetMapping("/operation")
   // @Api(description = "dd")
    @ApiOperation(value = "查询管理员操作记录")
    public Message operation(){
        return MessageUtil.success(managerService.list());
    }



}
