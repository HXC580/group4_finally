package com.example.group4.mapper;

import com.example.group4.bean.Lend_list;
import com.example.group4.bean.Lend_listExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Lend_listMapper {
    long countByExample(Lend_listExample example);

    int deleteByExample(Lend_listExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Lend_list record);

    int insertSelective(Lend_list record);

    List<Lend_list> selectByExample(Lend_listExample example);

    Lend_list selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Lend_list record, @Param("example") Lend_listExample example);

    int updateByExample(@Param("record") Lend_list record, @Param("example") Lend_listExample example);

    int updateByPrimaryKeySelective(Lend_list record);

    int updateByPrimaryKey(Lend_list record);
}