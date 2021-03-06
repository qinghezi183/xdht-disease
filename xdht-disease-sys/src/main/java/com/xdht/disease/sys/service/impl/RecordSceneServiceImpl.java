package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.constant.SysEnum;
import com.xdht.disease.sys.dao.RecordSceneMapper;
import com.xdht.disease.sys.model.RecordScenQuestionnaire;
import com.xdht.disease.sys.model.RecordScene;
import com.xdht.disease.sys.service.RecordScenQuestionnaireService;
import com.xdht.disease.sys.service.RecordSceneService;
import com.xdht.disease.sys.vo.request.RecordSceneInputRequest;
import com.xdht.disease.sys.vo.request.RecordSceneRequest;
import com.xdht.disease.sys.vo.response.RecordSceneDetailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.LinkedList;
import java.util.List;


/**
 * Created by lzf on 2018/06/04.
 */
@Service
@Transactional
public class RecordSceneServiceImpl extends AbstractService<RecordScene> implements RecordSceneService{

    @Autowired
    private RecordSceneMapper recordSceneMapper;

    @Autowired
    private RecordScenQuestionnaireService recordScenQuestionnaireService;

    @Override
    public PageResult<RecordScene> queryListPage(RecordSceneRequest recordSceneRequest) {
        Condition condition = new Condition(RecordScene.class);
//        condition.createCriteria() .andEqualTo("id", recordSceneRequest.getId())
//                .andEqualTo("recordNo",recordSceneRequest.getRecordNo());
        if (recordSceneRequest.getProjectName() != null) {
            condition.createCriteria().andLike("projectName","%"+recordSceneRequest.getProjectName()+"%");
        }
//        if (recordSceneRequest.getStatus() != null){
//            condition.getOredCriteria().get(0).andEqualTo("status",recordSceneRequest.getStatus());
//        }
//        if (recordSceneRequest.getInquiryType() != null){
//            condition.getOredCriteria().get(0).andEqualTo("inquiryType",recordSceneRequest.getInquiryType());
//        }
//        if (recordSceneRequest.getInquiryPerson() != null){
//            condition.getOredCriteria().get(0).andLike("inquiryPerson","%"+recordSceneRequest.getInquiryPerson()+"%");
//        }
//        if (recordSceneRequest.getInquiryCompany() != null){
//            condition.getOredCriteria().get(0).andLike("inquiryCompany","%"+recordSceneRequest.getInquiryCompany()+"%");
//        }
        condition.setOrderByClause("id desc");
        PageHelper.startPage(recordSceneRequest.getPageNumber(), recordSceneRequest.getPageSize());
        List<RecordScene> dataList = this.recordSceneMapper.selectByCondition(condition);
        PageResult<RecordScene> pageList = new  PageResult<RecordScene>();
        pageList.setTotal(dataList.size());
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public RecordScene deleteRecordScene(Long id) {
        this.recordSceneMapper.deleteByPrimaryKey(id);
        RecordScene recordScene = new RecordScene();
        recordScene.setId(id);
        return recordScene;
    }

    @Override
    public RecordScene updateRecordScene(RecordScene recordScene) {
        this.recordSceneMapper.updateByPrimaryKeySelective(recordScene);
        return recordScene;
    }

    @Override
    public RecordScene add(RecordSceneInputRequest recordSceneInputRequest) {
        RecordScene recordScene = new RecordScene();
        recordScene.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
        recordScene.setInquiryDate(recordSceneInputRequest.getRecordScene().getInquiryDate());
        recordScene.setInquiryPerson(recordSceneInputRequest.getRecordScene().getInquiryPerson());
        recordScene.setInquiryCompanyEmployee(recordSceneInputRequest.getRecordScene().getInquiryCompanyEmployee());
        recordScene.setProjectName(recordSceneInputRequest.getRecordScene().getProjectName());
        recordScene.setInquiryType(recordSceneInputRequest.getRecordScene().getInquiryType());
        recordScene.setRecordNo(recordSceneInputRequest.getRecordScene().getRecordNo());
        recordScene.setInquiryCompany(recordSceneInputRequest.getRecordScene().getInquiryCompany());
        this.insertUseGeneratedKeys(recordScene);

        List<RecordScenQuestionnaire> recordScenQuestionnaireList = new LinkedList<>();
        for (RecordScenQuestionnaire recordScenQuestionnaire : recordSceneInputRequest.getRecordScenQuestionnaireList()) {
            recordScenQuestionnaire.setSceneId(recordScene.getId());
            recordScenQuestionnaire.setStatus(SysEnum.StatusEnum.STATUS_NORMAL.getCode());
            recordScenQuestionnaireList.add(recordScenQuestionnaire);
        }
        this.recordScenQuestionnaireService.insertList(recordScenQuestionnaireList);
        return recordScene;
    }

    @Override
    public RecordSceneDetailResponse queryRecordSceneDetail(Long id) {
        RecordSceneDetailResponse recordSceneDetailResponse = new RecordSceneDetailResponse();
        recordSceneDetailResponse.setRecordSceneMap(this.recordSceneMapper.selectRecordSceneMapByPrimaryKey(id));
        recordSceneDetailResponse.setScenQuestionnaireMapList(this.recordScenQuestionnaireService.queryRecordScenQuestionnaireMapListByRecordScen(id));
        return recordSceneDetailResponse;
    }
}
