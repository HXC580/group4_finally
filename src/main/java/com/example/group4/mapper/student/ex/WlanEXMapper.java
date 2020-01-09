package com.example.group4.mapper.student.ex;

public interface WlanEXMapper {
    String  selectPwdByStuId(int sid);
    void bindPwdByStuId(int id ,String pwd);
    void setBind(int id,String pwd);
}
