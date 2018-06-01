package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.sys.dao.SysEmployeeMapper;
import com.xdht.disease.sys.model.SysEmployee;
import com.xdht.disease.sys.service.SysEmployeeService;
import com.xdht.disease.sys.vo.request.SysEmployeeRequest;
import com.xdht.disease.sys.vo.response.SysEmployeeResponse;
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
public class SysEmployeeServiceImpl extends AbstractService<SysEmployee> implements SysEmployeeService{

    @Autowired
    private SysEmployeeMapper sysEmployeeMapper;

        @Override
        public List<SysEmployee> querySysEmpListPage(SysEmployeeRequest sysEmployeeRequest) {
            Condition condition = new Condition(SysEmployee.class);
            condition.createCriteria()
                    .andEqualTo("officeId", sysEmployeeRequest.getOfficeId())
                    .andEqualTo("empSex",sysEmployeeRequest.getEmpSex())
                    .andEqualTo("empMarriage",sysEmployeeRequest.getEmpMarriage())
                    .andEqualTo("empEducation",sysEmployeeRequest.getEmpEducation());
//                    .andLike("empNative",sysEmployeeRequest.getEmpNative())
//                    .andLike("empHobby","%"+sysEmployeeRequest.getEmpHobby()+"%");
            if (sysEmployeeRequest.getEmpName() != null) {
                condition.getOredCriteria().get(0).andLike("empName","%"+sysEmployeeRequest.getEmpName()+"%");
            }
            if(sysEmployeeRequest.getEmpNative() != null){
                condition.getOredCriteria().get(0).andLike("empNative",sysEmployeeRequest.getEmpNative());
            }
            condition.setOrderByClause("id desc");
            PageHelper.startPage(sysEmployeeRequest.getPageNum(), sysEmployeeRequest.getPageSize());
            List<SysEmployee> sysEmployeeList = this.sysEmployeeMapper.selectByCondition(condition);
            return sysEmployeeList;
        }

    @Override
    public SysEmployeeResponse addEmployee(SysEmployee sysEmployee) {
        this.sysEmployeeMapper.insertUseGeneratedKeys(sysEmployee);
        SysEmployeeResponse sysEmployeeResponse = new SysEmployeeResponse();
        sysEmployeeResponse.setId(sysEmployee.getId());
        sysEmployeeResponse.setEmpName(sysEmployee.getEmpName());
        return sysEmployeeResponse;
    }

    @Override
    public SysEmployeeResponse deleteEmployee(Long id) {
        this.sysEmployeeMapper.deleteByPrimaryKey(id);
        SysEmployeeResponse sysEmployeeResponse = new SysEmployeeResponse();
        sysEmployeeResponse.setId(id);
        return sysEmployeeResponse;
    }

    @Override
    public SysEmployeeResponse updateEmployee(SysEmployee sysEmployee) {
        this.sysEmployeeMapper.updateByPrimaryKeySelective(sysEmployee);
        SysEmployeeResponse sysEmployeeResponse = new SysEmployeeResponse();
        sysEmployeeResponse.setId(sysEmployee.getId());
        sysEmployeeResponse.setEmpName(sysEmployee.getEmpName());
        return sysEmployeeResponse;
    }

}
