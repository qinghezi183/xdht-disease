package com.xdht.disease.sys.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class RecordBuildingBaseDataRequest {

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "建筑物名称")
    private String buildingName;

    @ApiModelProperty(value = "结构")
    private String structure;

    @ApiModelProperty(value = "层数")
    private Long layers;

    @ApiModelProperty(value = "建筑面积（m2）")
    private Long builtUpArea;

    @ApiModelProperty(value = "采光方式")
    private String lightingMode;

    @ApiModelProperty(value = "照明方式")
    private String lightingSystem;

    @ApiModelProperty(value = "照明灯具")
    private String lightingLamps;


}
