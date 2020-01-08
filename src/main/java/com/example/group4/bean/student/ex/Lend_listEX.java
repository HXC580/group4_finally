package com.example.group4.bean.student.ex;

import com.example.group4.bean.Return_list;

import java.util.Date;

public class Lend_listEX {
    private int BookID;
    private String BookName;
    private String Author;
    private String Publisher;
    private Date PublishTime;
    private Date BorrowTime;
    private String Status;
    private String IsReturnBookTimeOut;
    private double fine;
    private Return_list return_list;

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String publisher) {
        Publisher = publisher;
    }

    public Date getPublishTime() {
        return PublishTime;
    }

    public void setPublishTime(Date publishTime) {
        PublishTime = publishTime;
    }

    public Date getBorrowTime() {
        return BorrowTime;
    }

    public void setBorrowTime(Date borrowTime) {
        BorrowTime = borrowTime;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getIsReturnBookTimeOut() {
        return IsReturnBookTimeOut;
    }

    public void setIsReturnBookTimeOut(String isReturnBookTimeOut) {
        IsReturnBookTimeOut = isReturnBookTimeOut;
    }

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }

    public Return_list getReturn_list() {
        return return_list;
    }

    public void setReturn_list(Return_list return_list) {
        this.return_list = return_list;
    }

    public int getBookID() {
        return BookID;
    }

    public void setBookID(int bookID) {
        BookID = bookID;
    }

    @Override
    public String toString() {
        return "Lend_listEX{" +
                "BookID=" + BookID +
                ", BookName='" + BookName + '\'' +
                ", Author='" + Author + '\'' +
                ", Publisher='" + Publisher + '\'' +
                ", PublishTime=" + PublishTime +
                ", BorrowTime=" + BorrowTime +
                ", Status='" + Status + '\'' +
                ", IsReturnBookTimeOut='" + IsReturnBookTimeOut + '\'' +
                ", fine=" + fine +
                ", return_list=" + return_list +
                '}';
    }
}
