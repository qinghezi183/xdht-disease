package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.RecordSceneMapper;
import com.xdht.disease.sys.model.RecordScene;
import com.xdht.disease.sys.service.RecordSceneService;
import com.xdht.disease.sys.vo.request.RecordSceneRequest;
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
public class RecordSceneServiceImpl extends AbstractService<RecordScene> implements RecordSceneService{

    @Autowired
    private RecordSceneMapper recordSceneMapper;

    @Override
    public List<RecordScene> queryList(RecordSceneRequest recordSceneRequest) {
        Condition condition = new Condition(RecordScene.class);
        condition.createCriteria() .andEqualTo("id", recordSceneRequest.getId())
                .andEqualTo("recordNo",recordSceneRequest.getRecordNo());
        if (recordSceneRequest.getProjectName() != null) {
            condition.getOredCriteria().get(0).andLike("projectName","%"+recordSceneRequest.getProjectName()+"%");
        }
        if (recordSceneRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordSceneRequest.getStatus());
        }
        if (recordSceneRequest.getInquiryType() != null){
            condition.getOredCriteria().get(0).andEqualTo("inquiryType",recordSceneRequest.getInquiryType());
        }
        if (recordSceneRequest.getInquiryPerson() != null){
            condition.getOredCriteria().get(0).andLike("inquiryPerson","%"+recordSceneRequest.getInquiryPerson()+"%");
        }
        if (recordSceneRequest.getInquiryCompany() != null){
            condition.getOredCriteria().get(0).andLike("inquiryCompany","%"+recordSceneRequest.getInquiryCompany()+"%");
        }
        return this.recordSceneMapper.selectByCondition(condition);
    }

    @Override
    public PageResult<RecordScene> queryListPage(RecordSceneRequest recordSceneRequest, Integer pageNum, Integer pageSize) {
        Condition condition = new Condition(RecordScene.class);
        condition.createCriteria() .andEqualTo("id", recordSceneRequest.getId())
                .andEqualTo("recordNo",recordSceneRequest.getRecordNo());
        if (recordSceneRequest.getProjectName() != null) {
            condition.getOredCriteria().get(0).andLike("projectName","%"+recordSceneRequest.getProjectName()+"%");
        }
        if (recordSceneRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordSceneRequest.getStatus());
        }
        if (recordSceneRequest.getInquiryType() != null){
            condition.getOredCriteria().get(0).andEqualTo("inquiryType",recordSceneRequest.getInquiryType());
        }
        if (recordSceneRequest.getInquiryPerson() != null){
            condition.getOredCriteria().get(0).andLike("inquiryPerson","%"+recordSceneRequest.getInquiryPerson()+"%");
        }
        if (recordSceneRequest.getInquiryCompany() != null){
            condition.getOredCriteria().get(0).andLike("inquiryCompany","%"+recordSceneRequest.getInquiryCompany()+"%");
        }
        condition.setOrderByClause("id desc");
        PageHelper.startPage(pageNum, pageSize);
        List<RecordScene> dataList = this.recordSceneMapper.selectByCondition(condition);
        PageResult<RecordScene> pageList = new  PageResult<RecordScene>();
        pageList.setTotal(dataList.size());
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public RecordScene addRecordScene(RecordScene recordScene) {
            this.insertUseGeneratedKeys(recordScene);
            return recordScene;
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
}
