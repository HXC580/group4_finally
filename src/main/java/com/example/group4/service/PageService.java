package com.example.group4.service;

import com.example.group4.bean.ex.Page;

import java.util.ArrayList;

public interface PageService {
//    获取数据条数
    void GetCount(Page page);
//    获取页数    N:每页多少条
    ArrayList GetPageNumber(Page page);

}
