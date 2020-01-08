package com.example.group4.service.impl.StudentCardService;

import com.example.group4.bean.ex.CostBillEX;
import com.example.group4.bean.ex.ProfitEX;
import com.example.group4.mapper.ex.CostbillEXMapper;
import com.example.group4.service.StudentCardService.ICostBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CostBillServiceImpl implements ICostBillService {
    @Autowired
    private CostbillEXMapper costBillEXMapper;

    @Override
    public List<CostBillEX> findById(int id,int start,int pagesize) {
        if("null".equals(id))
            return costBillEXMapper.findAll( start,pagesize);
        else
            return costBillEXMapper.findById(id,start,pagesize);
    }

    @Override
    public List<CostBillEX> findByMoney(int id,double money) {
        return costBillEXMapper.findByMoney(id,money);
    }

    @Override
    public double sumById(int id) {
        return costBillEXMapper.sumById(id);
    }

    @Override
    public List<CostBillEX> findByTime(int id,int day) {
        return costBillEXMapper.findByTime(id,day);
    }

    @Override
    public double sumByTime(int id,int day) {
        return costBillEXMapper.sumByTime(id,day);
    }


    @Override
    public List<ProfitEX> getProfitChart(String selected) {
        if ("day".equals(selected)){
            return costBillEXMapper.getProfitChartByDay();
        }else if("month".equals(selected)){
            return costBillEXMapper.getProfitChartByMonth();
        }else {
            return costBillEXMapper.getProfitChartByYear();
        }
    }
}
