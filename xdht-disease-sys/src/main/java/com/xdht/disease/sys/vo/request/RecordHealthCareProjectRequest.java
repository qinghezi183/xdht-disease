package com.xdht.disease.sys.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class RecordHealthCareProjectRequest {

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "调查项目")
    private String projectName;

    @ApiModelProperty(value = "状态（0正常 1删除）")
    private String status;

}
