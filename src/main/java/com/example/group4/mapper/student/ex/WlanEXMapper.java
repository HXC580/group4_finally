package com.example.group4.mapper.student.ex;

import org.apache.ibatis.annotations.Insert;

public interface WlanEXMapper {
    String  selectPwdByStuId(int sid);
    @Insert(" insert into group4_3.wlan (pass,student_id) value (#{pwd},#{id})")
    void bindPwdByStuId(String id ,String pwd);
}
