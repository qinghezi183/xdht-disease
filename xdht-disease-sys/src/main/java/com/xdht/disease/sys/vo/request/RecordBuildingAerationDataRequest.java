package com.xdht.disease.sys.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class RecordBuildingAerationDataRequest {

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "建筑物名称")
    private String buildingName;

    @ApiModelProperty(value = "通风及空气调节方式")
    private String regulationMode;

    @ApiModelProperty(value = "通风及空气调节设施")
    private String adjustmentFacilities;

    @ApiModelProperty(value = "数量（台）")
    private Long number;

    @ApiModelProperty(value = "采暖方式")
    private String heatingMode;



}
