package com.xdht.disease.sys.service.impl;

import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.sys.dao.RecordHealthCareProjectMapper;
import com.xdht.disease.sys.model.RecordHealthCareProject;
import com.xdht.disease.sys.service.RecordHealthCareProjectService;
import com.xdht.disease.sys.vo.request.RecordHealthCareProjectRequest;
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
public class RecordHealthCareProjectServiceImpl extends AbstractService<RecordHealthCareProject> implements RecordHealthCareProjectService{

    @Autowired
    private RecordHealthCareProjectMapper recordHealthCareProjectMapper;

    @Override
    public List<RecordHealthCareProject> queryList(RecordHealthCareProjectRequest recordHealthCareProjectRequest) {
        Condition condition = new Condition(RecordHealthCareProject.class);
        condition.createCriteria() .andEqualTo("id", recordHealthCareProjectRequest.getId());
        if (recordHealthCareProjectRequest.getProjectName() != null) {
            condition.getOredCriteria().get(0).andLike("projectName","%"+recordHealthCareProjectRequest.getProjectName()+"%");
        }
        if (recordHealthCareProjectRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordHealthCareProjectRequest.getStatus());
        }
        return this.recordHealthCareProjectMapper.selectByCondition(condition);
    }

    @Override
    public RecordHealthCareProject add(RecordHealthCareProject recordHealthCareProject) {
            this.recordHealthCareProjectMapper.insertUseGeneratedKeys(recordHealthCareProject);
            return recordHealthCareProject;
    }

    @Override
    public RecordHealthCareProject delete(Long id) {
            this.recordHealthCareProjectMapper.deleteByPrimaryKey(id);
            RecordHealthCareProject recordHealthCareProject = new RecordHealthCareProject();
            recordHealthCareProject.setId(id);
            return recordHealthCareProject;
    }

    @Override
    public RecordHealthCareProject update(RecordHealthCareProject recordHealthCareProject) {
        this.recordHealthCareProjectMapper.updateByPrimaryKeySelective(recordHealthCareProject);
        return recordHealthCareProject;
    }
}
