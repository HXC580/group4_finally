package com.example.group4.service.IMerchantService;

import com.example.group4.bean.Business;
import com.example.group4.bean.Cost_bill;

import java.util.Date;
import java.util.List;

public interface IMerchantService {

    Business queById(int id) throws RuntimeException;

   void saveOrUpdate(Business business) throws  RuntimeException;

    List<Cost_bill> selectCollectionRecords(Date startDate, Date endDate, int id) throws RuntimeException;

    double getProfit(Date startDate, Date endDate, int id) throws RuntimeException;
}
