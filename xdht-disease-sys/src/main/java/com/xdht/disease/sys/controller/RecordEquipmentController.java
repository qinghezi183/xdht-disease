package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.CurrentUser;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.model.RecordEmergencyFacilities;
import com.xdht.disease.sys.model.RecordEquipment;
import com.xdht.disease.sys.service.RecordEmergencyFacilitiesService;
import com.xdht.disease.sys.service.RecordEquipmentService;
import com.xdht.disease.sys.vo.request.RecordEmergencyFacilitiesRequest;
import com.xdht.disease.sys.vo.request.RecordEquipmentRequest;
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
@RequestMapping(value = "/api/v1/recordEquipment")
public class RecordEquipmentController {

    @Autowired
    private RecordEquipmentService recordEquipmentService;

    @RequestMapping(value = "/recordList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询列表")
    public  ResponseEntity<Result<List<RecordEquipment>>> recordList(@CurrentUser User user, @RequestBody RecordEquipmentRequest recordEquipmentRequest) {
        return new ResponseEntity<>(Result.ok(recordEquipmentService.queryList(recordEquipmentRequest)), HttpStatus.OK);
    }
    @RequestMapping(value = "/recordPage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询")
    public ResponseEntity<Result<PageResult<RecordEquipment>>> recordPage(@CurrentUser User user, @RequestBody RecordEquipmentRequest recordEquipmentRequest, @RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return new ResponseEntity<>(Result.ok(recordEquipmentService.queryListPage(recordEquipmentRequest,pageNum,pageSize)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
    public ResponseEntity<Result<RecordEquipment>> add(@CurrentUser User user, @RequestBody RecordEquipment recordEquipment) {
        return new ResponseEntity<>(Result.ok(recordEquipmentService.add(recordEquipment)), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除")
    public ResponseEntity<Result<RecordEquipment>> delete(@CurrentUser User user, @RequestParam Long id) {
        return new ResponseEntity<>(Result.ok(recordEquipmentService.delete(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改")
    public ResponseEntity<Result<RecordEquipment>> update(@CurrentUser User user, @RequestBody RecordEquipment recordEquipment) {
        return new ResponseEntity<>(Result.ok(recordEquipmentService.update(recordEquipment)), HttpStatus.OK);
    }



}
