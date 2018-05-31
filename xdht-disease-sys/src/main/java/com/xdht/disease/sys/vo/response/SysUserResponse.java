package com.xdht.disease.sys.vo.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class SysUserResponse {

    @ApiModelProperty(value = "用户Id")
    private Long id ;

    @ApiModelProperty(value = "用户名称")
    private String userName;

    @ApiModelProperty(value = "登录账号")
    private String loginCode;

    @ApiModelProperty(value = "登录密码")
    private String password;

    @ApiModelProperty(value = "电子邮箱")
    private String email;

    @ApiModelProperty(value = "手机号码")
    private String mobile;

    @ApiModelProperty(value = "办公电话")
    private String phone;

    @ApiModelProperty(value = "用户性别")
    private String sex;

    @ApiModelProperty(value = "头像路径")
    private String avatar;

    @ApiModelProperty(value = "个性签名")
    private String sign;

    @ApiModelProperty(value = "绑定的微信号")
    private String wxOpenid;

    @ApiModelProperty(value = "管理员类型（0非管理员 1系统管理员）")
    private String mgrType;

    @ApiModelProperty(value = "最后登陆IP")
    private String lastLoginIp;

    @ApiModelProperty(value = "最后登陆时间")
    private Date lastLoginDate;

    @ApiModelProperty(value = "冻结时间")
    private Date freezeDate;

    @ApiModelProperty(value = "冻结原因")
    private String freezeCause;

    @ApiModelProperty(value = "状态（0正常 1删除 2停用 3冻结）")
    private String status;

    @ApiModelProperty(value = "创建者")
    private Long createBy;

    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    @ApiModelProperty(value = "更新者")
    private Long updateBy;

    @ApiModelProperty(value = "更新时间")
    private Date updateDate;

    @ApiModelProperty(value = "备注信息")
    private String remarks;
}
