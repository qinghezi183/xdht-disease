package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.CurrentUser;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.model.RecordOtherProtectiveFacilitiesData;
import com.xdht.disease.sys.service.RecordOtherProtectiveFacilitiesDataService;
import com.xdht.disease.sys.vo.request.RecordOtherProtectiveFacilitiesDataRequest;
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
@RequestMapping(value = "/api/v1/recordOtherProtectiveFacilitiesData")
public class RecordOtherProtectiveFacilitiesDataController {

    @Autowired
    private RecordOtherProtectiveFacilitiesDataService recordDataService;

    @RequestMapping(value = "/recordList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询列表")
    public  ResponseEntity<Result<List<RecordOtherProtectiveFacilitiesData>>> recordList(@CurrentUser User user, @RequestBody RecordOtherProtectiveFacilitiesDataRequest recordDataRequest) {
        return new ResponseEntity<>(Result.ok(recordDataService.queryList(recordDataRequest)), HttpStatus.OK);
    }
    @RequestMapping(value = "/recordPage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询")
    public ResponseEntity<Result<PageResult<RecordOtherProtectiveFacilitiesData>>> recordPage(@CurrentUser User user, @RequestBody RecordOtherProtectiveFacilitiesDataRequest recordDataRequest, @RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return new ResponseEntity<>(Result.ok(recordDataService.queryListPage(recordDataRequest,pageNum,pageSize)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
    public ResponseEntity<Result<RecordOtherProtectiveFacilitiesData>> add(@CurrentUser User user, @RequestBody RecordOtherProtectiveFacilitiesData recordOtherProtectiveFacilitiesData) {
        return new ResponseEntity<>(Result.ok(recordDataService.add(recordOtherProtectiveFacilitiesData)), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除")
    public ResponseEntity<Result<RecordOtherProtectiveFacilitiesData>> delete(@CurrentUser User user, @RequestParam Long id) {
        return new ResponseEntity<>(Result.ok(recordDataService.delete(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改")
    public ResponseEntity<Result<RecordOtherProtectiveFacilitiesData>> update(@CurrentUser User user, @RequestBody RecordOtherProtectiveFacilitiesData recordOtherProtectiveFacilitiesData) {
        return new ResponseEntity<>(Result.ok(recordDataService.update(recordOtherProtectiveFacilitiesData)), HttpStatus.OK);
    }



}
