package com.example.group4.bean.ex;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Date;


public class ProfitEX implements Serializable {

    private double countMoney;

    private int countNumber;

    private String dateTime;

    public double getMoney() {
        return countMoney;
    }

    public void setMoney(double money) {
        this.countMoney = money;
    }

    public int getCountNumber() {
        return countNumber;
    }

    public void setCountNumber(int countNumber) {
        this.countNumber = countNumber;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "ProfitEX{" +
                "money=" + countMoney +
                ", countNumber=" + countNumber +
                ", dateTime=" + dateTime +
                '}';
    }
}
