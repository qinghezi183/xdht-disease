package com.xdht.disease.sys.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class RecordSceneRequest {

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "编号")
    private String recordNo;

    @ApiModelProperty(value = "项目名称")
    private String projectName;

    @ApiModelProperty(value = "调查类型")
    private String inquiryType;

    @ApiModelProperty(value = "调查人")
    private String inquiryPerson;

    @ApiModelProperty(value = "调查对象")
    private Long inquiryCompany;

    @ApiModelProperty(value = "用人单位陪同人")
    private Long inquiryCompanyEmployee;

    @ApiModelProperty(value = "调查日期")
    private Date inquiryDate;


    @ApiModelProperty(value = "状态（0正常 1删除）")
    private String status;



}
