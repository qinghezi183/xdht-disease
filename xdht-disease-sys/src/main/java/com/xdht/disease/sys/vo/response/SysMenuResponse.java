package com.xdht.disease.sys.vo.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class SysMenuResponse {

    @ApiModelProperty(value = "用户Id")
    private Long id ;

    @ApiModelProperty(value = "父级id")
    private Long parentId;

    @ApiModelProperty(value = "所有父级id")
    private String parentIds;

    @ApiModelProperty(value = "菜单名称")
    private String menuName;

    @ApiModelProperty(value = "菜单类型（1菜单 2权限）")
    private String menuType;

    @ApiModelProperty(value = "链接")
    private String menuHref;

    @ApiModelProperty(value = "图标")
    private String menuIcon;

    @ApiModelProperty(value = "颜色")
    private String menuColor;

    @ApiModelProperty(value = "权限标识")
    private String permission;

    @ApiModelProperty(value = "是否显示（1显示 0隐藏）")
    private String isShow;

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
}
