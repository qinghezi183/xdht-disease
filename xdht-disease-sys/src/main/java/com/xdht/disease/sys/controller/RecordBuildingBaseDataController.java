package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.CurrentUser;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.model.RecordBuildingBase;
import com.xdht.disease.sys.model.RecordBuildingBaseData;
import com.xdht.disease.sys.service.RecordBuildingBaseDataService;
import com.xdht.disease.sys.service.RecordBuildingBaseService;
import com.xdht.disease.sys.vo.request.RecordBuildingBaseDataRequest;
import com.xdht.disease.sys.vo.request.RecordBuildingBaseRequest;
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
@RequestMapping(value = "/api/v1/recordBuildingBaseData")
public class RecordBuildingBaseDataController {

    @Autowired
    private RecordBuildingBaseDataService recordBuildingBaseDataService;

    @RequestMapping(value = "/recordList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询列表")
    public  ResponseEntity<Result<List<RecordBuildingBaseData>>> recordList(@CurrentUser User user, @RequestBody RecordBuildingBaseDataRequest recordBuildingBaseDataRequest) {
        return new ResponseEntity<>(Result.ok(recordBuildingBaseDataService.queryList(recordBuildingBaseDataRequest)), HttpStatus.OK);
    }
    @RequestMapping(value = "/recordPage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询")
    public ResponseEntity<Result<PageResult<RecordBuildingBaseData>>> recordPage(@CurrentUser User user, @RequestBody RecordBuildingBaseDataRequest recordBuildingBaseDataRequest, @RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return new ResponseEntity<>(Result.ok(recordBuildingBaseDataService.queryListPage(recordBuildingBaseDataRequest,pageNum,pageSize)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
    public ResponseEntity<Result<RecordBuildingBaseData>> add(@CurrentUser User user, @RequestBody RecordBuildingBaseData recordBuildingBaseData) {
        return new ResponseEntity<>(Result.ok(recordBuildingBaseDataService.add(recordBuildingBaseData)), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除")
    public ResponseEntity<Result<RecordBuildingBaseData>> delete(@CurrentUser User user, @RequestParam Long id) {
        return new ResponseEntity<>(Result.ok(recordBuildingBaseDataService.delete(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改")
    public ResponseEntity<Result<RecordBuildingBaseData>> update(@CurrentUser User user, @RequestBody RecordBuildingBaseData recordBuildingBaseData) {
        return new ResponseEntity<>(Result.ok(recordBuildingBaseDataService.update(recordBuildingBaseData)), HttpStatus.OK);
    }



}
