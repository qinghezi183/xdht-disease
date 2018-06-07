package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.CurrentUser;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.model.RecordFunds;
import com.xdht.disease.sys.model.RecordFundsProject;
import com.xdht.disease.sys.service.RecordFundsProjectService;
import com.xdht.disease.sys.service.RecordFundsService;
import com.xdht.disease.sys.vo.request.RecordFundsProjectRequest;
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
@RequestMapping(value = "/api/v1/recordFundsProject")
public class RecordFundsProjectController {

    @Autowired
    private RecordFundsProjectService recordFundsProjectService;

    @RequestMapping(value = "/recordList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询列表")
    public  ResponseEntity<Result<List<RecordFundsProject>>> recordList(@CurrentUser User user, @RequestBody RecordFundsProjectRequest recordFundsProjectRequest) {
        return new ResponseEntity<>(Result.ok(recordFundsProjectService.queryList(recordFundsProjectRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
    public ResponseEntity<Result<RecordFundsProject>> add(@CurrentUser User user, @RequestBody RecordFundsProject recordFundsProject) {
        return new ResponseEntity<>(Result.ok(recordFundsProjectService.add(recordFundsProject)), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除")
    public ResponseEntity<Result<RecordFundsProject>> delete(@CurrentUser User user, @RequestParam Long id) {
        return new ResponseEntity<>(Result.ok(recordFundsProjectService.delete(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改")
    public ResponseEntity<Result<RecordFundsProject>> update(@CurrentUser User user, @RequestBody RecordFundsProject recordFundsProject) {
        return new ResponseEntity<>(Result.ok(recordFundsProjectService.update(recordFundsProject)), HttpStatus.OK);
    }



}
