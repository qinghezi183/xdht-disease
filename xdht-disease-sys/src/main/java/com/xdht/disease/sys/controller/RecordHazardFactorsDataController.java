package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.CurrentUser;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.model.RecordHazardFactorsData;
import com.xdht.disease.sys.service.RecordHazardFactorsDataService;
import com.xdht.disease.sys.vo.request.RecordHazardFactorsDataRequest;
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
@RequestMapping(value = "/api/v1/recordHazardFactorsData")
public class RecordHazardFactorsDataController {

    @Autowired
    private RecordHazardFactorsDataService recordHazardFactorsDataService;

    @RequestMapping(value = "/recordList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询列表")
    public  ResponseEntity<Result<List<RecordHazardFactorsData>>> recordList(@CurrentUser User user, @RequestBody RecordHazardFactorsDataRequest recordHazardFactorsDataRequest) {
        return new ResponseEntity<>(Result.ok(recordHazardFactorsDataService.queryList(recordHazardFactorsDataRequest)), HttpStatus.OK);
    }
    @RequestMapping(value = "/recordPage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询")
    public ResponseEntity<Result<PageResult<RecordHazardFactorsData>>> recordPage(@CurrentUser User user, @RequestBody RecordHazardFactorsDataRequest recordHazardFactorsDataRequest, @RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return new ResponseEntity<>(Result.ok(recordHazardFactorsDataService.queryListPage(recordHazardFactorsDataRequest,pageNum,pageSize)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
    public ResponseEntity<Result<RecordHazardFactorsData>> add(@CurrentUser User user, @RequestBody RecordHazardFactorsData recordHazardFactorsData) {
        return new ResponseEntity<>(Result.ok(recordHazardFactorsDataService.add(recordHazardFactorsData)), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除")
    public ResponseEntity<Result<RecordHazardFactorsData>> delete(@CurrentUser User user, @RequestParam Long id) {
        return new ResponseEntity<>(Result.ok(recordHazardFactorsDataService.delete(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改")
    public ResponseEntity<Result<RecordHazardFactorsData>> update(@CurrentUser User user, @RequestBody RecordHazardFactorsData recordHazardFactorsData) {
        return new ResponseEntity<>(Result.ok(recordHazardFactorsDataService.update(recordHazardFactorsData)), HttpStatus.OK);
    }



}
