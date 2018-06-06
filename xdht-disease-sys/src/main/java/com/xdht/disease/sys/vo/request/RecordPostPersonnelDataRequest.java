package com.xdht.disease.sys.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class RecordPostPersonnelDataRequest {

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "部门id")
    private Long companyOfficeId;

    @ApiModelProperty(value = "职位id")
    private Long postId;

    @ApiModelProperty(value = "每班")
    private Long perShift;

    @ApiModelProperty(value = "总定员")
    private Long totalNumber;

    @ApiModelProperty(value = "天/周")
    private Long dayOfWeek;

    @ApiModelProperty(value = "班/天")
    private Long classOfDate;

    @ApiModelProperty(value = "小时/班")
    private Long hourOfClass;


}
