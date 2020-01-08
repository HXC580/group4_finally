package com.example.group4.bean.student.ex;

import java.util.Date;

public class BookEX {

    private Integer id;

    private String name;

    private String author;

    private String publisher;

    private Date publish_time;

    private Date instorage_time;

    private String address;

    private String status;

    private Double price;

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
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(Date publish_time) {
        this.publish_time = publish_time;
    }

    public Date getInstorage_time() {
        return instorage_time;
    }

    public void setInstorage_time(Date instorage_time) {
        this.instorage_time = instorage_time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "BookEX{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", publish_time=" + publish_time +
                ", instorage_time=" + instorage_time +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                ", price=" + price +
                '}';
    }
}
