package com.example.group4.service;

import com.example.group4.bean.ex.Page;

public interface PageService {
//    获取数据条数
    void GetCount(Page page);
//    获取页数    N:每页多少条
    void GetPageNumber(Page page);

}
