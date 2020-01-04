package com.example.group4.bean.student.ex;

import java.util.Date;

public class Lend_listEX {
    private String BookName;
    private String Author;
    private String Publisher;
    private Date PublishTime;
    private Date BorrowTime;
    private boolean Status;
    private boolean IsReturnBookTimeOut;
    private double fine;

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

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        Status = status;
    }

    public boolean isReturnBookTimeOut() {
        return IsReturnBookTimeOut;
    }

    public void setReturnBookTimeOut(boolean returnBookTimeOut) {
        IsReturnBookTimeOut = returnBookTimeOut;
    }

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }

    @Override
    public String toString() {
        return "Lend_listEX{" +
                "BookName='" + BookName + '\'' +
                ", Author='" + Author + '\'' +
                ", Publisher='" + Publisher + '\'' +
                ", PublishTime=" + PublishTime +
                ", BorrowTime=" + BorrowTime +
                ", Status=" + Status +
                ", IsReturnBookTimeOut=" + IsReturnBookTimeOut +
                ", fine=" + fine +
                '}';
    }
}
