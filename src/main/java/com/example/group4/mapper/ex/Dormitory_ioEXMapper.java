package com.example.group4.mapper.ex;

import com.example.group4.bean.Dormitory_io;
import com.example.group4.bean.ex.dangerEX;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface Dormitory_ioEXMapper {
List<dangerEX>danger(@Param("dayBegin")Date dateB ,@Param("dayEnd")Date dateE);
}
