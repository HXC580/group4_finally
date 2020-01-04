package com.example.group4.service;

import com.example.group4.bean.Business;

public interface IMerchantService {

    Business queById(int id);

    void update(Business business);


}
