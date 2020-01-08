package com.example.group4.service.impl.StudentCardService;

import com.example.group4.bean.Machine;
import com.example.group4.bean.MachineExample;
import com.example.group4.bean.ex.CostBillEX;
import com.example.group4.bean.ex.ProfitEX;
import com.example.group4.mapper.BusinessMapper;
import com.example.group4.mapper.MachineMapper;
import com.example.group4.mapper.ex.CostbillEXMapper;
import com.example.group4.service.StudentCardService.ICostBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CostBillServiceImpl implements ICostBillService {
    @Autowired
    private CostbillEXMapper costBillEXMapper;
    @Autowired
    private MachineMapper machineMapper;

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

    @Override
    public List<ProfitEX> getProfitChart(String selected,int id) {
        MachineExample example = new MachineExample();
        int[] ids = machineMapper.getMachineByBusId(id);

        if ("day".equals(selected)){
            return costBillEXMapper.getProfitChartByDay(ids);
        }else if("month".equals(selected)){
            return costBillEXMapper.getProfitChartByMonth(ids);
        }else {
            return costBillEXMapper.getProfitChartByYear(ids);
        }
    }
}
