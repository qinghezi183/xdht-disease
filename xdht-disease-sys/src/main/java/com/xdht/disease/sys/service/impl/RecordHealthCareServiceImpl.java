package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.RecordHealthCareMapper;
import com.xdht.disease.sys.model.RecordHealthCare;
import com.xdht.disease.sys.service.RecordHealthCareService;
import com.xdht.disease.sys.vo.request.RecordHealthCareRequest;
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
public class RecordHealthCareServiceImpl extends AbstractService<RecordHealthCare> implements RecordHealthCareService{

    @Autowired
    private RecordHealthCareMapper recordHealthCareMapper;

    @Override
    public List<RecordHealthCare> queryList(RecordHealthCareRequest recordHealthCareRequest) {
        Condition condition = new Condition(RecordHealthCare.class);
        condition.createCriteria() .andEqualTo("id", recordHealthCareRequest.getId())
                .andEqualTo("healthCareNo",recordHealthCareRequest.getHealthCareNo());
        if (recordHealthCareRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordHealthCareRequest.getVerificationResult()+"%");
        }
        if (recordHealthCareRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordHealthCareRequest.getStatus());
        }
        return this.recordHealthCareMapper.selectByCondition(condition);

    }

    @Override
    public PageResult<RecordHealthCare> queryListPage(RecordHealthCareRequest recordHealthCareRequest, Integer pageNum, Integer pageSize) {

        Condition condition = new Condition(RecordHealthCare.class);
        condition.createCriteria() .andEqualTo("id", recordHealthCareRequest.getId())
                .andEqualTo("healthCareNo",recordHealthCareRequest.getHealthCareNo());
        if (recordHealthCareRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordHealthCareRequest.getVerificationResult()+"%");
        }
        if (recordHealthCareRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordHealthCareRequest.getStatus());
        }
        PageHelper.startPage(pageNum, pageSize);
        List<RecordHealthCare> dataList = this.recordHealthCareMapper.selectByCondition(condition);
        PageResult<RecordHealthCare> pageList = new  PageResult<RecordHealthCare>();
        pageList.setTotal(dataList.size());
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public RecordHealthCare add(RecordHealthCare recordHealthCare) {
            this.recordHealthCareMapper.insertUseGeneratedKeys(recordHealthCare);
            return recordHealthCare;
    }

    @Override
    public RecordHealthCare delete(Long id) {
            this.recordHealthCareMapper.deleteByPrimaryKey(id);
            RecordHealthCare recordHealthCare = new RecordHealthCare();
            recordHealthCare.setId(id);
            return recordHealthCare;
    }

    @Override
    public RecordHealthCare update(RecordHealthCare recordHealthCare) {
        this.recordHealthCareMapper.updateByPrimaryKeySelective(recordHealthCare);
        return recordHealthCare;
    }
}
