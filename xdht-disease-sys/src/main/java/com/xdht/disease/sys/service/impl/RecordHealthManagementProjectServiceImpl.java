package com.xdht.disease.sys.service.impl;

import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.sys.dao.RecordHealthManagementProjectMapper;
import com.xdht.disease.sys.model.RecordHealthManagementProject;
import com.xdht.disease.sys.service.RecordHealthManagementProjectService;
import com.xdht.disease.sys.vo.request.RecordHealthManagementProjectRequest;
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
public class RecordHealthManagementProjectServiceImpl extends AbstractService<RecordHealthManagementProject> implements RecordHealthManagementProjectService{

    @Autowired
    private RecordHealthManagementProjectMapper recordHealthManagementProjectMapper;

    @Override
    public List<RecordHealthManagementProject> queryList(RecordHealthManagementProjectRequest recordRequest) {
        Condition condition = new Condition(RecordHealthManagementProject.class);
        condition.createCriteria() .andEqualTo("id", recordRequest.getId());
        if (recordRequest.getProjectName() != null) {
            condition.getOredCriteria().get(0).andLike("projectName","%"+recordRequest.getProjectName()+"%");
        }
        if (recordRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordRequest.getStatus());
        }
        return this.recordHealthManagementProjectMapper.selectByCondition(condition);
    }

    @Override
    public RecordHealthManagementProject add(RecordHealthManagementProject recordHealthManagementProject) {
            this.recordHealthManagementProjectMapper.insertUseGeneratedKeys(recordHealthManagementProject);
            return recordHealthManagementProject;
    }

    @Override
    public RecordHealthManagementProject delete(Long id) {
            this.recordHealthManagementProjectMapper.deleteByPrimaryKey(id);
            RecordHealthManagementProject recordHealthManagementProject = new RecordHealthManagementProject();
            recordHealthManagementProject.setId(id);
            return recordHealthManagementProject;
    }

    @Override
    public RecordHealthManagementProject update(RecordHealthManagementProject recordHealthManagementProject) {
        this.recordHealthManagementProjectMapper.updateByPrimaryKeySelective(recordHealthManagementProject);
        return  recordHealthManagementProject;
    }
}
