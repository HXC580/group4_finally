package com.example.group4.service.impl;

import com.example.group4.bean.Business;
import com.example.group4.mapper.BusinessMapper;
import com.example.group4.service.IMerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantServiceImpl implements IMerchantService {
    @Autowired
     private BusinessMapper businessMapper;

    @Override
    public Business queById(int id) {
        return businessMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(Business business) {

    }
}
