package com.xdht.disease.common.core;

import com.alibaba.fastjson.JSON;
import com.xdht.disease.common.constant.ResultCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author lzf
 **/
@ApiModel
public class Result<T> {

    @ApiModelProperty("状态码")
    private int code;
    @ApiModelProperty("返回信息")
    private String message;
    @ApiModelProperty("返回实体")
    private T content;

    public Result() {
    }

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(int code, String message, T content) {
        this.code = code;
        this.message = message;
        this.content = content;
    }

    public Result(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message=resultCode.getMessage();
    }

    public Result(ResultCode resultCode, T content) {
        this.code = resultCode.getCode();
        this.message=resultCode.getMessage();
        this.content = content;
    }

    public Result setCode(ResultCode resultCode){
        this.code=resultCode.code;
        return this;
    }
    public int getCode() {
        return code;
    }

    public Result setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Result setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getContent() {
        return content;
    }

    public Result setContent(T content) {
        this.content = content;
        return this;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    public static <T> Result ok(T content) {
        return new Result(ResultCode.SUCCESS, content);
    }

    public static Result error(ResultCode error) {
        return new Result(error);
    }

    public static Result error(ResultCode error,String message){
        return new Result(error.getCode(),message);
    }

}
