package com.example.group4.mapper.student.ex;

import com.example.group4.bean.Book;
import com.example.group4.bean.student.ex.Lend_listEX;
import com.example.group4.bean.student.ex.Return_listEX;

import java.util.List;

public interface BookEXMapper {
    List<Lend_listEX> selectAllLendList();
    List<Lend_listEX> selectLendListByKey(String key);
    List<Return_listEX> selectAllReturnList();
    List<Return_listEX> selectReturnListByKey(String key);
    List<Book> selectBookByKey(String key);
    Lend_listEX selectLendListById(int id);
}
