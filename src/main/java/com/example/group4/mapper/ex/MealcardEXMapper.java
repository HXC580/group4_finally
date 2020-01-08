package com.example.group4.mapper.ex;

public interface MealcardEXMapper {
    void freeze(int id);
    void abfreeze(int id);
    void updateCeiling(int id,double money);

}
