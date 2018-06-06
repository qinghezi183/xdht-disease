package com.xdht.disease.sys.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class RecordInformingFacilitiesDataRequest {

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "部门ID")
    private Long companyOfficeId;

    @ApiModelProperty(value = "工艺过程")
    private String processName;

    @ApiModelProperty(value = "职业病危害因素")
    private String hazardFactors;

    @ApiModelProperty(value = "危害告知设施设置情况")
    private String informingFacilities;

    @ApiModelProperty(value = "设置地点")
    private String settingPlace;

    @ApiModelProperty(value = "备注")
    private String remarks;

}
