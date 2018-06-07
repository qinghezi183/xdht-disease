package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.CurrentUser;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.model.SysMenu;
import com.xdht.disease.sys.service.SysMenuService;
import com.xdht.disease.sys.vo.request.SysMenuRequest;
import com.xdht.disease.sys.vo.response.SysMenuResponse;
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
@RequestMapping(value = "/api/v1/sysMenu")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;

    @RequestMapping(value = "/menuPage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询菜单列表")
    public ResponseEntity<Result<List<SysMenu>>> menuPage(@CurrentUser User user, @RequestBody SysMenuRequest sysMenuRequest) {
        return new ResponseEntity<>(Result.ok(sysMenuService.querySysMenuPage(sysMenuRequest)), HttpStatus.OK);
    }
    @RequestMapping(value = "/menusList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询菜单列表")
    public ResponseEntity<Result<List<SysMenu>>> menusList(@CurrentUser User user, @RequestBody SysMenu sysMenu) {
        return new ResponseEntity<>(Result.ok(sysMenuService.querySysMenuList(sysMenu)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加菜单")
    public ResponseEntity<Result<SysMenuResponse>> addMenu(@CurrentUser User user, @RequestBody SysMenu sysMenu) {
        return new ResponseEntity<>(Result.ok(sysMenuService.addMenu(sysMenu)), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除菜单")
    public ResponseEntity<Result<SysMenuResponse>> deleteMenu(@CurrentUser User user, @RequestParam Long id) {
        return new ResponseEntity<>(Result.ok(sysMenuService.deleteMenu(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改菜单")
    public ResponseEntity<Result<SysMenuResponse>> updateMenu(@CurrentUser User user, @RequestBody SysMenu sysMenu) {
        return new ResponseEntity<>(Result.ok(sysMenuService.updateMenu(sysMenu)), HttpStatus.OK);
    }



}
