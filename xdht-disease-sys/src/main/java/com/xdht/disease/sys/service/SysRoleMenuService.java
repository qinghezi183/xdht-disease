package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.SysRoleMenu;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.SysRoleMenuRequest;
import com.xdht.disease.sys.vo.response.SysRoleMenuResponse;

import java.util.List;


/**
 * Created by lzf on 2018/05/31.
 */
public interface SysRoleMenuService extends Service<SysRoleMenu> {

    /**
     * 分页查询角色菜单
     * @param sysRoleMenuRequest 查询条件
     * @return 返回结果
     */
    public PageResult<SysRoleMenu> querySysRoleMenuPage(SysRoleMenuRequest sysRoleMenuRequest);

    /**
     * 查询角色菜单列表
     * @param sysRoleMenu 查询条件
     * @return 返回结果
     */
    public List<SysRoleMenu> querySysRoleMenuList(SysRoleMenu sysRoleMenu);

    /**
     * 添加角色菜单
     * @param sysRoleMenu 角色菜单实体
     * @return 返回结果
     */
    public SysRoleMenuResponse addRoleMenu(SysRoleMenu sysRoleMenu);

    /**
     * 删除角色菜单
     * @param id 角色菜单id
     * @return 返回结果
     */
    public SysRoleMenuResponse  deleteRoleMenu(Long id);

    /**
     * 修改角色菜单
     * @param sysRoleMenu 角色菜单实体
     * @return 返回结果
     */
    public SysRoleMenuResponse updateRoleMenu(SysRoleMenu sysRoleMenu);


}
