package com.example.group4.bean;

import java.io.Serializable;
import java.util.Date;

public class Wlan implements Serializable {
    private Integer id;

    private String cardId;

    private Date time;

    private Double usedFlow;

    private Date usedTime;

    private Double money;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId == null ? null : cardId.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Double getUsedFlow() {
        return usedFlow;
    }

    public void setUsedFlow(Double usedFlow) {
        this.usedFlow = usedFlow;
    }

    public Date getUsedTime() {
        return usedTime;
    }

    public void setUsedTime(Date usedTime) {
        this.usedTime = usedTime;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", cardId=").append(cardId);
        sb.append(", time=").append(time);
        sb.append(", usedFlow=").append(usedFlow);
        sb.append(", usedTime=").append(usedTime);
        sb.append(", money=").append(money);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}