package com.xdht.disease.sys.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class RecordVddEquipmentDataRequest {

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "部门id")
    private Long officeId;

    @ApiModelProperty(value = "工种id")
    private Long postId;

    @ApiModelProperty(value = "工作地点")
    private String workPlace;

    @ApiModelProperty(value = "通风排毒除尘设施名称")
    private String vddEquipmentName;

    @ApiModelProperty(value = "毒物或粉尘名称")
    private String poisonOrDustName;

    @ApiModelProperty(value = "数量")
    private Long number;

    @ApiModelProperty(value = "运行维护情况")
    private String operationAndMaintenance;

}
