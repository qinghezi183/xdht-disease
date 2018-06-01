package com.xdht.disease.sys.vo.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class SysEmployeeResponse {

    @ApiModelProperty(value = "员工id")
    private Long id;

    @ApiModelProperty(value = "部门id")
    private Long officeId;

    @ApiModelProperty(value = "员工姓名")
    private String empName;

    @ApiModelProperty(value = "性别")
    private String empSex;

    @ApiModelProperty(value = "籍贯")
    private String empNative;

    @ApiModelProperty(value = "婚姻")
    private String empMarriage;

    @ApiModelProperty(value = "文化程度")
    private String empEducation;

    @ApiModelProperty(value = "嗜好")
    private String empHobby;

    @ApiModelProperty(value = "参加工作时间")
    private Date empWorkDate;

    @ApiModelProperty(value = "身份证号")
    private String empIdentityNumber;

    @ApiModelProperty(value = "状态（0在职 1离职）")
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
