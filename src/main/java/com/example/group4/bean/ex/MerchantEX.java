package com.example.group4.bean.ex;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Date;

public class MerchantEX implements Serializable {
    private Date time;

    private int cardId;

    private int macId;

    private double money;

    @Override
    public String toString() {
        return "MerchantEX{" +
                "time=" + time +
                ", cardId=" + cardId +
                ", macId=" + macId +
                ", money=" + money +
                '}';
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public int getMacId() {
        return macId;
    }

    public void setMacId(int macId) {
        this.macId = macId;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
