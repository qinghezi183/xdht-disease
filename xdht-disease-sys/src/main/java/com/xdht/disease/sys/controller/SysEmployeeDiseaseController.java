package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.CurrentUser;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.model.SysEmployeeDisease;
import com.xdht.disease.sys.service.SysEmployeeDiseaseService;
import com.xdht.disease.sys.vo.request.SysEmployeeDiseaseRequest;
import com.xdht.disease.sys.vo.response.SysEmployeeDiseaseResponse;
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
@RequestMapping(value = "/api/v1/sysEmployeeDisease")
public class SysEmployeeDiseaseController {

    @Autowired
    private SysEmployeeDiseaseService sysEmployeeDiseaseService;

    @RequestMapping(value = "/employeeDiseases", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询员工职业病列表分页")
//    @Authorization
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
//    })
    public ResponseEntity<Result<List<SysEmployeeDisease>>> createToken(@CurrentUser User user, @RequestBody SysEmployeeDiseaseRequest sysEmployeeDiseaseRequest) {
        return new ResponseEntity<>(Result.ok(sysEmployeeDiseaseService.querySysEmpDiseaseListPage(sysEmployeeDiseaseRequest)), HttpStatus.OK);

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加员工职业病")
    public ResponseEntity<Result<SysEmployeeDiseaseResponse>> addEmployeeDisease(@CurrentUser User user, @RequestBody SysEmployeeDisease sysEmployeeDisease) {
        return new ResponseEntity<>(Result.ok(sysEmployeeDiseaseService.addEmployeeDisease(sysEmployeeDisease)), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除员工职业病")
    public ResponseEntity<Result<SysEmployeeDiseaseResponse>> deleteEmployeeDisease(@CurrentUser User user, @RequestParam Long id) {
        return new ResponseEntity<>(Result.ok(sysEmployeeDiseaseService.deleteEmployeeDisease(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改员工职业病")
    public ResponseEntity<Result<SysEmployeeDiseaseResponse>> updateEmployeeDisease(@CurrentUser User user, @RequestBody SysEmployeeDisease sysEmployeeDisease) {
        return new ResponseEntity<>(Result.ok(sysEmployeeDiseaseService.updateEmployeeDisease(sysEmployeeDisease)), HttpStatus.OK);
    }

}
