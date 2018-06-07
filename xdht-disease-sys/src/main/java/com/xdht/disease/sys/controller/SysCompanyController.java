package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.CurrentUser;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.model.SysCompany;
import com.xdht.disease.sys.service.SysCompanyService;
import com.xdht.disease.sys.vo.request.SysCompanyRequest;
import com.xdht.disease.sys.vo.response.SysCompanyResponse;
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
@RequestMapping(value = "/api/v1/sysCompany")
public class SysCompanyController {

    @Autowired
    private SysCompanyService sysCompanyService;

    @RequestMapping(value = "/companyPage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询单位列表")
    public ResponseEntity<Result<PageResult<SysCompany>>> companyPage(@CurrentUser User user, @RequestBody SysCompanyRequest sysCompanyRequest) {
        return new ResponseEntity<>(Result.ok(sysCompanyService.querySysCompanyListPage(sysCompanyRequest)), HttpStatus.OK);
    }
    @RequestMapping(value = "/companyList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询单位列表")
    public  ResponseEntity<Result<List<SysCompany>>> companyList(@CurrentUser User user, @RequestBody SysCompany sysCompany) {
        return new ResponseEntity<>(Result.ok(sysCompanyService.querySysCompanyList(sysCompany)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加单位")
    public ResponseEntity<Result<SysCompanyResponse>> addCompany(@CurrentUser User user, @RequestBody SysCompany sysCompany) {
        return new ResponseEntity<>(Result.ok(sysCompanyService.addCompany(sysCompany)), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除单位")
    public ResponseEntity<Result<SysCompanyResponse>> deleteCompany(@CurrentUser User user, @RequestParam Long id) {
        return new ResponseEntity<>(Result.ok(sysCompanyService.deleteCompany(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改单位")
    public ResponseEntity<Result<SysCompanyResponse>> updateCompany(@CurrentUser User user, @RequestBody SysCompany sysCompany) {
        return new ResponseEntity<>(Result.ok(sysCompanyService.updateCompany(sysCompany)), HttpStatus.OK);
    }



}
