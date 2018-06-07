package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.CurrentUser;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.model.RecordEmergencyFacilities;
import com.xdht.disease.sys.model.RecordEmergencyFacilitiesData;
import com.xdht.disease.sys.service.RecordEmergencyFacilitiesDataService;
import com.xdht.disease.sys.vo.request.RecordEmergencyFacilitiesDataRequest;
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
@RequestMapping(value = "/api/v1/recordEmergencyFacilitiesData")
public class RecordEmergencyFacilitiesDataController {

    @Autowired
    private RecordEmergencyFacilitiesDataService recordEmergencyFacilitiesDataService;

    @RequestMapping(value = "/recordList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询列表")
    public  ResponseEntity<Result<List<RecordEmergencyFacilitiesData>>> recordList(@CurrentUser User user, @RequestBody RecordEmergencyFacilitiesDataRequest recordEmergencyFacilitiesDataRequest) {
        return new ResponseEntity<>(Result.ok(recordEmergencyFacilitiesDataService.queryList(recordEmergencyFacilitiesDataRequest)), HttpStatus.OK);
    }
    @RequestMapping(value = "/recordPage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询")
    public ResponseEntity<Result<PageResult<RecordEmergencyFacilitiesData>>> recordPage(@CurrentUser User user, @RequestBody RecordEmergencyFacilitiesDataRequest recordEmergencyFacilitiesDataRequest, @RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return new ResponseEntity<>(Result.ok(recordEmergencyFacilitiesDataService.queryListPage(recordEmergencyFacilitiesDataRequest,pageNum,pageSize)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
    public ResponseEntity<Result<RecordEmergencyFacilitiesData>> add(@CurrentUser User user, @RequestBody RecordEmergencyFacilitiesData recordEmergencyFacilitiesData) {
        return new ResponseEntity<>(Result.ok(recordEmergencyFacilitiesDataService.add(recordEmergencyFacilitiesData)), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除")
    public ResponseEntity<Result<RecordEmergencyFacilities>> delete(@CurrentUser User user, @RequestParam Long id) {
        return new ResponseEntity<>(Result.ok(recordEmergencyFacilitiesDataService.delete(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改")
    public ResponseEntity<Result<RecordEmergencyFacilitiesData>> update(@CurrentUser User user, @RequestBody RecordEmergencyFacilitiesData recordEmergencyFacilitiesData) {
        return new ResponseEntity<>(Result.ok(recordEmergencyFacilitiesDataService.update(recordEmergencyFacilitiesData)), HttpStatus.OK);
    }



}
