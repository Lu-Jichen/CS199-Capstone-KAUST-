package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.example.demo.common.Status;
import lombok.Data;

import java.io.Serializable;

@Data
public class Errand implements Serializable {

    @TableId(value = "errand_id", type = IdType.AUTO)
    private int errandId;

    private int status;

    private String createTime;

    private String typeName;

    private String username;

    private String statusDes;

    private double price;

    public void setStatusDes() {
        this.statusDes = Status.values()[this.status].name();
    }
}
