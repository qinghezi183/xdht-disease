package com.xdht.disease.sys.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class RecordProductDataRequest {

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "部门ID")
    private Long companyOfficeId;

    @ApiModelProperty(value = "工艺过程")
    private String processName;

    @ApiModelProperty(value = "类别")
    private String productType;

    @ApiModelProperty(value = "名称")
    private String productName;

    @ApiModelProperty(value = "形态")
    private String productShape;

    @ApiModelProperty(value = "主要化学成分")
    private String chemicalComposition;

    @ApiModelProperty(value = "存储方式")
    private String storageMode;

    @ApiModelProperty(value = "输送方式")
    private String transportMode;

    @ApiModelProperty(value = "年用量或产量")
    private String annualAmount;


}
