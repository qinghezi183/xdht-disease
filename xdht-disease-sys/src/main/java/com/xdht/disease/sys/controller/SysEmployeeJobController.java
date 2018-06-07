package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.CurrentUser;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.model.SysEmployeeJob;
import com.xdht.disease.sys.service.SysEmployeeJobService;
import com.xdht.disease.sys.vo.request.SysEmployeeJobRequest;
import com.xdht.disease.sys.vo.response.SysEmployeeJobResponse;
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
@RequestMapping(value = "/api/v1/sysEmployeeJob")
public class SysEmployeeJobController {

    @Autowired
    private SysEmployeeJobService sysEmployeeJobService;

    @RequestMapping(value = "/employeeJobPage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询员工工作列表")
//    @Authorization
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
//    })
    public ResponseEntity<Result<PageResult<SysEmployeeJob>>> employeeJobPage(@CurrentUser User user, @RequestBody SysEmployeeJobRequest sysEmployeeIobRequest) {
        return new ResponseEntity<>(Result.ok(sysEmployeeJobService.querySysEmpJobPage(sysEmployeeIobRequest)), HttpStatus.OK);

    }
    @RequestMapping(value = "/employeeJobList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询员工工作列表")
    public ResponseEntity<Result<List<SysEmployeeJob>>> employeeJobList(@CurrentUser User user, @RequestBody SysEmployeeJob sysEmployeeIob) {
        return new ResponseEntity<>(Result.ok(sysEmployeeJobService.querySysEmpJobList(sysEmployeeIob)), HttpStatus.OK);

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加员工工作")
    public ResponseEntity<Result<SysEmployeeJobResponse>> addEmployeeJob(@CurrentUser User user, @RequestBody SysEmployeeJob sysEmployeeJob) {
        return new ResponseEntity<>(Result.ok(sysEmployeeJobService.addEmployeeJob(sysEmployeeJob)), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除员工工作")
    public ResponseEntity<Result<SysEmployeeJobResponse>> deleteEmployeeJob(@CurrentUser User user, @RequestParam Long id) {
        return new ResponseEntity<>(Result.ok(sysEmployeeJobService.deleteEmployeeJob(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改员工工作")
    public ResponseEntity<Result<SysEmployeeJobResponse>> updateEmployeeJob(@CurrentUser User user, @RequestBody SysEmployeeJob sysEmployeeJob) {
        return new ResponseEntity<>(Result.ok(sysEmployeeJobService.updateEmployeeJob(sysEmployeeJob)), HttpStatus.OK);
    }

}
