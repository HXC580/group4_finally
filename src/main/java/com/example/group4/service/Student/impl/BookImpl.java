package com.example.group4.service.Student.impl;

import com.example.group4.bean.Lend_list;
import com.example.group4.bean.Lend_listExample;
import com.example.group4.bean.Return_list;
import com.example.group4.bean.Return_listExample;
import com.example.group4.bean.student.ex.Lend_listEX;
import com.example.group4.mapper.Lend_listMapper;
import com.example.group4.mapper.Return_listMapper;
import com.example.group4.service.Student.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookImpl  implements IBookService {
    @Autowired
    private Lend_listMapper lend_listMapper;
    @Autowired
    private Return_listMapper return_listMapper;

    @Override
    public List<Lend_list> displayAllLendList() {
        Lend_listExample lend_listExample=new Lend_listExample();
        List<Lend_list> lend_lists = lend_listMapper.selectByExample(lend_listExample);
        return lend_lists;
    }

    @Override
    public List<Return_list> displayAllReturnList() {
        Return_listExample return_listExample = new Return_listExample();
        List<Return_list> return_lists = return_listMapper.selectByExample(return_listExample);
        return return_lists;
    }

    @Override
    public List<Lend_listEX> selectAllLendList() {



        return null;
    }
}
