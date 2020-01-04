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
<<<<<<< HEAD
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

=======
    public void update(Business business) {

    }
>>>>>>> 02ab32f307dc8152af3004c08c86cf1de2fdbb1b
}
