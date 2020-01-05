package com.example.group4.service.impl;

import com.example.group4.bean.ex.Page;
import com.example.group4.mapper.ex.PageMapper;
import com.example.group4.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

import static com.example.group4.common.getData.getDataFromMysql.getDataArrayListMap;

public class PageImpl implements PageService {
@Autowired
private PageMapper pageMapper;
    @Override
    public void GetCount(Page page) {
        int count=pageMapper.getCount(page.getTableName());
    page.setPageCountNumber(count);
    if(count%page.getN()==0){
        page.setPageNumber(count/page.getN());
    }
    else {
        page.setPageNumber(count/page.getN()+1);
    }
    }

    @Override
    public ArrayList GetPageNumber(Page page) {
        String sql="select * from "+page.getTableName()+" limit("+(page.getNowPageNumber()-1)*page.getN()+","+page.getN()+")" ;
        System.out.println(sql);
       ArrayList list=getDataArrayListMap(sql);
       return list;

    }
}
