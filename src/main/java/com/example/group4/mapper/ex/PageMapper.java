package com.example.group4.mapper.ex;

import org.apache.ibatis.annotations.Select;

public interface PageMapper {
    @Select("select count(*) from #{tableName}")
    public int getCount(String TableName);
}
