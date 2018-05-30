package com.xdht.disease.common.core;

/**
 * Created by L on 2018/5/30.
 */
public class ErrorResultMap {

    private String name;//错误属性
    private String message;//错误描述

    public ErrorResultMap(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
