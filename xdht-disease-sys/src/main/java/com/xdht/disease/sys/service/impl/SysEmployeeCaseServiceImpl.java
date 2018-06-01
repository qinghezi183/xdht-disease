package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.sys.dao.SysEmployeeCaseMapper;
import com.xdht.disease.sys.model.SysEmployeeCase;
import com.xdht.disease.sys.service.SysEmployeeCaseService;
import com.xdht.disease.sys.vo.request.SysEmployeeCaseRequest;
import com.xdht.disease.sys.vo.response.SysEmployeeCaseResponse;
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
public class SysEmployeeCaseServiceImpl extends AbstractService<SysEmployeeCase> implements SysEmployeeCaseService{

    @Autowired
    private SysEmployeeCaseMapper sysEmployeeCaseMapper;

        @Override
        public List<SysEmployeeCase> querySysEmpCaseListPage(SysEmployeeCaseRequest sysEmployeeCaseRequest) {
            Condition condition = new Condition(SysEmployeeCase.class);
            condition.createCriteria()
                    .andEqualTo("employeeId", sysEmployeeCaseRequest.getEmployeeId());
            if (sysEmployeeCaseRequest.getCaseName() != null) {
                condition.getOredCriteria().get(0).andLike("caseName","%"+sysEmployeeCaseRequest.getCaseName()+"%");
            }
            condition.setOrderByClause("id desc");
            PageHelper.startPage(sysEmployeeCaseRequest.getPageNum(), sysEmployeeCaseRequest.getPageSize());
            List<SysEmployeeCase> sysEmployeeCaseList = this.sysEmployeeCaseMapper.selectByCondition(condition);
            return sysEmployeeCaseList;
        }

        @Override
        public SysEmployeeCaseResponse addEmployeeCase(SysEmployeeCase sysEmployeeCase) {
            this.sysEmployeeCaseMapper.insertUseGeneratedKeys(sysEmployeeCase);
            SysEmployeeCaseResponse sysEmployeeCaseResponse = new SysEmployeeCaseResponse();
            sysEmployeeCaseResponse.setId(sysEmployeeCase.getId());
            sysEmployeeCaseResponse.setCaseName(sysEmployeeCase.getCaseName());
            return sysEmployeeCaseResponse;
        }

        @Override
        public SysEmployeeCaseResponse deleteEmployeeCase(Long id) {
            this.sysEmployeeCaseMapper.deleteByPrimaryKey(id);
            SysEmployeeCaseResponse sysEmployeeCaseResponse = new SysEmployeeCaseResponse();
            sysEmployeeCaseResponse.setId(id);
            return sysEmployeeCaseResponse;
        }

        @Override
        public SysEmployeeCaseResponse updateEmployeeCase(SysEmployeeCase sysEmployeeCase) {
            this.sysEmployeeCaseMapper.updateByPrimaryKeySelective(sysEmployeeCase);
            SysEmployeeCaseResponse sysEmployeeCaseResponse = new SysEmployeeCaseResponse();
            sysEmployeeCaseResponse.setId(sysEmployeeCase.getId());
            sysEmployeeCaseResponse.setCaseName(sysEmployeeCase.getCaseName());
            return sysEmployeeCaseResponse;
        }

}

