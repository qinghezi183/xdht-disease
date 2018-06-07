package com.xdht.disease.sys.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class RecordFundsDataRequest {

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "调查表id")
    private Long fundsId;

    @ApiModelProperty(value = "调查项目id")
    private Long fundsProjectId;

    @ApiModelProperty(value = "预计或实际支出（万元）")
    private Long expactOrPay;


}
