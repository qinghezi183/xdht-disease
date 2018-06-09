package com.xdht.disease.sys.controller;

import com.xdht.disease.common.authorization.annotation.CurrentUser;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Result;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.model.SysRoleMenu;
import com.xdht.disease.sys.service.SysRoleMenuService;
import com.xdht.disease.sys.vo.request.SysRoleMenuRequest;
import com.xdht.disease.sys.vo.response.SysRoleMenuResponse;
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
@RequestMapping(value = "/api/v1/sysRoleMenu")
public class SysRoleMenuController {

    @Autowired
    private SysRoleMenuService sysRoleMenuService;

    @RequestMapping(value = "/roleMenuPage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询角色菜单列表")
    public ResponseEntity<Result<PageResult<SysRoleMenu>>> roleMenuPage(@CurrentUser User user, @RequestBody SysRoleMenuRequest sysRoleMenuRequest) {
        return new ResponseEntity<>(Result.ok(sysRoleMenuService.querySysRoleMenuPage(sysRoleMenuRequest)), HttpStatus.OK);
    }
    @RequestMapping(value = "/roleMenuList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询角色菜单列表")
    public ResponseEntity<Result<List<SysRoleMenu>>> roleMenuList(@CurrentUser User user, @RequestBody SysRoleMenu sysRoleMenu) {
        return new ResponseEntity<>(Result.ok(sysRoleMenuService.querySysRoleMenuList(sysRoleMenu)), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加角色菜单")
    public ResponseEntity<Result<SysRoleMenuResponse>> addRoleMenu(@CurrentUser User user, @RequestBody SysRoleMenu sysRoleMenu) {
        return new ResponseEntity<>(Result.ok(sysRoleMenuService.addRoleMenu(sysRoleMenu)), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除角色菜单")
    public ResponseEntity<Result<SysRoleMenuResponse>> deleteRoleMenu(@CurrentUser User user, @RequestParam Long id) {
        return new ResponseEntity<>(Result.ok(sysRoleMenuService.deleteRoleMenu(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改角色菜单")
    public ResponseEntity<Result<SysRoleMenuResponse>> updateRoleMenu(@CurrentUser User user, @RequestBody SysRoleMenu sysRoleMenu) {
        return new ResponseEntity<>(Result.ok(sysRoleMenuService.updateRoleMenu(sysRoleMenu)), HttpStatus.OK);
    }



}
