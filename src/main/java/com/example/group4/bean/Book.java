package com.example.group4.bean;

import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable {
    private Integer id;

    private String name;

    private String author;

    private String publisher;

    private Date publishTime;

    private Date instorageTime;

    private String address;

    private String status;

    private Double price;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher == null ? null : publisher.trim();
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Date getInstorageTime() {
        return instorageTime;
    }

    public void setInstorageTime(Date instorageTime) {
        this.instorageTime = instorageTime;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", publishTime=" + publishTime +
                ", instorageTime=" + instorageTime +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                ", price=" + price +
                '}';
    }
}