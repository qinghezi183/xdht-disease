package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.RecordAuxiliaryHealthMapper;
import com.xdht.disease.sys.model.RecordAuxiliaryHealth;
import com.xdht.disease.sys.service.RecordAuxiliaryHealthService;
import com.xdht.disease.sys.vo.request.RecordAuxiliaryHealthRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;


/**
 * Created by lzf on 2018/06/04.
 */
@Service
@Transactional
public class RecordAuxiliaryHealthServiceImpl extends AbstractService<RecordAuxiliaryHealth> implements RecordAuxiliaryHealthService{

    @Autowired
    private RecordAuxiliaryHealthMapper recordAuxiliaryHealthMapper;

    @Override
    public List<RecordAuxiliaryHealth> queryList(RecordAuxiliaryHealthRequest recordAuxiliaryHealthRequest) {
        Condition condition = new Condition(RecordAuxiliaryHealth.class);
        condition.createCriteria() .andEqualTo("id", recordAuxiliaryHealthRequest.getId())
                .andEqualTo("auxiliaryHealthNo",recordAuxiliaryHealthRequest.getAuxiliaryHealthNo());
        if (recordAuxiliaryHealthRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordAuxiliaryHealthRequest.getVerificationResult()+"%");
        }
        if (recordAuxiliaryHealthRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordAuxiliaryHealthRequest.getStatus());
        }
        return this.recordAuxiliaryHealthMapper.selectByCondition(condition);
    }

    @Override
    public PageResult<RecordAuxiliaryHealth> queryListPage(RecordAuxiliaryHealthRequest recordAuxiliaryHealthRequest, Integer pageNum, Integer pageSize) {
        Condition condition = new Condition(RecordAuxiliaryHealth.class);
        condition.createCriteria() .andEqualTo("id", recordAuxiliaryHealthRequest.getId())
                .andEqualTo("auxiliaryHealthNo",recordAuxiliaryHealthRequest.getAuxiliaryHealthNo());
        if (recordAuxiliaryHealthRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordAuxiliaryHealthRequest.getVerificationResult()+"%");
        }
        if (recordAuxiliaryHealthRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordAuxiliaryHealthRequest.getStatus());
        }
        PageHelper.startPage(pageNum, pageSize);
        List<RecordAuxiliaryHealth> dataList = this.recordAuxiliaryHealthMapper.selectByCondition(condition);
        PageResult<RecordAuxiliaryHealth> pageList = new  PageResult<RecordAuxiliaryHealth>();
        pageList.setTotal(dataList.size());
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public RecordAuxiliaryHealth add(RecordAuxiliaryHealth recordAuxiliaryHealth) {
            this.recordAuxiliaryHealthMapper.insertUseGeneratedKeys(recordAuxiliaryHealth);
            return recordAuxiliaryHealth;
    }

    @Override
    public RecordAuxiliaryHealth delete(Long id) {
            this.recordAuxiliaryHealthMapper.deleteByPrimaryKey(id);
            RecordAuxiliaryHealth recordAuxiliaryHealth = new RecordAuxiliaryHealth();
            recordAuxiliaryHealth.setId(id);
            return recordAuxiliaryHealth;
    }

    @Override
    public RecordAuxiliaryHealth update(RecordAuxiliaryHealth recordAuxiliaryHealth) {
            this.recordAuxiliaryHealthMapper.updateByPrimaryKeySelective(recordAuxiliaryHealth);
            return recordAuxiliaryHealth;
    }
}
