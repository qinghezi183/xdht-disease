package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.RecordPreEvaluationDataMapper;
import com.xdht.disease.sys.model.RecordPreEvaluationData;
import com.xdht.disease.sys.service.RecordPreEvaluationDataService;
import com.xdht.disease.sys.vo.request.RecordPreEvaluationDataRequest;
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
public class RecordPreEvaluationDataServiceImpl extends AbstractService<RecordPreEvaluationData> implements RecordPreEvaluationDataService{

    @Autowired
    private RecordPreEvaluationDataMapper recordPreEvaluationDataMapper;


    @Override
    public List<RecordPreEvaluationData> queryList(RecordPreEvaluationDataRequest recordPreEvaluationDataRequest) {
        Condition condition =  new Condition(RecordPreEvaluationData.class);
        condition.createCriteria().andEqualTo("id",recordPreEvaluationDataRequest.getId())
                .andEqualTo("preEvaluationId",recordPreEvaluationDataRequest.getPreEvaluationId())
                .andEqualTo("preEvaluationProjectId",recordPreEvaluationDataRequest.getPreEvaluationProjectId());
        if (recordPreEvaluationDataRequest.getSurveyResults() != null){
            condition.getOredCriteria().get(0).andLike("surveyResults","%"+recordPreEvaluationDataRequest.getSurveyResults()+"%");
        }
        return this.recordPreEvaluationDataMapper.selectByCondition(condition);
    }

    @Override
    public PageResult<RecordPreEvaluationData> queryListPage(RecordPreEvaluationDataRequest recordPreEvaluationDataRequest, Integer pageNum, Integer pageSize) {
            Condition condition =  new Condition(RecordPreEvaluationData.class);
            condition.createCriteria().andEqualTo("id",recordPreEvaluationDataRequest.getId())
                    .andEqualTo("preEvaluationId",recordPreEvaluationDataRequest.getPreEvaluationId())
                    .andEqualTo("preEvaluationProjectId",recordPreEvaluationDataRequest.getPreEvaluationProjectId());
            if (recordPreEvaluationDataRequest.getSurveyResults() != null){
                condition.getOredCriteria().get(0).andLike("surveyResults","%"+recordPreEvaluationDataRequest.getSurveyResults()+"%");
            }
            condition.setOrderByClause("id desc");
            PageHelper.startPage(pageNum, pageSize);
            List<RecordPreEvaluationData> dataList = this.recordPreEvaluationDataMapper.selectByCondition(condition);
            PageResult<RecordPreEvaluationData> pageList = new  PageResult<RecordPreEvaluationData>();
            pageList.setTotal(dataList.size());
            pageList.setDataList(dataList);
            return pageList;
    }

    @Override
    public RecordPreEvaluationData addRecordPreEvaluationData(RecordPreEvaluationData recordPreEvaluationData) {
        this.recordPreEvaluationDataMapper.insertUseGeneratedKeys(recordPreEvaluationData);
        return recordPreEvaluationData;
    }

    @Override
    public RecordPreEvaluationData deleteRecordPreEvaluationData(Long id) {
        this.recordPreEvaluationDataMapper.deleteByPrimaryKey(id);
        RecordPreEvaluationData recordPreEvaluationData = new RecordPreEvaluationData();
        recordPreEvaluationData.setId(id);
        return recordPreEvaluationData;
    }

    @Override
    public RecordPreEvaluationData updateRecordPreEvaluationData(RecordPreEvaluationData recordPreEvaluationData) {
        this.recordPreEvaluationDataMapper.updateByPrimaryKeySelective(recordPreEvaluationData);
        return recordPreEvaluationData;
    }
}
