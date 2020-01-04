package com.example.group4.service.impl.MerchantServiceImpl;

import com.example.group4.bean.Business;
import com.example.group4.mapper.BusinessMapper;
import com.example.group4.service.IMerchantService.IMerchantService;
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

}
