package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.CurrentUser;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.model.RecordPresentSituation;
import com.xdht.disease.sys.model.RecordPresentSituationData;
import com.xdht.disease.sys.service.RecordPresentSituationDataService;
import com.xdht.disease.sys.service.RecordPresentSituationService;
import com.xdht.disease.sys.vo.request.RecordPresentSituationDataRequest;
import com.xdht.disease.sys.vo.request.RecordPresentSituationRequest;
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
@RequestMapping(value = "/api/v1/recordPresentSituationData")
public class RecordPresentSituationDataController {

    @Autowired
    private RecordPresentSituationDataService recordPresentSituationDataService;

    @RequestMapping(value = "/recordDataList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询列表")
    public  ResponseEntity<Result<List<RecordPresentSituationData>>> recordDataList(@CurrentUser User user, @RequestBody RecordPresentSituationDataRequest recordPresentSituationDataRequest) {
        return new ResponseEntity<>(Result.ok(recordPresentSituationDataService.queryList(recordPresentSituationDataRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/recordPage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询")
    public ResponseEntity<Result<PageResult<RecordPresentSituationData>>> recordPage(@CurrentUser User user, @RequestBody RecordPresentSituationDataRequest recordPresentSituationDataRequest, @RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return new ResponseEntity<>(Result.ok(recordPresentSituationDataService.queryListPage(recordPresentSituationDataRequest,pageNum,pageSize)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
    public ResponseEntity<Result<RecordPresentSituationData>> addRecordPresentSituationData(@CurrentUser User user, @RequestBody RecordPresentSituationData recordPresentSituationData) {
        return new ResponseEntity<>(Result.ok(recordPresentSituationDataService.addRecordPresentSituationData(recordPresentSituationData)), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除")
    public ResponseEntity<Result<RecordPresentSituationData>> deleteRecordPresentSituationData(@CurrentUser User user, @RequestParam Long id) {
        return new ResponseEntity<>(Result.ok(recordPresentSituationDataService.deleteRecordPresentSituationData(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改")
    public ResponseEntity<Result<RecordPresentSituationData>> updateRecordPresentSituationData(@CurrentUser User user, @RequestBody RecordPresentSituationData recordPresentSituationData) {
        return new ResponseEntity<>(Result.ok(recordPresentSituationDataService.updateRecordPresentSituationData(recordPresentSituationData)), HttpStatus.OK);
    }



}
