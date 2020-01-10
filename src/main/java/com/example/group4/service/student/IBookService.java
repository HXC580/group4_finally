package com.example.group4.service.student;


import com.example.group4.bean.Book;
import com.example.group4.bean.Lend_list;
import com.example.group4.bean.Return_list;
import com.example.group4.bean.student.ex.BookEX;
import com.example.group4.bean.student.ex.Lend_listEX;
import com.example.group4.bean.student.ex.Return_listEX;

import java.util.List;



public interface IBookService {
    List<Lend_list> displayAllLendList();
    List<Return_list> displayAllReturnList();
    List<Lend_listEX> selectAllLendList();
    List<Lend_listEX> selectLendListByKey(String key);
    List<Return_listEX> selectAllReturnList();
    List<Return_listEX> selectReturnListByKey(String key);
    List<Book> selectAllBook();
    List<Book> selectBookByKey(String key);
    String payFineById(int id);
    List<Lend_listEX> selectLendListByStuId(int id);
    List<Return_listEX> selectReturnListByStuId(int id);
    BookEX selectBookById(int id);
}
