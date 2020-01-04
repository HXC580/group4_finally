package com.example.group4.mapper;

import com.example.group4.bean.Dormitory_io;
import com.example.group4.bean.Dormitory_ioExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Dormitory_ioMapper {
    long countByExample(Dormitory_ioExample example);

    int deleteByExample(Dormitory_ioExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Dormitory_io record);

    int insertSelective(Dormitory_io record);

    List<Dormitory_io> selectByExample(Dormitory_ioExample example);

    Dormitory_io selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Dormitory_io record, @Param("example") Dormitory_ioExample example);

    int updateByExample(@Param("record") Dormitory_io record, @Param("example") Dormitory_ioExample example);

    int updateByPrimaryKeySelective(Dormitory_io record);

    int updateByPrimaryKey(Dormitory_io record);
}