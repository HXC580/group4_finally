package com.example.group4.mapper;

import com.example.group4.bean.Recharge_bill;
import com.example.group4.bean.Recharge_billExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Recharge_billMapper {
    long countByExample(Recharge_billExample example);

    int deleteByExample(Recharge_billExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Recharge_bill record);

    int insertSelective(Recharge_bill record);

    List<Recharge_bill> selectByExample(Recharge_billExample example);

    Recharge_bill selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Recharge_bill record, @Param("example") Recharge_billExample example);

    int updateByExample(@Param("record") Recharge_bill record, @Param("example") Recharge_billExample example);

    int updateByPrimaryKeySelective(Recharge_bill record);

    int updateByPrimaryKey(Recharge_bill record);
}