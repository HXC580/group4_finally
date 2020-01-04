package com.example.group4.bean.ex;

public class Page {
    private String tableName;//表名
    private int PageCountNumber;//数据条数
    private int n;//每页多少个
    private int PageNumber;//总页数
    private int NowPageNumber=1;//当前页码

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public int getPageNumber() {
        return PageNumber;
    }

    public void setPageNumber(int pageNumber) {
        PageNumber = pageNumber;
    }

    public int getPageCountNumber() {
        return PageCountNumber;
    }

    public void setPageCountNumber(int pageCountNumber) {
        PageCountNumber = pageCountNumber;
    }

    public int getNowPageNumber() {
        return NowPageNumber;
    }

    public void setNowPageNumber(int nowPageNumber) {
        NowPageNumber = nowPageNumber;
    }


}
