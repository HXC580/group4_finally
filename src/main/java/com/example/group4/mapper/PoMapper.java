package com.example.group4.mapper;

import com.example.group4.bean.Po;
import com.example.group4.bean.PoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PoMapper {
    long countByExample(PoExample example);

    int deleteByExample(PoExample example);

    int deleteByPrimaryKey(Integer poNo);

    int insert(Po record);

    int insertSelective(Po record);

    List<Po> selectByExample(PoExample example);

    Po selectByPrimaryKey(Integer poNo);

    int updateByExampleSelective(@Param("record") Po record, @Param("example") PoExample example);

    int updateByExample(@Param("record") Po record, @Param("example") PoExample example);

    int updateByPrimaryKeySelective(Po record);

    int updateByPrimaryKey(Po record);
}