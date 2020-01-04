package com.example.group4.service.impl;

import com.example.group4.bean.ex.Page;
import com.example.group4.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;

public class PageImpl implements PageService {

    @Override
    public void GetCount(Page page) {
//         page.setPageCountNumber();
    }

    @Override
    public void GetPageNumber(Page page) {
        String sql="select * from "+page.getTableName()+" limit("+(page.getNowPageNumber()-1)*page.getN()+","+page.getN()+")" ;
        System.out.println(sql);

    }
}
