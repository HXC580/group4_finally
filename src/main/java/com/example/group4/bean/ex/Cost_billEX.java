package com.example.group4.bean.ex;

import java.util.Date;

public class Cost_billEX {

    private Integer id;

    private Integer cardId;

    private Double money;

    private Date time;

    private Integer machineId;

    private double profit;

    public Cost_billEX() {
    }

    public Cost_billEX(Integer id, Integer cardId, Double money, Date time, Integer machineId, double profit) {
        this.id = id;
        this.cardId = cardId;
        this.money = money;
        this.time = time;
        this.machineId = machineId;
        this.profit = profit;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getMachineId() {
        return machineId;
    }

    public void setMachineId(Integer machineId) {
        this.machineId = machineId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", cardId=").append(cardId);
        sb.append(", money=").append(money);
        sb.append(", time=").append(time);
        sb.append(", machineId=").append(machineId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
