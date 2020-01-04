package com.example.group4.mapper;

import com.example.group4.bean.Wlan;
import com.example.group4.bean.WlanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WlanMapper {
    long countByExample(WlanExample example);

    int deleteByExample(WlanExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Wlan record);

    int insertSelective(Wlan record);

    List<Wlan> selectByExample(WlanExample example);

    Wlan selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Wlan record, @Param("example") WlanExample example);

    int updateByExample(@Param("record") Wlan record, @Param("example") WlanExample example);

    int updateByPrimaryKeySelective(Wlan record);

    int updateByPrimaryKey(Wlan record);
}