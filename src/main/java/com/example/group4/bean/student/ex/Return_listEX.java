package com.example.group4.bean.student.ex;

import java.util.Date;

public class Return_listEX {
    private int BookID;
    private String BookName;
    private String Author;
    private String Publisher;
    private Date PublishTime;
    private Date BorrowTime;
    private Date ReturnTime;

    public int getBookID() {
        return BookID;
    }

    public void setBookID(int bookID) {
        BookID = bookID;
    }

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

    public Date getReturnTime() {
        return ReturnTime;
    }

    public void setReturnTime(Date returnTime) {
        ReturnTime = returnTime;
    }
}
