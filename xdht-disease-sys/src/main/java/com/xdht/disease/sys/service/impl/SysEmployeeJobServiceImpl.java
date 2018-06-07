package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.SysEmployeeJobMapper;
import com.xdht.disease.sys.model.SysEmployeeJob;
import com.xdht.disease.sys.service.SysEmployeeJobService;
import com.xdht.disease.sys.vo.request.SysEmployeeJobRequest;
import com.xdht.disease.sys.vo.response.SysEmployeeJobResponse;
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
public class SysEmployeeJobServiceImpl extends AbstractService<SysEmployeeJob> implements SysEmployeeJobService{

    @Autowired
    private SysEmployeeJobMapper sysEmployeeJobMapper;

        @Override
        public PageResult<SysEmployeeJob> querySysEmpJobPage(SysEmployeeJobRequest sysEmployeeIobRequest) {
            Condition condition = new Condition(SysEmployeeJob.class);
            condition.createCriteria()
                    .andEqualTo("employeeId", sysEmployeeIobRequest.getEmployeeId());
            if (sysEmployeeIobRequest.getCompanyName() != null) {
                condition.getOredCriteria().get(0).andLike("companyName","%"+sysEmployeeIobRequest.getCompanyName()+"%");
            }
            PageHelper.startPage(sysEmployeeIobRequest.getPageNum(), sysEmployeeIobRequest.getPageSize());
            List<SysEmployeeJob> dataList = this.sysEmployeeJobMapper.selectByCondition(condition);
            PageResult<SysEmployeeJob> pageList = new PageResult<SysEmployeeJob>();
            pageList.setTotal(dataList.size());
            pageList.setDataList(dataList);
            return pageList;
        }

        @Override
        public List<SysEmployeeJob> querySysEmpJobList(SysEmployeeJob sysEmployeeIob) {
            Condition condition = new Condition(SysEmployeeJob.class);
            condition.createCriteria()
                    .andEqualTo("employeeId", sysEmployeeIob.getEmployeeId());
            if (sysEmployeeIob.getCompanyName() != null) {
                condition.getOredCriteria().get(0).andLike("companyName","%"+sysEmployeeIob.getCompanyName()+"%");
            }
            condition.setOrderByClause("id desc");
            List<SysEmployeeJob> sysEmployeeJobList = this.sysEmployeeJobMapper.selectByCondition(condition);
            return sysEmployeeJobList;
        }

        @Override
        public SysEmployeeJobResponse addEmployeeJob(SysEmployeeJob sysEmployeeJob) {
            this.sysEmployeeJobMapper.insertUseGeneratedKeys(sysEmployeeJob);
            SysEmployeeJobResponse sysEmployeeJobResponse = new SysEmployeeJobResponse();
            sysEmployeeJobResponse.setId(sysEmployeeJob.getId());
            sysEmployeeJobResponse.setCompanyName(sysEmployeeJob.getCompanyName());
            return sysEmployeeJobResponse;
        }

        @Override
        public SysEmployeeJobResponse deleteEmployeeJob(Long id) {
            this.sysEmployeeJobMapper.deleteByPrimaryKey(id);
            SysEmployeeJobResponse sysEmployeeJobResponse = new SysEmployeeJobResponse();
            sysEmployeeJobResponse.setId(id);
            return sysEmployeeJobResponse;
        }

        @Override
        public SysEmployeeJobResponse updateEmployeeJob(SysEmployeeJob sysEmployeeJob) {
            this.sysEmployeeJobMapper.updateByPrimaryKeySelective(sysEmployeeJob);
            SysEmployeeJobResponse sysEmployeeJobResponse = new SysEmployeeJobResponse();
            sysEmployeeJobResponse.setId(sysEmployeeJob.getId());
            sysEmployeeJobResponse.setCompanyName(sysEmployeeJob.getCompanyName());
            return sysEmployeeJobResponse;
        }



}
