package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.RecordScenQuestionnaireMapper;
import com.xdht.disease.sys.model.RecordScenQuestionnaire;
import com.xdht.disease.sys.service.RecordScenQuestionnaireService;
import com.xdht.disease.sys.vo.request.RecordScenQuestionnaireRequest;
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
public class RecordScenQuestionnaireServiceImpl extends AbstractService<RecordScenQuestionnaire> implements RecordScenQuestionnaireService{

    @Autowired
    private RecordScenQuestionnaireMapper recordScenQuestionnaireMapper;

    @Override
    public List<RecordScenQuestionnaire> queryList(RecordScenQuestionnaireRequest recordScenQuestionnaireRequest) {
        Condition condition = new Condition(RecordScenQuestionnaire.class);
        condition.createCriteria() .andEqualTo("id", recordScenQuestionnaireRequest.getId())
                .andEqualTo("sceneId",recordScenQuestionnaireRequest.getSceneId())
                .andEqualTo("questionnaireId",recordScenQuestionnaireRequest.getQuestionnaireId());
        if (recordScenQuestionnaireRequest.getGeneratorRecord() != null){
            condition.getOredCriteria().get(0).andEqualTo("generatorRecord",recordScenQuestionnaireRequest.getGeneratorRecord());
        }
        if (recordScenQuestionnaireRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordScenQuestionnaireRequest.getStatus());
        }
        return this.recordScenQuestionnaireMapper.selectByCondition(condition);
    }

    @Override
    public PageResult<RecordScenQuestionnaire> queryListPage(RecordScenQuestionnaireRequest recordScenQuestionnaireRequest, Integer pageNum, Integer pageSize) {
        Condition condition = new Condition(RecordScenQuestionnaire.class);
        condition.createCriteria() .andEqualTo("id", recordScenQuestionnaireRequest.getId())
                .andEqualTo("sceneId",recordScenQuestionnaireRequest.getSceneId())
                .andEqualTo("questionnaireId",recordScenQuestionnaireRequest.getQuestionnaireId());
        if (recordScenQuestionnaireRequest.getGeneratorRecord() != null){
            condition.getOredCriteria().get(0).andEqualTo("generatorRecord",recordScenQuestionnaireRequest.getGeneratorRecord());
        }
        if (recordScenQuestionnaireRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordScenQuestionnaireRequest.getStatus());
        }
        PageHelper.startPage(pageNum, pageSize);
        List<RecordScenQuestionnaire> dataList = this.recordScenQuestionnaireMapper.selectByCondition(condition);
        PageResult<RecordScenQuestionnaire> pageList = new  PageResult<RecordScenQuestionnaire>();
        pageList.setTotal(dataList.size());
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public RecordScenQuestionnaire addRecordScenQuestionnaire(RecordScenQuestionnaire recordScenQuestionnaire) {
        this.recordScenQuestionnaireMapper.insertUseGeneratedKeys(recordScenQuestionnaire);
        return recordScenQuestionnaire;
    }

    @Override
    public RecordScenQuestionnaire deleteRecordScenQuestionnaire(Long id) {
            this.recordScenQuestionnaireMapper.deleteByPrimaryKey(id);
            RecordScenQuestionnaire recordScenQuestionnaire = new RecordScenQuestionnaire();
            recordScenQuestionnaire.setId(id);
            return recordScenQuestionnaire;
    }

    @Override
    public RecordScenQuestionnaire updateRecordScenQuestionnaire(RecordScenQuestionnaire recordScenQuestionnaire) {
            this.recordScenQuestionnaireMapper.updateByPrimaryKeySelective(recordScenQuestionnaire);
            return recordScenQuestionnaire;
    }
}
