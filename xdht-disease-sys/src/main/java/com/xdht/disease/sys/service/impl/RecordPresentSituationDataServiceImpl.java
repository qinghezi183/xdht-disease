package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.RecordPresentSituationDataMapper;
import com.xdht.disease.sys.model.RecordPresentSituation;
import com.xdht.disease.sys.model.RecordPresentSituationData;
import com.xdht.disease.sys.service.RecordPresentSituationDataService;
import com.xdht.disease.sys.vo.request.RecordPresentSituationDataRequest;
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
public class RecordPresentSituationDataServiceImpl extends AbstractService<RecordPresentSituationData> implements RecordPresentSituationDataService{

    @Autowired
    private RecordPresentSituationDataMapper recordPresentSituationDataMapper;

    @Override
    public List<RecordPresentSituationData> queryList(RecordPresentSituationDataRequest recordPresentSituationDataRequest) {
            Condition condition =  new Condition(RecordPresentSituationData.class);
            condition.createCriteria().andEqualTo("id",recordPresentSituationDataRequest.getId())
                    .andEqualTo("preEvaluationId",recordPresentSituationDataRequest.getPreEvaluationId())
                    .andEqualTo("preEvaluationProjectId",recordPresentSituationDataRequest.getPreEvaluationProjectId());
            if (recordPresentSituationDataRequest.getSurveyResults() != null){
                condition.getOredCriteria().get(0).andLike("surveyResults","%"+recordPresentSituationDataRequest.getSurveyResults()+"%");
            }
            return this.recordPresentSituationDataMapper.selectByCondition(condition);
    }

    @Override
    public PageResult<RecordPresentSituationData> queryListPage(RecordPresentSituationDataRequest recordPresentSituationDataRequest, Integer pageNum, Integer pageSize) {
        Condition condition =  new Condition(RecordPresentSituationData.class);
        condition.createCriteria().andEqualTo("id",recordPresentSituationDataRequest.getId())
                .andEqualTo("preEvaluationId",recordPresentSituationDataRequest.getPreEvaluationId())
                .andEqualTo("preEvaluationProjectId",recordPresentSituationDataRequest.getPreEvaluationProjectId());
        if (recordPresentSituationDataRequest.getSurveyResults() != null){
            condition.getOredCriteria().get(0).andLike("surveyResults","%"+recordPresentSituationDataRequest.getSurveyResults()+"%");
        }
        PageHelper.startPage(pageNum, pageSize);
        List<RecordPresentSituationData> dataList = this.recordPresentSituationDataMapper.selectByCondition(condition);
        PageResult<RecordPresentSituationData> pageList = new  PageResult<RecordPresentSituationData>();
        pageList.setTotal(dataList.size());
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public RecordPresentSituationData addRecordPresentSituationData(RecordPresentSituationData recordPresentSituationData) {
            this.recordPresentSituationDataMapper.insertUseGeneratedKeys(recordPresentSituationData);
            return recordPresentSituationData;
    }

    @Override
    public RecordPresentSituationData deleteRecordPresentSituationData(Long id) {
            this.recordPresentSituationDataMapper.deleteByPrimaryKey(id);
            RecordPresentSituationData recordPresentSituationData = new RecordPresentSituationData();
            recordPresentSituationData.setId(id);
            return recordPresentSituationData;
    }

    @Override
    public RecordPresentSituationData updateRecordPresentSituationData(RecordPresentSituationData recordPresentSituationData) {
            this.recordPresentSituationDataMapper.updateByPrimaryKeySelective(recordPresentSituationData);
            return recordPresentSituationData;
    }
}
