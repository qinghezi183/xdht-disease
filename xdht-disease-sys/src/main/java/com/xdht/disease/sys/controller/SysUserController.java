package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.Authorization;
import com.xdht.disease.common.authorization.annotation.CurrentUser;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.model.SysUser;
import com.xdht.disease.sys.service.SysUserService;
import com.xdht.disease.sys.vo.request.SysUserRequest;
import com.xdht.disease.sys.vo.response.SysUserResponse;
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
@RequestMapping(value = "/api/v1/sysUser")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping(value = "/users", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询用户列表")
//    @Authorization
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
//    })
    public ResponseEntity<Result<List<SysUserResponse>>> createToken(@CurrentUser User user, @RequestBody SysUserRequest sysUserRequest) {
        return new ResponseEntity<>(Result.ok(sysUserService.querySysUserList(sysUserRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加用户")
    public ResponseEntity<Result<SysUserResponse>> addUsers(@CurrentUser User user, @RequestBody SysUser sysUser) {
        return new ResponseEntity<>(Result.ok(sysUserService.addUsers(sysUser)), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除用户")
    public ResponseEntity<Result<SysUserResponse>> deleteUsers(@CurrentUser User user, @RequestParam Long id) {
        return new ResponseEntity<>(Result.ok(sysUserService.deleteUsers(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改用户")
    public ResponseEntity<Result<SysUserResponse>> updateUsers(@CurrentUser User user, @RequestBody SysUser sysUser) {
        return new ResponseEntity<>(Result.ok(sysUserService.updateUsers(sysUser)), HttpStatus.OK);
    }



}
