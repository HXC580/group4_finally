package com.example.group4.service.IMerchantService;

import com.example.group4.bean.Business;
import com.example.group4.bean.Cost_bill;
import com.example.group4.bean.Machine;
import com.example.group4.bean.ex.Cost_billEX;

import java.util.Date;
import java.util.List;

public interface IMerchantService {

    Business queById(int id) throws RuntimeException;

   void saveOrUpdate(Business business) throws  RuntimeException;

    List<Cost_billEX> selectCollectionRecords(Date startDate, Date endDate, int macId,int busId,int currentPage,int pageSize) throws RuntimeException;

    double getProfit(Date startDate, Date endDate, int macId,int busId) throws RuntimeException;

    List<Cost_bill> downloadProfitSheet(int busId, int macId) throws RuntimeException;

    List<Machine> selectMacId(int id) throws RuntimeException;
}
