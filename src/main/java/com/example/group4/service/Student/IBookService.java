package com.example.group4.service.Student;


import com.example.group4.bean.Lend_list;
import com.example.group4.bean.Return_list;
import com.example.group4.bean.student.ex.Lend_listEX;

import java.util.List;



public interface IBookService {
    List<Lend_list> displayAllLendList();
    List<Return_list> displayAllReturnList();
    List<Lend_listEX> selectAllLendList();
}
