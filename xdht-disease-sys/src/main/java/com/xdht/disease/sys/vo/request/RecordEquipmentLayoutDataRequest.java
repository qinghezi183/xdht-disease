package com.xdht.disease.sys.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class RecordEquipmentLayoutDataRequest {

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "工艺过程及设备")
    private String processAndEquipment;

    @ApiModelProperty(value = "职业病危害因素")
    private String hazardFactors;

    @ApiModelProperty(value = "布局情况")
    private String layoutDetail;

    @ApiModelProperty(value = "备注")
    private String remarkds;

}
