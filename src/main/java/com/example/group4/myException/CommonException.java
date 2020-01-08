package com.example.group4.myException;

public class CommonException extends Exception {
    public CommonException(int code, String Message){
        super();
        System.out.println("Error_code:"+code+"\nMessage"+Message);
    }
}
