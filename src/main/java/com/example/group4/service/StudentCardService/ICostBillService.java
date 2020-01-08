package com.example.group4.service.StudentCardService;

import com.example.group4.bean.ex.CostBillEX;
import com.example.group4.bean.ex.ProfitEX;

import java.util.List;

public interface ICostBillService {
    List<CostBillEX>findById(int id,int start, int pagesize);
    List<CostBillEX>findByMoney(int id,double money);
    double sumById(int id);
    List<CostBillEX>findByTime(int id,int day);
    double sumByTime(int id,int day);

    List<ProfitEX> getProfitChart(String selected);
}
