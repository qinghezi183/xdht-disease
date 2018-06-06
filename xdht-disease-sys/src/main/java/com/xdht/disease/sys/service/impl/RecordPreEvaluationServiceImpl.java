package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.RecordPreEvaluationMapper;
import com.xdht.disease.sys.model.RecordPreEvaluation;
import com.xdht.disease.sys.service.RecordPreEvaluationService;
import com.xdht.disease.sys.vo.request.RecordPreEvaluationRequest;
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
public class RecordPreEvaluationServiceImpl extends AbstractService<RecordPreEvaluation> implements RecordPreEvaluationService{

    @Autowired
    private RecordPreEvaluationMapper recordPreEvaluationMapper;

    @Override
    public List<RecordPreEvaluation> queryList(RecordPreEvaluationRequest recordPreEvaluationRequest) {
        Condition condition = new Condition(RecordPreEvaluation.class);
        condition.createCriteria() .andEqualTo("id", recordPreEvaluationRequest.getId())
                .andEqualTo("preEvaluationNo",recordPreEvaluationRequest.getPreEvaluationNo());
        if (recordPreEvaluationRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordPreEvaluationRequest.getVerificationResult()+"%");
        }
        if (recordPreEvaluationRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordPreEvaluationRequest.getStatus());
        }
        return this.recordPreEvaluationMapper.selectByCondition(condition);
    }

    @Override
    public PageResult<RecordPreEvaluation> queryListPage(RecordPreEvaluationRequest recordPreEvaluationRequest, Integer pageNum, Integer pageSize) {
        Condition condition = new Condition(RecordPreEvaluation.class);
        condition.createCriteria() .andEqualTo("id", recordPreEvaluationRequest.getId())
                .andEqualTo("preEvaluationNo",recordPreEvaluationRequest.getPreEvaluationNo());
        if (recordPreEvaluationRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordPreEvaluationRequest.getVerificationResult()+"%");
        }
        if (recordPreEvaluationRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordPreEvaluationRequest.getStatus());
        }
        condition.setOrderByClause("id desc");
        PageHelper.startPage(pageNum, pageSize);
        List<RecordPreEvaluation> dataList = this.recordPreEvaluationMapper.selectByCondition(condition);
        PageResult<RecordPreEvaluation> pageList = new  PageResult<RecordPreEvaluation>();
        pageList.setTotal(dataList.size());
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public RecordPreEvaluation addRecordPreEvaluation(RecordPreEvaluation recordPreEvaluation) {
        this.recordPreEvaluationMapper.insertUseGeneratedKeys(recordPreEvaluation);
        return recordPreEvaluation;
    }

    @Override
    public RecordPreEvaluation deleteRecordPreEvaluation(Long id) {
        this.recordPreEvaluationMapper.deleteByPrimaryKey(id);
        RecordPreEvaluation recordPreEvaluation = new RecordPreEvaluation();
        recordPreEvaluation.setId(id);
        return recordPreEvaluation;
    }

    @Override
    public RecordPreEvaluation updateRecordPreEvaluation(RecordPreEvaluation recordPreEvaluation) {
        this.recordPreEvaluationMapper.updateByPrimaryKeySelective(recordPreEvaluation);
        return recordPreEvaluation;
    }
}
