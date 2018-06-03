package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.Authorization;
import com.xdht.disease.common.authorization.annotation.CurrentUser;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.model.SysUser;
import com.xdht.disease.sys.model.SysUserRole;
import com.xdht.disease.sys.service.SysUserRoleService;
import com.xdht.disease.sys.vo.request.SysUserRoleRequest;
import com.xdht.disease.sys.vo.response.SysUserResponse;
import com.xdht.disease.sys.vo.response.SysUserRoleResponse;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by L on 2018/5/30.
 */
@Log4j
@RestController
@RequestMapping(value = "/api/v1/sysUserRole")
public class SysUserRoleController {

    @Autowired
    private SysUserRoleService sysUserRoleService;

    @RequestMapping(value = "/usersRolePage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询用户角色列表")
//    @Authorization
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
//    })
    public ResponseEntity<Result<PageResult<SysUserRole>>> usersRolePage(@CurrentUser User user, @RequestBody SysUserRoleRequest sysUserRoleRequest) {
        return new ResponseEntity<>(Result.ok(sysUserRoleService.querySysUserRolePage(sysUserRoleRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/usersRoleList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询用户角色列表")
    public ResponseEntity<Result<List<SysUserRole>>> usersRoleList(@CurrentUser User user, @RequestBody SysUserRole sysUserRole) {
        return new ResponseEntity<>(Result.ok(sysUserRoleService.querySysUserRoleList(sysUserRole)), HttpStatus.OK);
    }



    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加用户角色")
    public ResponseEntity<Result<SysUserRoleResponse>> addUserRole(@CurrentUser User user, @RequestBody SysUserRole sysUserRole) {
        return new ResponseEntity<>(Result.ok(sysUserRoleService.addUserRole(sysUserRole)), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除用户角色")
    public ResponseEntity<Result<SysUserResponse>> deleteUserRole(@CurrentUser User user, @RequestParam Long id) {
        return new ResponseEntity<>(Result.ok(sysUserRoleService.deleteUserRole(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改用户角色")
    public ResponseEntity<Result<SysUserRoleResponse>> updateUserRole(@CurrentUser User user, @RequestBody SysUserRole sysUserRole) {
        return new ResponseEntity<>(Result.ok(sysUserRoleService.updateUserRole(sysUserRole)), HttpStatus.OK);
    }



}
