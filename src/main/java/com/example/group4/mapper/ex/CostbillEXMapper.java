package com.example.group4.mapper.ex;

import com.example.group4.bean.ex.CostBillEX;
import com.example.group4.bean.ex.ProfitEX;

import java.util.Date;
import java.util.List;

public interface CostbillEXMapper {
    List<CostBillEX> findAll(int start, int pagesize);
    List<CostBillEX> findById(int id,int start, int pagesize);
    List<CostBillEX>findByMoney(int id,double money);
    double sumById(int id);
    List<CostBillEX>findByTime(int id,int day);
    double sumByTime(int id,int day);
    double[] consume(int id, Date date);


    List<ProfitEX> getProfitChartByDay(int[] ids);

    List<ProfitEX> getProfitChartByMonth(int[] ids);

    List<ProfitEX> getProfitChartByYear(int[] ids);
}
