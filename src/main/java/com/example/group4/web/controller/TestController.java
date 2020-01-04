package com.example.group4.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
@GetMapping("Test")
    public static String test01x(){
    System.out.println("shabi");
    return "shabi";
}
}
