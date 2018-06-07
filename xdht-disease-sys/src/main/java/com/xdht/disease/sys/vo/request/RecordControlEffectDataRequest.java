package com.xdht.disease.sys.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class RecordControlEffectDataRequest {

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "调查表id")
    private Long preEvaluationId;

    @ApiModelProperty(value = "调查项目id")
    private Long preEvaluationProjectId;

    @ApiModelProperty(value = "调查结果")
    private String surveyResults;

    @ApiModelProperty(value = "备注")
    private String remarks;


}
