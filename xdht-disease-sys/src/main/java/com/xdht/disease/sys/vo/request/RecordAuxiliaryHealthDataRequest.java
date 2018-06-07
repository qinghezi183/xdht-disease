package com.xdht.disease.sys.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class RecordAuxiliaryHealthDataRequest {

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "部门id")
    private Long officeId;

    @ApiModelProperty(value = "工作场所办公室（控制室、办公室）")
    private String workPlace;

    @ApiModelProperty(value = "车间/部门卫生用室（浴室、存/更衣室、盥洗室、洗衣房）")
    private String hygienicRoom;

    @ApiModelProperty(value = "生活用室（休息室、食堂、厕所等）")
    private String livingRoom;


}
