package com.example.group4.service.StudentCardService;

import com.example.group4.bean.ex.CostBillEX;
import com.example.group4.bean.ex.ProfitEX;

import java.util.List;

public interface ICostBillService {
    List<CostBillEX>findAll(int start, int pagesize);
    List<CostBillEX>findByMoney(double money);
    double sum();
    List<CostBillEX>findByTime(int day);
    double sumByTime(int day);

    List<ProfitEX> getProfitChart(String selected,int id);
}
