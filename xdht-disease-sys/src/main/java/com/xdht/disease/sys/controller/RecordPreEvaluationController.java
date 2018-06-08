package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.CurrentUser;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.model.RecordPreEvaluation;
import com.xdht.disease.sys.service.RecordPreEvaluationService;
import com.xdht.disease.sys.vo.request.RecordPreEvaluationRequest;
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
@RequestMapping(value = "/api/v1/recordPreEvaluation")
public class RecordPreEvaluationController {

    @Autowired
    private RecordPreEvaluationService recordPreEvaluationService;

    @RequestMapping(value = "/recordList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询列表")
    public  ResponseEntity<Result<List<RecordPreEvaluation>>> recordList(@CurrentUser User user, @RequestBody RecordPreEvaluationRequest recordPreEvaluationRequest) {
        return new ResponseEntity<>(Result.ok(recordPreEvaluationService.queryList(recordPreEvaluationRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/recordPage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询")
    public ResponseEntity<Result<PageResult<RecordPreEvaluation>>> recordPage(@CurrentUser User user, @RequestBody RecordPreEvaluationRequest recordPreEvaluationRequest, @RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return new ResponseEntity<>(Result.ok(recordPreEvaluationService.queryListPage(recordPreEvaluationRequest,pageNum,pageSize)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
    public ResponseEntity<Result<RecordPreEvaluation>> addRecordControlEffect(@CurrentUser User user, @RequestBody RecordPreEvaluation recordPreEvaluation) {
        return new ResponseEntity<>(Result.ok(recordPreEvaluationService.addRecordPreEvaluation(recordPreEvaluation)), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除")
    public ResponseEntity<Result<RecordPreEvaluation>> deleteRecordPreEvaluation(@CurrentUser User user, @RequestParam Long id) {
        return new ResponseEntity<>(Result.ok(recordPreEvaluationService.deleteRecordPreEvaluation(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改")
    public ResponseEntity<Result<RecordPreEvaluation>> updateRecordPreEvaluation(@CurrentUser User user, @RequestBody RecordPreEvaluation recordPreEvaluation) {
        return new ResponseEntity<>(Result.ok(recordPreEvaluationService.updateRecordPreEvaluation(recordPreEvaluation)), HttpStatus.OK);
    }



}
