package com.xdht.disease.sys.service;
import com.xdht.disease.sys.model.SysUser;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.LoginRequest;
import com.xdht.disease.sys.vo.request.SysUserRequest;
import com.xdht.disease.sys.vo.response.LoginResponse;
import com.xdht.disease.sys.vo.response.SysUserResponse;

import java.util.List;


/**
 * Created by lzf on 2018/05/29.
 */
public interface SysUserService extends Service<SysUser> {

    /**
     * 创建Token
     * @param loginRequest 请求参数
     * @return 返回结果
     */
    LoginResponse createToken(LoginRequest loginRequest);

    /**
     * 查询用户列表
     * @param sysUserRequest 查询条件
     * @return 返回结果
     */
    public List<SysUserResponse> querySysUserList(SysUserRequest sysUserRequest);

}
