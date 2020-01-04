package com.example.group4.service.IMerchantService;

import com.example.group4.bean.Business;
import com.example.group4.bean.Cost_bill;

import java.util.List;

public interface IMerchantService {

    Business queById(int id) throws RuntimeException;

   void saveOrUpdate(Business business) throws  RuntimeException;

    List<Cost_bill> selectCollectionRecords(int id) throws RuntimeException;

    double getProfit(int id) throws RuntimeException;
}
