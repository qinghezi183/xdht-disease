package com.xdht.disease.sys.vo.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class SysEmployeeCaseResponse {

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "员工ID")
    private Long employeeId;

    @ApiModelProperty(value = "疾病名称")
    private String caseName;

    @ApiModelProperty(value = "诊断时间")
    private Date diagnosisDate;

    @ApiModelProperty(value = "诊断医院")
    private String diagnosisHospital;

    @ApiModelProperty(value = "治疗结果")
    private String treatmentResults;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @ApiModelProperty(value = "状态（0有效 1删除）")
    private String status;

    @ApiModelProperty(value = "创建者")
    private Long createBy;

    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    @ApiModelProperty(value = "更新者")
    private Long updateBy;

    @ApiModelProperty(value = "更新时间")
    private Date updateDate;

    @ApiModelProperty(value = "总数")
    private Integer count;
}
