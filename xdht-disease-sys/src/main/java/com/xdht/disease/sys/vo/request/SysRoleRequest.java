package com.xdht.disease.sys.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by L on 2018/5/30.
 */
@Data
public class SysRoleRequest {

    @ApiModelProperty(value = "角色名称")
    private String roleName;



}
