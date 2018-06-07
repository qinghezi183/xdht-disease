package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.CurrentUser;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.model.RecordVddEquipment;
import com.xdht.disease.sys.model.RecordWorkLog;
import com.xdht.disease.sys.service.RecordVddEquipmentService;
import com.xdht.disease.sys.service.RecordWorkLogService;
import com.xdht.disease.sys.vo.request.RecordVddEquipmentRequest;
import com.xdht.disease.sys.vo.request.RecordWorkLogRequest;
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
@RequestMapping(value = "/api/v1/recordWorkLog")
public class RecordWorkLogController {

    @Autowired
    private RecordWorkLogService recordWorkLogService;

    @RequestMapping(value = "/recordList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询列表")
    public  ResponseEntity<Result<List<RecordWorkLog>>> recordList(@CurrentUser User user, @RequestBody RecordWorkLogRequest recordWorkLogRequest) {
        return new ResponseEntity<>(Result.ok(recordWorkLogService.queryList(recordWorkLogRequest)), HttpStatus.OK);
    }
    @RequestMapping(value = "/recordPage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询")
    public ResponseEntity<Result<PageResult<RecordWorkLog>>> recordPage(@CurrentUser User user, @RequestBody RecordWorkLogRequest recordWorkLogRequest, @RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return new ResponseEntity<>(Result.ok(recordWorkLogService.queryListPage(recordWorkLogRequest,pageNum,pageSize)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
    public ResponseEntity<Result<RecordWorkLog>> add(@CurrentUser User user, @RequestBody RecordWorkLog recordWorkLog) {
        return new ResponseEntity<>(Result.ok(recordWorkLogService.add(recordWorkLog)), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除")
    public ResponseEntity<Result<RecordWorkLog>> delete(@CurrentUser User user, @RequestParam Long id) {
        return new ResponseEntity<>(Result.ok(recordWorkLogService.delete(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改")
    public ResponseEntity<Result<RecordWorkLog>> update(@CurrentUser User user, @RequestBody RecordWorkLog recordWorkLog) {
        return new ResponseEntity<>(Result.ok(recordWorkLogService.update(recordWorkLog)), HttpStatus.OK);
    }



}
