package com.xdht.disease.sys.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class RecordAuxiliaryHealthRequest {

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "编号")
    private String auxiliaryHealthNo;

    @ApiModelProperty(value = "核实情况")
    private String verificationResult;

    @ApiModelProperty(value = "状态（0正常 1删除）")
    private String status;



}
