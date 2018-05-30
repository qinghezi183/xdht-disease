package com.xdht.disease.sys.service.impl;

import com.xdht.disease.common.authorization.manager.TokenManager;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.model.TokenModel;
import com.xdht.disease.common.model.User;
import com.xdht.disease.sys.dao.SysUserMapper;
import com.xdht.disease.sys.model.SysUser;
import com.xdht.disease.sys.service.SysUserService;
import com.xdht.disease.sys.vo.request.LoginRequest;
import com.xdht.disease.sys.vo.request.SysUserRequest;
import com.xdht.disease.sys.vo.response.LoginResponse;
import com.xdht.disease.sys.vo.response.SysUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by lzf on 2018/05/29.
 */
@Service
@Transactional
public class SysUserServiceImpl extends AbstractService<SysUser> implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Resource(name = "ehcacheTokenManager")
    private TokenManager tokenManager;

    @Override
    public LoginResponse createToken(LoginRequest loginRequest) {
        LoginResponse response = new LoginResponse();

        SysUser sysUser = new SysUser();
        sysUser.setId(loginRequest.getUserId());

        sysUser = sysUserMapper.selectByPrimaryKey(sysUser);
        User user = new User();
        user.setId(sysUser.getId());
        user.setName(sysUser.getUserName());

        //创建token
        TokenModel tokenModel = tokenManager.createToken(user);
        response.setToken(tokenModel.getToken());
        return response;
    }

    @Override
    public List<SysUserResponse> querySysUserList(SysUserRequest sysUserRequest) {
        List<SysUserResponse> sysUserResponseList = new LinkedList<>();
        Condition condition = new Condition(SysUser.class);
        condition.createCriteria().andLike("userName", "%" + sysUserRequest.getUserName() + "%");
        List<SysUser> sysUserList = this.sysUserMapper.selectByCondition(condition);
        if (sysUserList != null && sysUserList.size() > 0) {
            for (SysUser sysUser : sysUserList
                 ) {
                SysUserResponse sysUserResponse = new SysUserResponse();
                sysUserResponse.setId(sysUser.getId());
                sysUserResponse.setUserName(sysUser.getUserName());
                sysUserResponseList.add(sysUserResponse);
            }
        }
        return sysUserResponseList;
    }

}
