package com.xdht.disease.common.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Token的Model类，可以增加字段提高安全性，例如时间戳、url签名
 * @author lzf
 */
@ApiModel
public class TokenModel implements java.io.Serializable{

    @ApiModelProperty("用户ID")
    private Long userId;
    @ApiModelProperty("token信息")
    private String token;
    @ApiModelProperty
    private User user;

    public TokenModel() {
    }

    public TokenModel(Long userId, String token, User user) {
        this.userId = userId;
        this.token = token;
        this.user=user;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
