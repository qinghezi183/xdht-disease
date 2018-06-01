package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.sys.dao.SysUserMapper;
import com.xdht.disease.sys.model.SysUser;
import com.xdht.disease.sys.service.SysUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.sys.vo.request.SysUserRequest;
import com.xdht.disease.sys.vo.response.SysUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Condition;
import java.util.List;


/**
 * Created by lzf on 2018/05/31.
 */
@Service
@Transactional
public class SysUserServiceImpl extends AbstractService<SysUser> implements SysUserService{

        @Autowired
        private SysUserMapper sysUserMapper;

        @Override
        public List<SysUser> querySysUserList(SysUserRequest sysUserRequest) {
            Condition condition = new Condition(SysUser.class);
            if (sysUserRequest.getUserName() != null){
            condition.createCriteria().andLike("userName", "%"+sysUserRequest.getUserName()+"%");
            }
            condition.setOrderByClause("id desc");
            PageHelper.startPage(sysUserRequest.getPageNum(), sysUserRequest.getPageSize());
            List<SysUser> sysUserList = this.sysUserMapper.selectByCondition(condition);
            return sysUserList;
        }

        @Override
        public SysUserResponse addUser(SysUser sysUser) {
        this.sysUserMapper.insertUseGeneratedKeys(sysUser);
        SysUserResponse sysUserResponse = new SysUserResponse();
        sysUserResponse.setId(sysUser.getId());
        sysUserResponse.setUserName(sysUser.getUserName());
        return sysUserResponse;
        }

    @Override
    public SysUserResponse deleteUser(Long id) {
        this.sysUserMapper.deleteByPrimaryKey(id);
        SysUserResponse sysUserResponse = new SysUserResponse();
        sysUserResponse.setId(id);
        return sysUserResponse;
    }

    @Override
    public SysUserResponse updateUser(SysUser sysUser) {

        this.sysUserMapper.updateByPrimaryKeySelective(sysUser);
        SysUserResponse sysUserResponse = new SysUserResponse();
        sysUserResponse.setId(sysUser.getId());
        sysUserResponse.setUserName(sysUser.getUserName());
        return sysUserResponse;
    }


}
