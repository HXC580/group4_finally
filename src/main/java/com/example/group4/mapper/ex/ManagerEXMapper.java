package com.example.group4.mapper.ex;

import org.apache.ibatis.annotations.Param;

public interface ManagerEXMapper {
    void updatebyId(@Param("id") int id, @Param("phone") String phone);
}
