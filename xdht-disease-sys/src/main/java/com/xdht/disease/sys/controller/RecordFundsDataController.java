package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.CurrentUser;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.model.RecordFunds;
import com.xdht.disease.sys.model.RecordFundsData;
import com.xdht.disease.sys.service.RecordFundsDataService;
import com.xdht.disease.sys.service.RecordFundsService;
import com.xdht.disease.sys.vo.request.RecordFundsDataRequest;
import com.xdht.disease.sys.vo.request.RecordFundsRequest;
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
@RequestMapping(value = "/api/v1/recordFundsData")
public class RecordFundsDataController {

    @Autowired
    private RecordFundsDataService recordFundsDataService;

    @RequestMapping(value = "/recordList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询列表")
    public  ResponseEntity<Result<List<RecordFundsData>>> recordList(@CurrentUser User user, @RequestBody RecordFundsDataRequest recordFundsDataRequest) {
        return new ResponseEntity<>(Result.ok(recordFundsDataService.queryList(recordFundsDataRequest)), HttpStatus.OK);
    }
    @RequestMapping(value = "/recordPage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询")
    public ResponseEntity<Result<PageResult<RecordFundsData>>> recordPage(@CurrentUser User user, @RequestBody RecordFundsDataRequest recordFundsDataRequest, @RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return new ResponseEntity<>(Result.ok(recordFundsDataService.queryListPage(recordFundsDataRequest,pageNum,pageSize)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
    public ResponseEntity<Result<RecordFundsData>> add(@CurrentUser User user, @RequestBody RecordFundsData recordFundsData) {
        return new ResponseEntity<>(Result.ok(recordFundsDataService.add(recordFundsData)), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除")
    public ResponseEntity<Result<RecordFundsData>> delete(@CurrentUser User user, @RequestParam Long id) {
        return new ResponseEntity<>(Result.ok(recordFundsDataService.delete(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改")
    public ResponseEntity<Result<RecordFundsData>> update(@CurrentUser User user, @RequestBody RecordFundsData recordFundsData) {
        return new ResponseEntity<>(Result.ok(recordFundsDataService.update(recordFundsData)), HttpStatus.OK);
    }



}
