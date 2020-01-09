package com.example.group4.mapper;

import com.example.group4.bean.Cost_bill;
import com.example.group4.bean.Cost_billExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Cost_billMapper {
    long countByExample(Cost_billExample example);

    int deleteByExample(Cost_billExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Cost_bill record);

    int insertSelective(Cost_bill record);

    List<Cost_bill> selectByExample(Cost_billExample example);

    Cost_bill selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Cost_bill record, @Param("example") Cost_billExample example);

    int updateByExample(@Param("record") Cost_bill record, @Param("example") Cost_billExample example);

    int updateByPrimaryKeySelective(Cost_bill record);

    int updateByPrimaryKey(Cost_bill record);
}