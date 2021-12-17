package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.example.demo.common.Gender;
import com.example.demo.common.Status;
import com.fasterxml.jackson.databind.JsonSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


@Data
//@EqualsAndHashCode(callSuper = false)
//@Accessors(chain = true)
public class UserInfo implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    @TableField(exist = false)
    private String username;

    @TableField(exist = false)
    private String password;

    private int gender;

    @TableField(exist = false)
    private String genderDes;

    public void setGenderDesNew() {
        this.genderDes = Gender.getCode(this.gender);
    }

    public void setGenderNew() {
        this.gender = Gender.getId(this.genderDes);
    }

    private String phoneNumber;

    private String location;

    private String bankAccount;

    private String birthday;

    public void setBirthdayNew(){
        if (this.birthday.length()>10)
            this.birthday = this.birthday.substring(0,10);
    }

    private String realName;


}
