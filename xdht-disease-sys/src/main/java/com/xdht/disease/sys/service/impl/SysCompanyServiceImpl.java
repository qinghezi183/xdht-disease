package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.SysCompanyMapper;
import com.xdht.disease.sys.model.SysCompany;
import com.xdht.disease.sys.service.SysCompanyService;
import com.xdht.disease.sys.vo.request.SysCompanyRequest;
import com.xdht.disease.sys.vo.response.SysCompanyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;


/**
 * Created by lzf on 2018/06/01.
 */
@Service
@Transactional
public class SysCompanyServiceImpl extends AbstractService<SysCompany> implements SysCompanyService{

    @Autowired
    private SysCompanyMapper sysCompanyMapper;

        @Override
        public PageResult<SysCompany> querySysCompanyListPage(SysCompanyRequest sysCompanyRequest) {
            Condition condition = new Condition(SysCompany.class);
            if (sysCompanyRequest.getCompanyName() != null){
                condition.createCriteria().andLike("companyName","%"+sysCompanyRequest.getCompanyName()+"%");
            }
            condition.setOrderByClause("id desc");
//            SysCompany sysCompany = new SysCompany();
//            sysCompany.setCompanyName(sysCompanyRequest.getCompanyName());
//            Integer count = this.sysCompanyMapper.selectCount(sysCompany);
            PageHelper.startPage(sysCompanyRequest.getPageNum(), sysCompanyRequest.getPageSize());
            List<SysCompany> sysCompanyList = this.sysCompanyMapper.selectByCondition(condition);
            PageResult<SysCompany> pageList = new  PageResult<SysCompany>();
            pageList.setTotal(sysCompanyList.size());
            pageList.setDataList(sysCompanyList);
            return pageList;
        }

        @Override
        public List<SysCompany> querySysCompanyList(SysCompany sysCompany) {
            Condition condition = new Condition(SysCompany.class);
            if (sysCompany.getCompanyName() != null){
                condition.createCriteria().andLike("companyName","%"+sysCompany.getCompanyName()+"%");
            }
            List<SysCompany> sysCompanyList = this.selectByCondition(condition);
            return sysCompanyList;
        }

        @Override
        public SysCompanyResponse addCompany(SysCompany sysCompany) {
            this.sysCompanyMapper.insertUseGeneratedKeys(sysCompany);
            SysCompanyResponse sysCompanyResponse = new SysCompanyResponse();
            sysCompanyResponse.setId(sysCompany.getId());
            sysCompanyResponse.setCompanyName(sysCompany.getCompanyName());
            return sysCompanyResponse;
        }

        @Override
        public SysCompanyResponse deleteCompany(Long id) {
            this.sysCompanyMapper.deleteByPrimaryKey(id);
            SysCompanyResponse sysCompanyResponse = new SysCompanyResponse();
            sysCompanyResponse.setId(id);
            return sysCompanyResponse;
        }

        @Override
        public SysCompanyResponse updateCompany(SysCompany sysCompany) {
            this.sysCompanyMapper.updateByPrimaryKeySelective(sysCompany);
            SysCompanyResponse sysCompanyResponse = new SysCompanyResponse();
            sysCompanyResponse.setId(sysCompany.getId());
            sysCompanyResponse.setCompanyName(sysCompany.getCompanyName());
            return sysCompanyResponse;
        }



}
