package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.CurrentUser;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.model.RecordHealthCareData;
import com.xdht.disease.sys.model.RecordHealthCareProject;
import com.xdht.disease.sys.service.RecordHealthCareDataService;
import com.xdht.disease.sys.service.RecordHealthCareProjectService;
import com.xdht.disease.sys.vo.request.RecordHealthCareDataRequest;
import com.xdht.disease.sys.vo.request.RecordHealthCareProjectRequest;
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
@RequestMapping(value = "/api/v1/recordHealthCareProject")
public class RecordHealthCareProjectController {

    @Autowired
    private RecordHealthCareProjectService recordHealthCareProjectService;

    @RequestMapping(value = "/recordList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询列表")
    public  ResponseEntity<Result<List<RecordHealthCareProject>>> recordList(@CurrentUser User user, @RequestBody RecordHealthCareProjectRequest recordHealthCareProjectRequest) {
        return new ResponseEntity<>(Result.ok(recordHealthCareProjectService.queryList(recordHealthCareProjectRequest)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加")
    public ResponseEntity<Result<RecordHealthCareProject>> add(@CurrentUser User user, @RequestBody RecordHealthCareProject recordHealthCareProject) {
        return new ResponseEntity<>(Result.ok(recordHealthCareProjectService.add(recordHealthCareProject)), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除")
    public ResponseEntity<Result<RecordHealthCareProject>> delete(@CurrentUser User user, @RequestParam Long id) {
        return new ResponseEntity<>(Result.ok(recordHealthCareProjectService.delete(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改")
    public ResponseEntity<Result<RecordHealthCareProject>> update(@CurrentUser User user, @RequestBody RecordHealthCareProject recordHealthCareProject) {
        return new ResponseEntity<>(Result.ok(recordHealthCareProjectService.update(recordHealthCareProject)), HttpStatus.OK);
    }



}
