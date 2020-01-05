package com.example.group4.web.controller;

import com.example.group4.bean.ex.Page;
import com.example.group4.service.impl.PageImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
@GetMapping("Test")
    public  String test01x(){
    Page page=new Page();
    page.setN(5);
//    page.setTableName();
//    PageImpl.GetPageNumber();
    System.out.println("shabi");
    return "shabi";
}
}
