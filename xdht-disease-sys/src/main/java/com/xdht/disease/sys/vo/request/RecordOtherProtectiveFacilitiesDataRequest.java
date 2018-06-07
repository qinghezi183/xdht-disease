package com.xdht.disease.sys.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class RecordOtherProtectiveFacilitiesDataRequest {

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "部门id")
    private Long officeId;

    @ApiModelProperty(value = "工种id")
    private Long postId;

    @ApiModelProperty(value = "工作地点")
    private String workPlace;

    @ApiModelProperty(value = "职业病危害因素")
    private String hazardFactors;

    @ApiModelProperty(value = "防护设施名称")
    private String protectiveFacilities;

    @ApiModelProperty(value = "运行维护情况")
    private String operationAndMaintenance;

}
