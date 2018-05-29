package com.xdht.disease.common.constant;

/**
 * @author lzf
 */
public enum ResultCode {

    SUCCESS(100,"成功"),//成功
    FAIL(400,"失败"),//失败
    VALID_FAIL(300,"验证失败"),//验证失败
    UNAUTHORIZED(401,"未认证"),//未认证（签名错误）
    NOPERMISSION(403,"无权访问"),//无权访问
    NOT_FOUND(404,"接口不存在"),//接口不存在
    INTERNAL_SERVER_ERROR(500,"服务器内错误");//服务器内部错误

    /**
     * 返回码
     */
    public int code;

    /**
     * 返回结果描述
     */
    private String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
