package com.xdht.disease.sys.service.impl;

import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.sys.dao.SysRoleMenuMapper;
import com.xdht.disease.sys.model.SysMenu;
import com.xdht.disease.sys.model.SysRoleMenu;
import com.xdht.disease.sys.service.SysRoleMenuService;
import com.xdht.disease.sys.vo.request.SysRoleMenuRequest;
import com.xdht.disease.sys.vo.response.SysMenuResponse;
import com.xdht.disease.sys.vo.response.SysRoleMenuResponse;
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
public class SysRoleMenuServiceImpl extends AbstractService<SysRoleMenu> implements SysRoleMenuService{

    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;

        @Override
        public List<SysRoleMenu> querySysRoleMenuList(SysRoleMenuRequest sysRoleMenuRequest) {
            Condition condition = new Condition(SysRoleMenu.class);
            condition.createCriteria().andEqualTo("roleId", sysRoleMenuRequest.getRoleId())
                    .andEqualTo("menuId", sysRoleMenuRequest.getMenuId());
            List<SysRoleMenu> sysRoleMenuList = this.sysRoleMenuMapper.selectByCondition(condition);
            return sysRoleMenuList;
        }

        @Override
        public SysRoleMenuResponse addRoleMenu(SysRoleMenu sysRoleMenu) {
            this.sysRoleMenuMapper.insertUseGeneratedKeys(sysRoleMenu);
            SysRoleMenuResponse sysRoleMenuResponse = new SysRoleMenuResponse();
            sysRoleMenuResponse.setId(sysRoleMenu.getId());
            sysRoleMenuResponse.setRoleId(sysRoleMenu.getRoleId());
            return sysRoleMenuResponse;
        }

        @Override
        public SysRoleMenuResponse deleteRoleMenu(Long id) {
            this.sysRoleMenuMapper.deleteByPrimaryKey(id);
            SysRoleMenuResponse sysRoleMenuResponse = new SysRoleMenuResponse();
            sysRoleMenuResponse.setId(id);
            return sysRoleMenuResponse;
        }

        @Override
        public SysRoleMenuResponse updateRoleMenu(SysRoleMenu sysRoleMenu) {
            this.sysRoleMenuMapper.updateByPrimaryKeySelective(sysRoleMenu);
            SysRoleMenuResponse sysRoleMenuResponse = new SysRoleMenuResponse();
            sysRoleMenuResponse.setId(sysRoleMenu.getId());
            sysRoleMenuResponse.setRoleId(sysRoleMenu.getRoleId());
            sysRoleMenuResponse.setMenuId(sysRoleMenu.getMenuId());
            return sysRoleMenuResponse;
        }

}
