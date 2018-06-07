package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.RecordControlEffectDataMapper;
import com.xdht.disease.sys.model.RecordControlEffectData;
import com.xdht.disease.sys.service.RecordControlEffectDataService;
import com.xdht.disease.sys.vo.request.RecordControlEffectDataRequest;
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
public class RecordControlEffectDataServiceImpl extends AbstractService<RecordControlEffectData> implements RecordControlEffectDataService{

    @Autowired
    private RecordControlEffectDataMapper recordControlEffectDataMapper;

        @Override
        public List<RecordControlEffectData> queryList(RecordControlEffectDataRequest recordControlEffectDataRequest) {
            Condition condition =  new Condition(RecordControlEffectData.class);
            condition.createCriteria().andEqualTo("id",recordControlEffectDataRequest.getId())
                    .andEqualTo("preEvaluationId",recordControlEffectDataRequest.getPreEvaluationId())
                    .andEqualTo("preEvaluationProjectId",recordControlEffectDataRequest.getPreEvaluationProjectId());
            if (recordControlEffectDataRequest.getSurveyResults() != null){
                condition.getOredCriteria().get(0).andLike("surveyResults","%"+recordControlEffectDataRequest.getSurveyResults()+"%");
            }
            return this.recordControlEffectDataMapper.selectByCondition(condition);
        }

    @Override
    public PageResult<RecordControlEffectData> queryListPage(RecordControlEffectDataRequest recordControlEffectDataRequest, Integer pageNum, Integer pageSize) {
        Condition condition =  new Condition(RecordControlEffectData.class);
        condition.createCriteria().andEqualTo("id",recordControlEffectDataRequest.getId())
                .andEqualTo("preEvaluationId",recordControlEffectDataRequest.getPreEvaluationId())
                .andEqualTo("preEvaluationProjectId",recordControlEffectDataRequest.getPreEvaluationProjectId());
        if (recordControlEffectDataRequest.getSurveyResults() != null){
            condition.getOredCriteria().get(0).andLike("surveyResults","%"+recordControlEffectDataRequest.getSurveyResults()+"%");
        }
        PageHelper.startPage(pageNum, pageSize);
        List<RecordControlEffectData> dataList = this.recordControlEffectDataMapper.selectByCondition(condition);
        PageResult<RecordControlEffectData> pageList = new  PageResult<RecordControlEffectData>();
        pageList.setTotal(dataList.size());
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
        public RecordControlEffectData addRecordControlEffectData(RecordControlEffectData recordControlEffectData) {
            this.recordControlEffectDataMapper.insertUseGeneratedKeys(recordControlEffectData);
            return recordControlEffectData;
        }

        @Override
        public RecordControlEffectData deleteRecordControlEffectData(Long id) {
            this.recordControlEffectDataMapper.deleteByPrimaryKey(id);
            RecordControlEffectData recordControlEffectData = new RecordControlEffectData();
            recordControlEffectData.setId(id);
            return recordControlEffectData;
        }

        @Override
        public RecordControlEffectData updateRecordControlEffectData(RecordControlEffectData recordControlEffectData) {
            this.recordControlEffectDataMapper.updateByPrimaryKeySelective(recordControlEffectData);
            return recordControlEffectData;
        }
}
