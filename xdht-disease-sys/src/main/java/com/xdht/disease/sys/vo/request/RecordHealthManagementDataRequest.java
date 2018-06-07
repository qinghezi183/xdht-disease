package com.xdht.disease.sys.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class RecordHealthManagementDataRequest {

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "调查表id")
    private Long healthManagementId;

    @ApiModelProperty(value = "调查项目id")
    private Long healthManagementProjectId;

    @ApiModelProperty(value = "建立情况")
    private String setUpInfo;

    @ApiModelProperty(value = "执行情况")
    private String implementInfo;

    @ApiModelProperty(value = "备注")
    private String remarks;

}
