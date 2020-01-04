package com.example.group4.mapper;

import com.example.group4.bean.Return_list;
import com.example.group4.bean.Return_listExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Return_listMapper {
    long countByExample(Return_listExample example);

    int deleteByExample(Return_listExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Return_list record);

    int insertSelective(Return_list record);

    List<Return_list> selectByExample(Return_listExample example);

    Return_list selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Return_list record, @Param("example") Return_listExample example);

    int updateByExample(@Param("record") Return_list record, @Param("example") Return_listExample example);

    int updateByPrimaryKeySelective(Return_list record);

    int updateByPrimaryKey(Return_list record);
}