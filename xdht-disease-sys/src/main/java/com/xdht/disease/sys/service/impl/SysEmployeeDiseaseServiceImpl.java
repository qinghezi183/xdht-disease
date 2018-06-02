package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.sys.dao.SysEmployeeDiseaseMapper;
import com.xdht.disease.sys.model.SysEmployeeCase;
import com.xdht.disease.sys.model.SysEmployeeDisease;
import com.xdht.disease.sys.service.SysEmployeeDiseaseService;
import com.xdht.disease.sys.vo.request.SysEmployeeDiseaseRequest;
import com.xdht.disease.sys.vo.response.SysEmployeeDiseaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by lzf on 2018/06/01.
 */
@Service
@Transactional
public class SysEmployeeDiseaseServiceImpl extends AbstractService<SysEmployeeDisease> implements SysEmployeeDiseaseService{

    @Autowired
    private SysEmployeeDiseaseMapper sysEmployeeDiseaseMapper;

        @Override
        public List<SysEmployeeDisease> querySysEmpDiseaseListPage(SysEmployeeDiseaseRequest sysEmployeeDiseaseRequest) {
            Condition condition = new Condition(SysEmployeeCase.class);
            condition.createCriteria()
                    .andEqualTo("employeeId", sysEmployeeDiseaseRequest.getEmployeeId());
            if (sysEmployeeDiseaseRequest.getDiseaseName() != null) {
                condition.getOredCriteria().get(0).andLike("caseName","%"+sysEmployeeDiseaseRequest.getDiseaseName()+"%");
            }
            condition.setOrderByClause("id desc");
            PageHelper.startPage(sysEmployeeDiseaseRequest.getPageNum(), sysEmployeeDiseaseRequest.getPageSize());
            List<SysEmployeeDisease> sysEmployeeDiseaseList = this.sysEmployeeDiseaseMapper.selectByCondition(condition);
            return sysEmployeeDiseaseList;
        }

        @Override
        public SysEmployeeDiseaseResponse addEmployeeDisease(SysEmployeeDisease sysEmployeeDisease) {
            this.sysEmployeeDiseaseMapper.insertUseGeneratedKeys(sysEmployeeDisease);
            SysEmployeeDiseaseResponse sysEmployeeDiseaseResponse = new SysEmployeeDiseaseResponse();
            sysEmployeeDiseaseResponse.setId(sysEmployeeDisease.getId());
            sysEmployeeDiseaseResponse.setDiseaseName(sysEmployeeDisease.getDiseaseName());
            return sysEmployeeDiseaseResponse;
        }

        @Override
        public SysEmployeeDiseaseResponse deleteEmployeeDisease(Long id) {
            this.sysEmployeeDiseaseMapper.deleteByPrimaryKey(id);
            SysEmployeeDiseaseResponse sysEmployeeDiseaseResponse = new SysEmployeeDiseaseResponse();
            sysEmployeeDiseaseResponse.setId(id);
            return sysEmployeeDiseaseResponse;
        }

        @Override
        public SysEmployeeDiseaseResponse updateEmployeeDisease(SysEmployeeDisease sysEmployeeDisease) {
            this.sysEmployeeDiseaseMapper.updateByPrimaryKeySelective(sysEmployeeDisease);
            SysEmployeeDiseaseResponse sysEmployeeDiseaseResponse = new SysEmployeeDiseaseResponse();
            sysEmployeeDiseaseResponse.setId(sysEmployeeDisease.getId());
            sysEmployeeDiseaseResponse.setDiseaseName(sysEmployeeDisease.getDiseaseName());
            return sysEmployeeDiseaseResponse;
        }

}
