package com.xdht.disease.sys.vo.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class SysRoleResponse {

    @ApiModelProperty(value = "用户Id")
    private Long id ;

    @ApiModelProperty(value = "角色名称")
    private String roleName;

    @ApiModelProperty(value = "系统内置（1是 0否）")
    private String isSys;

    @ApiModelProperty(value = "状态（0正常 1删除 2停用）")
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

    @ApiModelProperty(value = "总数")
    private Integer count;
}
