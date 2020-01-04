package com.example.group4.web.controller.student;


import com.example.group4.bean.Lend_list;
import com.example.group4.bean.Return_list;
import com.example.group4.bean.student.ex.Lend_listEX;
import com.example.group4.service.Student.IBookService;
import com.example.group4.util.Message;
import com.example.group4.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Book")
@Api(description = "借阅管理")

public class BookController {

    @Autowired
    private IBookService iBookService ;

    @GetMapping("/displayAllLendList")
    @ApiOperation(value="获取全部借书信息")
    public Message displayAllLendList(){
        List<Lend_list> list=iBookService.displayAllLendList();
        return MessageUtil.success(list);

    }

    @GetMapping("/displayAllReturnList")
    @ApiOperation(value="获取全部还书信息")
    public Message displayAllReturnList(){
        List<Return_list> list=iBookService.displayAllReturnList();
        return MessageUtil.success(list);

    }

    @GetMapping("/selectAllLendList")
    @ApiOperation(value="获取全部还书详细信息")
    public Message selectAllLendList(){
        List<Lend_listEX> list=iBookService.selectAllLendList();
        return MessageUtil.success(list);

    }

    @GetMapping("/selectByKey")
    @ApiOperation(value="根据关键字获取全部还书详细信息")
    public Message selectByKey(String key){
        key="%"+key+"%";
        List<Lend_listEX> list=iBookService.selectByKey(key);
        return MessageUtil.success(list);

    }

}
