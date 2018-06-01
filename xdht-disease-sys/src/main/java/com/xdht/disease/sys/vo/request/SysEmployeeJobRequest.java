package com.xdht.disease.sys.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class SysEmployeeJobRequest {

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "员工ID")
    private Long employeeId;

    @ApiModelProperty(value = "开始日期")
    private Date beginDate;

    @ApiModelProperty(value = "介绍日期")
    private Date endDate;

    @ApiModelProperty(value = " 工作单位")
    private String companyName;

    @ApiModelProperty(value = "工种")
    private Long workType;

    @ApiModelProperty(value = "噪声检测结果")
    private String noiseDetectionResults;

    @ApiModelProperty(value = "防护措施")
    private String protectiveMeasures;


    @ApiModelProperty(value = "状态（0有效 1删除）")
    private String status;

    @ApiModelProperty(value = "分页数")
    private Integer  pageNum;

    @ApiModelProperty(value = "每页数量")
    private Integer pageSize;
}
