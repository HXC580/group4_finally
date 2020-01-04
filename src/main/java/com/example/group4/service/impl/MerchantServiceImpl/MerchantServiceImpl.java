package com.example.group4.service.impl.MerchantServiceImpl;

import com.example.group4.bean.Business;
import com.example.group4.bean.Cost_bill;
import com.example.group4.bean.Cost_billExample;
import com.example.group4.mapper.BusinessMapper;
import com.example.group4.mapper.Cost_billMapper;
import com.example.group4.service.IMerchantService.IMerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MerchantServiceImpl implements IMerchantService {
    @Autowired
     private BusinessMapper businessMapper;
    @Autowired
    private Cost_billMapper cost_billMapper;

    @Override
    public Business queById(int id) {
        return businessMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(Business business) throws RuntimeException {
        if(business==null){
            new RuntimeException("参数错误");
        }
        if(business.getId()==null){
            businessMapper.insert(business);
        }
        else {
            businessMapper.updateByPrimaryKey(business);
        }
    }

    @Override
    public List<Cost_bill> selectCollectionRecords(Date startDate,Date endDate,int id) throws RuntimeException {
        Cost_billExample example = new Cost_billExample();
        example.createCriteria().andMachineIdEqualTo(id).andTimeBetween(startDate,endDate);
        return cost_billMapper.selectByExample(example);
    }

    @Override
    public double getProfit(Date startDate, Date endDate, int id) throws RuntimeException {
        double profit= 0;
        List<Cost_bill> cost_bills = selectCollectionRecords(startDate, endDate, id);
        for (Cost_bill cost_bill : cost_bills) {
            profit += cost_bill.getMoney();
        }
        return profit;
    }

}
