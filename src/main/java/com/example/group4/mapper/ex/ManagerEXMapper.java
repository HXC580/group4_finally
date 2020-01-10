package com.example.group4.mapper.ex;

import com.example.group4.bean.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ManagerEXMapper {
    void updatebyId(@Param("id") int id, @Param("phone") String phone);
    List<Student> search(String word);
}
