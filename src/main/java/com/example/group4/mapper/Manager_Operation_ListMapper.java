package com.example.group4.mapper;

import com.example.group4.bean.Manager_Operation_List;
import com.example.group4.bean.Manager_Operation_ListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Manager_Operation_ListMapper {
    long countByExample(Manager_Operation_ListExample example);

    int deleteByExample(Manager_Operation_ListExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Manager_Operation_List record);

    int insertSelective(Manager_Operation_List record);

    List<Manager_Operation_List> selectByExample(Manager_Operation_ListExample example);

    Manager_Operation_List selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Manager_Operation_List record, @Param("example") Manager_Operation_ListExample example);

    int updateByExample(@Param("record") Manager_Operation_List record, @Param("example") Manager_Operation_ListExample example);

    int updateByPrimaryKeySelective(Manager_Operation_List record);

    int updateByPrimaryKey(Manager_Operation_List record);
}