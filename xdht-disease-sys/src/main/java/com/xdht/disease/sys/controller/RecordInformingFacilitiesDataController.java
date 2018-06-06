package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.CurrentUser;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.model.RecordInformingFacilities;
import com.xdht.disease.sys.model.RecordInformingFacilitiesData;
import com.xdht.disease.sys.service.RecordInformingFacilitiesDataService;
import com.xdht.disease.sys.service.RecordInformingFacilitiesService;
import com.xdht.disease.sys.vo.request.RecordInformingFacilitiesDataRequest;
import com.xdht.disease.sys.vo.request.RecordInformingFacilitiesRequest;
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
@RequestMapping(value = "/api/v1/recordInformingFacilitiesData")
public class RecordInformingFacilitiesDataController {

    @Autowired
    private RecordInformingFacilitiesDataService recordDataService;

    @RequestMapping(value = "/recordList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询列表")
    public  ResponseEntity<Result<List<RecordInformingFacilitiesData>>> recordList(@CurrentUser User user, @RequestBody RecordInformingFacilitiesDataRequest recordDataRequest) {
        return new ResponseEntity<>(Result.ok(recordDataService.queryList(recordDataRequest)), HttpStatus.OK);
    }
    @RequestMapping(value = "/recordPage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询")
    public ResponseEntity<Result<PageResult<RecordInformingFacilitiesData>>> recordPage(@CurrentUser User user, @RequestBody RecordInformingFacilitiesDataRequest recordDataRequest, @RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return new ResponseEntity<>(Result.ok(recordDataService.queryListPage(recordDataRequest,pageNum,pageSize)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
    public ResponseEntity<Result<RecordInformingFacilitiesData>> add(@CurrentUser User user, @RequestBody RecordInformingFacilitiesData recordInformingFacilitiesData) {
        return new ResponseEntity<>(Result.ok(recordDataService.add(recordInformingFacilitiesData)), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除")
    public ResponseEntity<Result<RecordInformingFacilitiesData>> delete(@CurrentUser User user, @RequestParam Long id) {
        return new ResponseEntity<>(Result.ok(recordDataService.delete(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改")
    public ResponseEntity<Result<RecordInformingFacilitiesData>> update(@CurrentUser User user, @RequestBody RecordInformingFacilitiesData recordInformingFacilitiesData) {
        return new ResponseEntity<>(Result.ok(recordDataService.update(recordInformingFacilitiesData)), HttpStatus.OK);
    }



}
