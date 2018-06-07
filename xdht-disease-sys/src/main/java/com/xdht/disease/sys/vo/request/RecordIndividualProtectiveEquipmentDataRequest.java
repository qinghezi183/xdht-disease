package com.xdht.disease.sys.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class RecordIndividualProtectiveEquipmentDataRequest {

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "部门id")
    private Long companyOfficeId;

    @ApiModelProperty(value = "工种id")
    private Long postId;

    @ApiModelProperty(value = "接触职业病危害因素")
    private String hazardFactors;

    @ApiModelProperty(value = "防护用品名称")
    private String protectiveEquipment;

    @ApiModelProperty(value = "技术参数")
    private String technicalParameter;

    @ApiModelProperty(value = "数量")
    private Long number;

    @ApiModelProperty(value = "使用情况")
    private String usaged;


}
