package com.example.demo.common;

import lombok.Data;

@Data
public class Result {
    //相应码
    private Integer code;
    //信息
    private String message;
    //返回数据
    private Object data;

    public Result(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    //省略getter、setter、构造方法
}