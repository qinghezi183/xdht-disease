package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.sys.dao.SysUserRoleMapper;
import com.xdht.disease.sys.model.SysUserRole;
import com.xdht.disease.sys.service.SysUserRoleService;
import com.xdht.disease.sys.vo.request.SysUserRoleRequest;
import com.xdht.disease.sys.vo.response.SysUserRoleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;


/**
 * Created by lzf on 2018/05/31.
 */
@Service
@Transactional
public class SysUserRoleServiceImpl extends AbstractService<SysUserRole> implements SysUserRoleService{

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

        @Override
        public List<SysUserRole> querySysUserRoleList(SysUserRoleRequest sysUserRoleRequest) {

                Condition condition = new Condition(SysUserRole.class);
                condition.createCriteria().andEqualTo("roleId", sysUserRoleRequest.getRoleId())
                    .andEqualTo("userId", sysUserRoleRequest.getUserId());
                condition.setOrderByClause("id desc");
                PageHelper.startPage(sysUserRoleRequest.getPageNum(), sysUserRoleRequest.getPageSize());
                List<SysUserRole> sysUserRoleList = this.sysUserRoleMapper.selectByCondition(condition);
                return sysUserRoleList;

        }

        @Override
        public SysUserRoleResponse addUserRole(SysUserRole sysUserRole) {
            this.sysUserRoleMapper.insertSelective(sysUserRole);
            SysUserRoleResponse sysUserRoleResponse = new SysUserRoleResponse();
            sysUserRoleResponse.setId(sysUserRole.getId());
            sysUserRoleResponse.setRoleId(sysUserRole.getRoleId());
            return sysUserRoleResponse;
        }

        @Override
        public SysUserRoleResponse deleteUserRole(Long id) {
            this.sysUserRoleMapper.deleteByPrimaryKey(id);
            SysUserRoleResponse sysUserRoleResponse = new SysUserRoleResponse();
            sysUserRoleResponse.setId(id);
            return sysUserRoleResponse;
        }

        @Override
        public SysUserRoleResponse updateUserRole(SysUserRole sysUserRole) {
            this.sysUserRoleMapper.updateByPrimaryKeySelective(sysUserRole);
            SysUserRoleResponse sysUserRoleResponse = new SysUserRoleResponse();
            sysUserRoleResponse.setId(sysUserRole.getId());
            sysUserRoleResponse.setRoleId(sysUserRole.getRoleId());
            return sysUserRoleResponse;
        }

}
