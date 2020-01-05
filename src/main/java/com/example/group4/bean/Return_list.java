package com.example.group4.bean;

import java.io.Serializable;
import java.util.Date;

public class Return_list implements Serializable {
    private Integer id;

    private Integer book_id;

    private Integer card_id;

    private Double money;

    private Date time;

    private Integer lend_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public Integer getCard_id() {
        return card_id;
    }

    public void setCard_id(Integer card_id) {
        this.card_id = card_id;
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

    public Integer getLend_id() {
        return lend_id;
    }

    public void setLend_id(Integer lend_id) {
        this.lend_id = lend_id;
    }

    @Override
    public String toString() {
        return "Return_list{" +
                "id=" + id +
                ", book_id=" + book_id +
                ", card_id=" + card_id +
                ", money=" + money +
                ", time=" + time +
                ", lend_id=" + lend_id +
                '}';
    }
}