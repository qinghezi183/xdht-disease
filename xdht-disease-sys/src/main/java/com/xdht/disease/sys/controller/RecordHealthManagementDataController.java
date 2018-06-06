package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.CurrentUser;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.model.RecordHealthManagement;
import com.xdht.disease.sys.model.RecordHealthManagementData;
import com.xdht.disease.sys.service.RecordHealthManagementDataService;
import com.xdht.disease.sys.service.RecordHealthManagementService;
import com.xdht.disease.sys.vo.request.RecordHealthManagementDataRequest;
import com.xdht.disease.sys.vo.request.RecordHealthManagementRequest;
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
@RequestMapping(value = "/api/v1/recordHealthManagementData")
public class RecordHealthManagementDataController {

    @Autowired
    private RecordHealthManagementDataService recordHealthManagementDataService;

    @RequestMapping(value = "/recordList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询列表")
    public  ResponseEntity<Result<List<RecordHealthManagementData>>> recordList(@CurrentUser User user, @RequestBody RecordHealthManagementDataRequest recordHealthManagementDataRequest) {
        return new ResponseEntity<>(Result.ok(recordHealthManagementDataService.queryList(recordHealthManagementDataRequest)), HttpStatus.OK);
    }
    @RequestMapping(value = "/recordPage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询")
    public ResponseEntity<Result<PageResult<RecordHealthManagementData>>> recordPage(@CurrentUser User user, @RequestBody RecordHealthManagementDataRequest recordHealthManagementDataRequest, @RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return new ResponseEntity<>(Result.ok(recordHealthManagementDataService.queryListPage(recordHealthManagementDataRequest,pageNum,pageSize)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
    public ResponseEntity<Result<RecordHealthManagementData>> add(@CurrentUser User user, @RequestBody RecordHealthManagementData recordHealthManagementData) {
        return new ResponseEntity<>(Result.ok(recordHealthManagementDataService.add(recordHealthManagementData)), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除")
    public ResponseEntity<Result<RecordHealthManagementData>> delete(@CurrentUser User user, @RequestParam Long id) {
        return new ResponseEntity<>(Result.ok(recordHealthManagementDataService.delete(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改")
    public ResponseEntity<Result<RecordHealthManagementData>> update(@CurrentUser User user, @RequestBody RecordHealthManagementData recordHealthManagementData) {
        return new ResponseEntity<>(Result.ok(recordHealthManagementDataService.update(recordHealthManagementData)), HttpStatus.OK);
    }



}
