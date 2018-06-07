package com.xdht.disease.sys.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class RecordAntiNoiseFacilitiesDataRequest {

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "部门id")
    private Long companyOfficeId;

    @ApiModelProperty(value = "职位id")
    private Long postId;

    @ApiModelProperty(value = "作业地点")
    private String workPlace;

    @ApiModelProperty(value = "噪声源")
    private String noiseSource;

    @ApiModelProperty(value = "噪声防护设施（减振、隔声、吸声等）")
    private String noiseProtectionFacilities;

    @ApiModelProperty(value = "运行维护情况")
    private String operationAndMaintenance;

}
