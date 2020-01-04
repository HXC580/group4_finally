package com.example.group4.service;

import com.example.group4.bean.Business;

public interface IMerchantService {

    Business queById(int id) throws RuntimeException;

   void saveOrUpdate(Business business) throws  RuntimeException;

}
