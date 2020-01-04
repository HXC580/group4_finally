package com.example.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.group4.mapper")
@SpringBootApplication
public class Project1Application {

    public static void main(String[] args) {
        SpringApplication.run(Project1Application.class, args);
    }

}
