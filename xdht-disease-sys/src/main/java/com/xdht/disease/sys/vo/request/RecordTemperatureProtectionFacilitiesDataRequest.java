package com.xdht.disease.sys.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class RecordTemperatureProtectionFacilitiesDataRequest {

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "部门id")
    private Long companyOfficeId;

    @ApiModelProperty(value = "工种id")
    private Long postId;

    @ApiModelProperty(value = "工作地点")
    private String workPlace;

    @ApiModelProperty(value = "运行维护情况")
    private String operationAndMaintenance;

    @ApiModelProperty(value = "生产性热源")
    private String productiveHeatSource;

    @ApiModelProperty(value = "防高温设施")
    private String temperatureProtectionFacilities;



}
