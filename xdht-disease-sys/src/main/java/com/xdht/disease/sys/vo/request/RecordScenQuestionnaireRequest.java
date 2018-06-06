package com.xdht.disease.sys.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class RecordScenQuestionnaireRequest {

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "现场调查id")
    private Long sceneId;

    @ApiModelProperty(value = "调查表id")
    private Long questionnaireId;

    @ApiModelProperty(value = "是否填写调查表（0没有 1有）")
    private String generatorRecord;

    @ApiModelProperty(value = "状态（0正常 1删除）")
    private String status;



}
