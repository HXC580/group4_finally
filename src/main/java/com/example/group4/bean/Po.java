package com.example.group4.bean;

import java.io.Serializable;

public class Po implements Serializable {
    private Integer poNo;

    private String sysName;

    private String prdName;

    private String price;

    private String poState;

    private static final long serialVersionUID = 1L;

    public Integer getPoNo() {
        return poNo;
    }

    public void setPoNo(Integer poNo) {
        this.poNo = poNo;
    }

    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName == null ? null : sysName.trim();
    }

    public String getPrdName() {
        return prdName;
    }

    public void setPrdName(String prdName) {
        this.prdName = prdName == null ? null : prdName.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public String getPoState() {
        return poState;
    }

    public void setPoState(String poState) {
        this.poState = poState == null ? null : poState.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", poNo=").append(poNo);
        sb.append(", sysName=").append(sysName);
        sb.append(", prdName=").append(prdName);
        sb.append(", price=").append(price);
        sb.append(", poState=").append(poState);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}