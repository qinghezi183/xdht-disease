package com.xdht.disease.sys.service;
import com.xdht.disease.sys.model.SysUserRole;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.SysUserRoleRequest;
import com.xdht.disease.sys.vo.response.SysUserRoleResponse;

import java.util.List;


/**
 * Created by lzf on 2018/05/31.
 */
public interface SysUserRoleService extends Service<SysUserRole> {
    /**
     * 查询用户角色列表
     * @param sysUserRoleRequest 查询条件
     * @return 返回结果
     */
    public List<SysUserRole> querySysUserRoleList(SysUserRoleRequest sysUserRoleRequest);

    /**
     * 添加用户角色
     * @param sysUserRole 用户角色实体
     * @return 返回结果
     */
    public SysUserRoleResponse addUserRole(SysUserRole sysUserRole);

    /**
     * 删除用户角色
     * @param id 用户角色主键id
     * @return 返回结果
     */
    public SysUserRoleResponse  deleteUserRole(Long id);

    /**
     * 修改用户角色
     * @param sysUserRole 用户角色实体
     * @return 返回结果
     */
    public SysUserRoleResponse  updateUserRole(SysUserRole sysUserRole);
}
