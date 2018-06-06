package com.xdht.disease.sys.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class RecordHazardFactorsDataRequest {

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "部门id")
    private Long officeId;

    @ApiModelProperty(value = "职业病危害因素")
    private String hazardFactors;

    @ApiModelProperty(value = "暴露方式")
    private String exposureMode;

    @ApiModelProperty(value = "暴露时间")
    private String exposureTime;

    @ApiModelProperty(value = "备注")
    private String remarks;



}
