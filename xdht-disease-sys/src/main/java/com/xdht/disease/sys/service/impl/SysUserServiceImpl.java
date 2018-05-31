package com.xdht.disease.sys.service.impl;

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
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Resource;


/**
 * Created by lzf on 2018/05/31.
 */
@Service
@Transactional
public class SysUserServiceImpl extends AbstractService<SysUser> implements SysUserService{

        @Autowired
        private SysUserMapper sysUserMapper;

        @Override
        public List<SysUserResponse> querySysUserList(SysUserRequest sysUserRequest) {
            List<SysUserResponse> sysUserResponseList = new LinkedList<>();
            Condition condition = new Condition(SysUser.class);
            condition.createCriteria().andLike("userName", "%"+sysUserRequest.getUserName()+"%");
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

        @Override
        public SysUserResponse addUsers(SysUser sysUser) {
        this.sysUserMapper.insertUseGeneratedKeys(sysUser);
        SysUserResponse sysUserResponse = new SysUserResponse();
        sysUserResponse.setId(sysUser.getId());
        sysUserResponse.setUserName(sysUser.getUserName());
        return sysUserResponse;
        }

    @Override
    public SysUserResponse deleteUsers(Long id) {
        this.sysUserMapper.deleteByPrimaryKey(id);
        SysUserResponse sysUserResponse = new SysUserResponse();
        sysUserResponse.setId(id);
        return sysUserResponse;
    }

    @Override
    public SysUserResponse updateUsers(SysUser sysUser) {

        this.sysUserMapper.updateByPrimaryKeySelective(sysUser);
        SysUserResponse sysUserResponse = new SysUserResponse();
        sysUserResponse.setId(sysUser.getId());
        sysUserResponse.setUserName(sysUser.getUserName());
        return sysUserResponse;
    }


}
