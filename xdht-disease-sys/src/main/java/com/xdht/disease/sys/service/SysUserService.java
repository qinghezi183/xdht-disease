package com.xdht.disease.sys.service;
import com.xdht.disease.sys.model.SysUser;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.SysUserRequest;
import com.xdht.disease.sys.vo.response.SysUserResponse;

import java.util.List;


/**
 * Created by lzf on 2018/05/31.
 */
public interface SysUserService extends Service<SysUser> {

    /**
     * 查询用户列表
     * @param sysUserRequest 查询条件
     * @return 返回结果
     */
    public List<SysUserResponse> querySysUserList(SysUserRequest sysUserRequest);

    /**
     * 添加用户
     * @param sysUser 添加用户实体
     * @return 返回结果
     */
    public SysUserResponse  addUsers(SysUser sysUser);

    /**
     * 删除用户
     * @param id 用户表id
     * @return 返回结果
     */
    public SysUserResponse  deleteUsers(Long id);

    /**
     * 修改用户
     * @param sysUser 用户
     * @return 返回结果
     */
    public SysUserResponse  updateUsers(SysUser sysUser);
}
