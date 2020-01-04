package com.example.group4.bean;

import java.io.Serializable;
import java.util.Date;

public class Dormitory_io implements Serializable {
    private Integer id;

    private Integer cardId;

    private Date time;

    private String iotype;

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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getIotype() {
        return iotype;
    }

    public void setIotype(String iotype) {
        this.iotype = iotype == null ? null : iotype.trim();
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
        sb.append(", iotype=").append(iotype);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}