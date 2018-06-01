package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.CurrentUser;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.model.SysEmployeeCase;
import com.xdht.disease.sys.service.SysEmployeeCaseService;
import com.xdht.disease.sys.vo.request.SysEmployeeCaseRequest;
import com.xdht.disease.sys.vo.response.SysEmployeeCaseResponse;
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
@RequestMapping(value = "/api/v1/sysEmployeeCase")
public class SysEmployeeCaseController {

    @Autowired
    private SysEmployeeCaseService sysEmployeeCaseService;

    @RequestMapping(value = "/employeeCases", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询员工疾病列表分页")
//    @Authorization
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
//    })
    public ResponseEntity<Result<List<SysEmployeeCase>>> createToken(@CurrentUser User user, @RequestBody SysEmployeeCaseRequest sysEmployeeCaseRequest) {
        return new ResponseEntity<>(Result.ok(sysEmployeeCaseService.querySysEmpCaseListPage(sysEmployeeCaseRequest)), HttpStatus.OK);

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加员工疾病")
    public ResponseEntity<Result<SysEmployeeCaseResponse>> addEmployeeCase(@CurrentUser User user, @RequestBody SysEmployeeCase sysEmployeeCase) {
        return new ResponseEntity<>(Result.ok(sysEmployeeCaseService.addEmployeeCase(sysEmployeeCase)), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除员工疾病")
    public ResponseEntity<Result<SysEmployeeCaseResponse>> deleteEmployeeCase(@CurrentUser User user, @RequestParam Long id) {
        return new ResponseEntity<>(Result.ok(sysEmployeeCaseService.deleteEmployeeCase(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改员工疾病")
    public ResponseEntity<Result<SysEmployeeCaseResponse>> updateEmployeeCase(@CurrentUser User user, @RequestBody SysEmployeeCase sysEmployeeCase) {
        return new ResponseEntity<>(Result.ok(sysEmployeeCaseService.updateEmployeeCase(sysEmployeeCase)), HttpStatus.OK);
    }

}
