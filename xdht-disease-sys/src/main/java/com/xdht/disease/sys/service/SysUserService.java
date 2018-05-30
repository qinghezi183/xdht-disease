package com.xdht.disease.sys.service;
import com.xdht.disease.sys.model.SysUser;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.SysUserRequest;
import com.xdht.disease.sys.vo.response.SysUserResponse;

import java.util.List;


/**
 * Created by lzf on 2018/05/29.
 */
public interface SysUserService extends Service<SysUser> {

    /**
     * 查询用户列表
     * @param sysUserRequest 查询条件
     * @return 返回结果
     */
    public List<SysUserResponse> querySysUserList(SysUserRequest sysUserRequest);

}
