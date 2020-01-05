package com.example.group4.service.StudentCardService;

import com.example.group4.bean.Po;

public interface IRechargeService {
    void AddSum(int id, double money);
    Po insertPrepay(int id, double money);
}
