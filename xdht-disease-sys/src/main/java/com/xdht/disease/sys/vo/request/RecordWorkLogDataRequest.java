package com.xdht.disease.sys.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class RecordWorkLogDataRequest {

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "部门id")
    private Long companyOfficeId;

    @ApiModelProperty(value = "职位id")
    private Long postId;

    @ApiModelProperty(value = "工作地点")
    private String workPlace;

    @ApiModelProperty(value = "每班人数")
    private Long personOfClass;

    @ApiModelProperty(value = "工作时间")
    private String workHours;

    @ApiModelProperty(value = "工作内容")
    private String workContent;

    @ApiModelProperty(value = "危害因素")
    private String hazardFactors;

    @ApiModelProperty(value = "备注")
    private String remarks;

}
