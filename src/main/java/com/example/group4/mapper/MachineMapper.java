package com.example.group4.mapper;

import com.example.group4.bean.Machine;
import com.example.group4.bean.MachineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MachineMapper {
    long countByExample(MachineExample example);

    int deleteByExample(MachineExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Machine record);

    int insertSelective(Machine record);

    List<Machine> selectByExample(MachineExample example);

    Machine selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Machine record, @Param("example") MachineExample example);

    int updateByExample(@Param("record") Machine record, @Param("example") MachineExample example);

    int updateByPrimaryKeySelective(Machine record);

    int updateByPrimaryKey(Machine record);

    int[] getMachineByBusId(int id);
}