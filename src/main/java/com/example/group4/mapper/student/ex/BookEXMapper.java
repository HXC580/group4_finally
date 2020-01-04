package com.example.group4.mapper.student.ex;

import com.example.group4.bean.student.ex.Lend_listEX;

import java.util.List;

public interface BookEXMapper {
    List<Lend_listEX> selectAllLendList();
}
