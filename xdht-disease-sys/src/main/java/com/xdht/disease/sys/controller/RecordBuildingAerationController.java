package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.CurrentUser;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.model.RecordAuxiliaryHealth;
import com.xdht.disease.sys.model.RecordBuildingAeration;
import com.xdht.disease.sys.service.RecordAuxiliaryHealthService;
import com.xdht.disease.sys.service.RecordBuildingAerationService;
import com.xdht.disease.sys.vo.request.RecordAuxiliaryHealthRequest;
import com.xdht.disease.sys.vo.request.RecordBuildingAerationRequest;
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
@RequestMapping(value = "/api/v1/recordBuildingAeration")
public class RecordBuildingAerationController {

    @Autowired
    private RecordBuildingAerationService recordBuildingAerationService;

    @RequestMapping(value = "/recordList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询列表")
    public  ResponseEntity<Result<List<RecordBuildingAeration>>> recordList(@CurrentUser User user, @RequestBody RecordBuildingAerationRequest recordBuildingAerationRequest) {
        return new ResponseEntity<>(Result.ok(recordBuildingAerationService.queryList(recordBuildingAerationRequest)), HttpStatus.OK);
    }
    @RequestMapping(value = "/recordPage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询")
    public ResponseEntity<Result<PageResult<RecordBuildingAeration>>> recordPage(@CurrentUser User user, @RequestBody RecordBuildingAerationRequest recordBuildingAerationRequest,@RequestParam Integer pageNum,@RequestParam Integer pageSize) {
        return new ResponseEntity<>(Result.ok(recordBuildingAerationService.queryListPage(recordBuildingAerationRequest,pageNum,pageSize)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
    public ResponseEntity<Result<RecordBuildingAeration>> add(@CurrentUser User user, @RequestBody RecordBuildingAeration recordBuildingAeration) {
        return new ResponseEntity<>(Result.ok(recordBuildingAerationService.add(recordBuildingAeration)), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除")
    public ResponseEntity<Result<RecordBuildingAeration>> delete(@CurrentUser User user, @RequestParam Long id) {
        return new ResponseEntity<>(Result.ok(recordBuildingAerationService.delete(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改")
    public ResponseEntity<Result<RecordBuildingAeration>> update(@CurrentUser User user, @RequestBody RecordBuildingAeration recordBuildingAeration) {
        return new ResponseEntity<>(Result.ok(recordBuildingAerationService.update(recordBuildingAeration)), HttpStatus.OK);
    }



}
