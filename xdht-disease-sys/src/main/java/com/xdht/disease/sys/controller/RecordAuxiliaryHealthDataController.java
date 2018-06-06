package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.CurrentUser;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.model.RecordAuxiliaryHealth;
import com.xdht.disease.sys.model.RecordAuxiliaryHealthData;
import com.xdht.disease.sys.service.RecordAuxiliaryHealthDataService;
import com.xdht.disease.sys.service.RecordAuxiliaryHealthService;
import com.xdht.disease.sys.vo.request.RecordAuxiliaryHealthDataRequest;
import com.xdht.disease.sys.vo.request.RecordAuxiliaryHealthRequest;
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
@RequestMapping(value = "/api/v1/recordAuxiliaryHealthData")
public class RecordAuxiliaryHealthDataController {

    @Autowired
    private RecordAuxiliaryHealthDataService recordAuxiliaryHealthDataService;

    @RequestMapping(value = "/recordList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询列表")
    public  ResponseEntity<Result<List<RecordAuxiliaryHealthData>>> recordList(@CurrentUser User user, @RequestBody RecordAuxiliaryHealthDataRequest recordAuxiliaryHealthDataRequest) {
        return new ResponseEntity<>(Result.ok(recordAuxiliaryHealthDataService.queryList(recordAuxiliaryHealthDataRequest)), HttpStatus.OK);
    }
    @RequestMapping(value = "/recordPage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询")
    public ResponseEntity<Result<PageResult<RecordAuxiliaryHealthData>>> recordPage(@CurrentUser User user, @RequestBody RecordAuxiliaryHealthDataRequest recordAuxiliaryHealthDataRequest,@RequestParam Integer pageNum,@RequestParam Integer pageSize) {
        return new ResponseEntity<>(Result.ok(recordAuxiliaryHealthDataService.queryListPage(recordAuxiliaryHealthDataRequest,pageNum,pageSize)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
    public ResponseEntity<Result<RecordAuxiliaryHealthData>> add(@CurrentUser User user, @RequestBody RecordAuxiliaryHealthData recordAuxiliaryHealthData) {
        return new ResponseEntity<>(Result.ok(recordAuxiliaryHealthDataService.add(recordAuxiliaryHealthData)), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除")
    public ResponseEntity<Result<RecordAuxiliaryHealthData>> delete(@CurrentUser User user, @RequestParam Long id) {
        return new ResponseEntity<>(Result.ok(recordAuxiliaryHealthDataService.delete(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改")
    public ResponseEntity<Result<RecordAuxiliaryHealthData>> update(@CurrentUser User user, @RequestBody RecordAuxiliaryHealthData recordAuxiliaryHealthData) {
        return new ResponseEntity<>(Result.ok(recordAuxiliaryHealthDataService.update(recordAuxiliaryHealthData)), HttpStatus.OK);
    }



}
