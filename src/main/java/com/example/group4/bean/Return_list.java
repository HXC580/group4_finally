package com.example.group4.bean;

import java.io.Serializable;
import java.util.Date;

public class Return_list implements Serializable {
    private Integer id;

    private Integer bookId;

    private Integer cardId;

    private Double money;

    private Date time;

    private Integer lendId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public Integer getLendId() {
        return lendId;
    }

    public void setLendId(Integer lendId) {
        this.lendId = lendId;
    }

    @Override
    public String toString() {
        return "Return_list{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", cardId=" + cardId +
                ", money=" + money +
                ", time=" + time +
                ", lendId=" + lendId +
                '}';
    }
}