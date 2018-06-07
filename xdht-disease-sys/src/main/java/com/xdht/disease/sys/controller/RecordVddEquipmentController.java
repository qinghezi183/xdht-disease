package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.CurrentUser;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.model.RecordProduct;
import com.xdht.disease.sys.model.RecordVddEquipment;
import com.xdht.disease.sys.service.RecordProductService;
import com.xdht.disease.sys.service.RecordVddEquipmentService;
import com.xdht.disease.sys.vo.request.RecordProductRequest;
import com.xdht.disease.sys.vo.request.RecordVddEquipmentRequest;
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
@RequestMapping(value = "/api/v1/recordVddEquipment")
public class RecordVddEquipmentController {

    @Autowired
    private RecordVddEquipmentService recordVddEquipmentService;

    @RequestMapping(value = "/recordList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询列表")
    public  ResponseEntity<Result<List<RecordVddEquipment>>> recordList(@CurrentUser User user, @RequestBody RecordVddEquipmentRequest recordVddEquipmentRequest) {
        return new ResponseEntity<>(Result.ok(recordVddEquipmentService.queryList(recordVddEquipmentRequest)), HttpStatus.OK);
    }
    @RequestMapping(value = "/recordPage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询")
    public ResponseEntity<Result<PageResult<RecordVddEquipment>>> recordPage(@CurrentUser User user, @RequestBody RecordVddEquipmentRequest recordVddEquipmentRequest, @RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return new ResponseEntity<>(Result.ok(recordVddEquipmentService.queryListPage(recordVddEquipmentRequest,pageNum,pageSize)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
    public ResponseEntity<Result<RecordVddEquipment>> add(@CurrentUser User user, @RequestBody RecordVddEquipment recordVddEquipment) {
        return new ResponseEntity<>(Result.ok(recordVddEquipmentService.add(recordVddEquipment)), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除")
    public ResponseEntity<Result<RecordVddEquipment>> delete(@CurrentUser User user, @RequestParam Long id) {
        return new ResponseEntity<>(Result.ok(recordVddEquipmentService.delete(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改")
    public ResponseEntity<Result<RecordVddEquipment>> update(@CurrentUser User user, @RequestBody RecordVddEquipment recordVddEquipment) {
        return new ResponseEntity<>(Result.ok(recordVddEquipmentService.update(recordVddEquipment)), HttpStatus.OK);
    }



}
