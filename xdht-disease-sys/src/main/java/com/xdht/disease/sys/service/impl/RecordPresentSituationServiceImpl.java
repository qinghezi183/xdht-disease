package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.RecordPresentSituationMapper;
import com.xdht.disease.sys.model.RecordPresentSituation;
import com.xdht.disease.sys.service.RecordPresentSituationService;
import com.xdht.disease.sys.vo.request.RecordPresentSituationRequest;
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
public class RecordPresentSituationServiceImpl extends AbstractService<RecordPresentSituation> implements RecordPresentSituationService{

    @Autowired
    private RecordPresentSituationMapper recordPresentSituationMapper;

    @Override
    public List<RecordPresentSituation> queryList(RecordPresentSituationRequest recordPresentSituationRequest) {
        Condition condition = new Condition(RecordPresentSituation.class);
        condition.createCriteria() .andEqualTo("id", recordPresentSituationRequest.getId())
                .andEqualTo("preEvaluationNo",recordPresentSituationRequest.getPreEvaluationNo());
        if (recordPresentSituationRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordPresentSituationRequest.getVerificationResult()+"%");
        }
        if (recordPresentSituationRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordPresentSituationRequest.getStatus());
        }
        return this.recordPresentSituationMapper.selectByCondition(condition);
    }

    @Override
    public PageResult<RecordPresentSituation> queryListPage(RecordPresentSituationRequest recordPresentSituationRequest, Integer pageNum, Integer pageSize) {
        Condition condition = new Condition(RecordPresentSituation.class);
        condition.createCriteria() .andEqualTo("id", recordPresentSituationRequest.getId())
                .andEqualTo("preEvaluationNo",recordPresentSituationRequest.getPreEvaluationNo());
        if (recordPresentSituationRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordPresentSituationRequest.getVerificationResult()+"%");
        }
        if (recordPresentSituationRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordPresentSituationRequest.getStatus());
        }
        condition.setOrderByClause("id desc");
        PageHelper.startPage(pageNum, pageSize);
        List<RecordPresentSituation> dataList = this.recordPresentSituationMapper.selectByCondition(condition);
        PageResult<RecordPresentSituation> pageList = new  PageResult<RecordPresentSituation>();
        pageList.setTotal(dataList.size());
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public RecordPresentSituation addRecordPresentSituation(RecordPresentSituation recordPresentSituation) {
        this.recordPresentSituationMapper.insertUseGeneratedKeys(recordPresentSituation);
        return recordPresentSituation;
    }

    @Override
    public RecordPresentSituation deleteRecordPresentSituation(Long id) {
        this.recordPresentSituationMapper.deleteByPrimaryKey(id);
        RecordPresentSituation recordPresentSituation = new RecordPresentSituation();
        recordPresentSituation.setId(id);
        return recordPresentSituation;
    }

    @Override
    public RecordPresentSituation updateRecordPresentSituation(RecordPresentSituation recordPresentSituation) {
        this.recordPresentSituationMapper.updateByPrimaryKeySelective(recordPresentSituation);
        return recordPresentSituation;
    }
}
