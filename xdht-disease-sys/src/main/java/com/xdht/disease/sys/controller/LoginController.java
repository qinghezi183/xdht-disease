package com.xdht.disease.sys.controller;

import com.xdht.disease.common.core.Result;
import com.xdht.disease.sys.service.SysUserService;
import com.xdht.disease.sys.vo.request.LoginRequest;
import com.xdht.disease.sys.vo.response.LoginResponse;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by L on 2018/5/30.
 */
@Log4j
@RestController
@RequestMapping(value = "/api/v1/login")
public class LoginController {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping(value = "/createToken", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "主页生成并保存token")
    public ResponseEntity<Result<LoginResponse>> createToken(@RequestBody LoginRequest loginRequest) {
        return new ResponseEntity<Result<LoginResponse>>(Result.ok(sysUserService.createToken(loginRequest)), HttpStatus.OK);
    }

}
