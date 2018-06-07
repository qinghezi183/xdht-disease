package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.SysMenuMapper;
import com.xdht.disease.sys.model.SysMenu;
import com.xdht.disease.sys.service.SysMenuService;
import com.xdht.disease.sys.vo.request.SysMenuRequest;
import com.xdht.disease.sys.vo.response.SysMenuResponse;
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
public class SysMenuServiceImpl extends AbstractService<SysMenu> implements SysMenuService{

    @Autowired
    private SysMenuMapper sysMenuMapper;

        @Override
        public PageResult<SysMenu> querySysMenuPage(SysMenuRequest sysMenuRequest) {
            Condition condition = new Condition(SysMenu.class);
            if (sysMenuRequest.getMenuName() != null) {
                condition.createCriteria().andLike("menuName","%"+sysMenuRequest.getMenuName()+"%");
            }
            PageHelper.startPage(sysMenuRequest.getPageNum(), sysMenuRequest.getPageSize());
            List<SysMenu> dataList = this.sysMenuMapper.selectByCondition(condition);
            PageResult<SysMenu> pageList = new PageResult<SysMenu>();
            pageList.setDataList(dataList);
            pageList.setTotal(dataList.size());
            return pageList;
        }
        @Override
        public List<SysMenu> querySysMenuList(SysMenu sysMenu) {
            Condition condition = new Condition(SysMenu.class);

            if (sysMenu.getMenuName() != null) {
                condition.createCriteria().andLike("menuName","%"+sysMenu.getMenuName()+"%");
            }
            condition.setOrderByClause("id desc");
            List<SysMenu> sysMenuList = this.sysMenuMapper.selectByCondition(condition);
            return sysMenuList;
        }

        @Override
        public SysMenuResponse addMenu(SysMenu sysMenu) {
            this.sysMenuMapper.insertUseGeneratedKeys(sysMenu);
            SysMenuResponse sysMenuResponse = new SysMenuResponse();
            sysMenuResponse.setId(sysMenu.getId());
            sysMenuResponse.setMenuName(sysMenu.getMenuName());
            return sysMenuResponse;
        }

        @Override
        public SysMenuResponse deleteMenu(Long id) {
            this.sysMenuMapper.deleteByPrimaryKey(id);
            SysMenuResponse sysMenuResponse = new SysMenuResponse();
            sysMenuResponse.setId(id);
            return sysMenuResponse;
        }

        @Override
        public SysMenuResponse updateMenu(SysMenu sysMenu) {
            this.sysMenuMapper.updateByPrimaryKeySelective(sysMenu);
            SysMenuResponse sysMenuResponse = new SysMenuResponse();
            sysMenuResponse.setId(sysMenu.getId());
            sysMenuResponse.setMenuName(sysMenu.getMenuName());
            return sysMenuResponse;
        }

}
