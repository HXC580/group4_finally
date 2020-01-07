package com.example.group4.bean.ex;

import net.sourceforge.jtds.jdbc.DateTime;

import java.util.Date;

public class dangerEX {
    private Integer student_id;

    private Integer io_id;

    private Integer card_id;

    private Date time;

    private String IOtype;

    private  String name;

    private Integer age;

    private String phonenumber;

    private String gender;

    private String dormitory_id;

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public Integer getIo_id() {
        return io_id;
    }

    public void setIo_id(Integer io_id) {
        this.io_id = io_id;
    }

    public Integer getCard_id() {
        return card_id;
    }

    public void setCard_id(Integer card_id) {
        this.card_id = card_id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getIOtype() {
        return IOtype;
    }

    public void setIOtype(String IOtype) {
        this.IOtype = IOtype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDormitory_id() {
        return dormitory_id;
    }

    public void setDormitory_id(String dormitory_id) {
        this.dormitory_id = dormitory_id;
    }
}
