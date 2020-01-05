package com.example.group4.service.impl.StudentCardService;

import com.example.group4.bean.ex.CostBillEX;
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
    public List<CostBillEX> findAll(int start,int pagesize) {
        return costBillEXMapper.findAll( start,pagesize);
    }

    @Override
    public List<CostBillEX> findByMoney(double money) {
        return costBillEXMapper.findByMoney(money);
    }

    @Override
    public double sum() {
        return costBillEXMapper.sum();
    }

    @Override
    public List<CostBillEX> findByTime(int day) {
        return costBillEXMapper.findByTime(day);
    }

    @Override
    public double sumByTime(int day) {
        return costBillEXMapper.sumByTime(day);
    }
}
