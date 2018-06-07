package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.RecordHealthManagementMapper;
import com.xdht.disease.sys.model.RecordHealthManagement;
import com.xdht.disease.sys.service.RecordHealthManagementService;
import com.xdht.disease.sys.vo.request.RecordHealthManagementRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;


/**
 * Created by lzf on 2018/06/05.
 */
@Service
@Transactional
public class RecordHealthManagementServiceImpl extends AbstractService<RecordHealthManagement> implements RecordHealthManagementService{

    @Autowired
    private RecordHealthManagementMapper recordHealthManagementMapper;

    @Override
    public List<RecordHealthManagement> queryList(RecordHealthManagementRequest recordHealthManagementRequest) {

        Condition condition = new Condition(RecordHealthManagement.class);
        condition.createCriteria() .andEqualTo("id", recordHealthManagementRequest.getId())
                .andEqualTo("healthManagementNo",recordHealthManagementRequest.getHealthManagementNo());
        if (recordHealthManagementRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordHealthManagementRequest.getVerificationResult()+"%");
        }
        if (recordHealthManagementRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordHealthManagementRequest.getStatus());
        }
        return this.recordHealthManagementMapper.selectByCondition(condition);
    }

    @Override
    public PageResult<RecordHealthManagement> queryListPage(RecordHealthManagementRequest recordHealthManagementRequest, Integer pageNum, Integer pageSize) {
        Condition condition = new Condition(RecordHealthManagement.class);
        condition.createCriteria() .andEqualTo("id", recordHealthManagementRequest.getId())
                .andEqualTo("healthManagementNo",recordHealthManagementRequest.getHealthManagementNo());
        if (recordHealthManagementRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordHealthManagementRequest.getVerificationResult()+"%");
        }
        if (recordHealthManagementRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordHealthManagementRequest.getStatus());
        }
        PageHelper.startPage(pageNum, pageSize);
        List<RecordHealthManagement> dataList = this.recordHealthManagementMapper.selectByCondition(condition);
        PageResult<RecordHealthManagement> pageList = new  PageResult<RecordHealthManagement>();
        pageList.setTotal(dataList.size());
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public RecordHealthManagement add(RecordHealthManagement recordHealthManagement) {
            this.recordHealthManagementMapper.insertUseGeneratedKeys(recordHealthManagement);
            return recordHealthManagement;
    }

    @Override
    public RecordHealthManagement delete(Long id) {
            this.recordHealthManagementMapper.deleteByPrimaryKey(id);
            RecordHealthManagement recordHealthManagement = new RecordHealthManagement();
            recordHealthManagement.setId(id);
            return  recordHealthManagement;
    }

    @Override
    public RecordHealthManagement update(RecordHealthManagement recordHealthManagement) {
        this.recordHealthManagementMapper.updateByPrimaryKeySelective(recordHealthManagement);
        return recordHealthManagement;
    }
}
