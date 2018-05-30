package com.xdht.disease.sys.vo.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class SysUserResponse {

    @ApiModelProperty(value = "用户Id")
    private Long id ;

    @ApiModelProperty(value = "用户名称")
    private String userName;

}
