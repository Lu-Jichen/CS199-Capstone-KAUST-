package com.example.demo.entity;

import java.io.Serializable;


public class ErrandDTO implements Serializable {
    public int getErrandId() {
        return errandId;
    }

    public void setErrandId(int errandId) {
        this.errandId = errandId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    private int errandId;
    private String typeName;

}
