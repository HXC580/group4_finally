package com.example.group4.web.controller.Manage;


import com.example.group4.bean.Business;
import com.example.group4.bean.Dormitory;
import com.example.group4.bean.Manager;
import com.example.group4.bean.Student;

import com.example.group4.service.Manage.IManagerService;
import com.example.group4.testHXC.pay;
import com.example.group4.util.Message;
import com.example.group4.util.MessageUtil;
import io.swagger.annotations.Api;

import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
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
    @GetMapping("/Aalipay")
    // @Api(description = "dd")
    @ApiOperation(value = "测试支付")
    public Message alipay(String id){
      pay pay= new pay();
     return MessageUtil.success(pay.rest(id));
    }









    @GetMapping("/excell")
    // @Api(description = "dd")
    @ApiOperation(value = "导出excell表格")
    public void outExcell(HttpServletResponse response)throws IOException {
    List<Student> list=managerService.selectAllStudent();

        // 1.创建工作簿
        XSSFWorkbook workbook = new XSSFWorkbook();

        // 2. 创建工作表格
        XSSFSheet sheet = workbook.createSheet("课调信息");

        // 3.创建行
        XSSFRow row = sheet.createRow(0);
        // 4.创建单元格
        XSSFCell cell = row.createCell(0);
        // 5.设置单元格数据类型
        cell.setCellType(CellType.STRING);
        //6.设置单元格内容
        cell.setCellValue("还有七天就结束了");

        /*
         *      / 告诉浏览器用什么软件可以打开此文件
                 response.setHeader("content-Type", "application/vnd.ms-excel");
                   // 下载文件的默认名称
                   response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(excelName+".xlsx", "utf-8"));

         */
        response.setHeader("content-Type", "application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode("李四课调.xlsx", "utf-8"));
        workbook.write(response.getOutputStream());

    }




}
