package com.example.group4.bean;

import java.io.Serializable;

public class Dormitory implements Serializable {
    private String id;

    private Integer dormitoryManagerId;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getDormitoryManagerId() {
        return dormitoryManagerId;
    }

    public void setDormitoryManagerId(Integer dormitoryManagerId) {
        this.dormitoryManagerId = dormitoryManagerId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", dormitoryManagerId=").append(dormitoryManagerId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}