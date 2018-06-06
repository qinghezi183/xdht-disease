package com.xdht.disease.sys.service.impl;

import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.sys.dao.RecordFundsProjectMapper;
import com.xdht.disease.sys.model.RecordFundsProject;
import com.xdht.disease.sys.service.RecordFundsProjectService;
import com.xdht.disease.sys.vo.request.RecordFundsProjectRequest;
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
public class RecordFundsProjectServiceImpl extends AbstractService<RecordFundsProject> implements RecordFundsProjectService{

    @Autowired
    private RecordFundsProjectMapper recordFundsProjectMapper;

    @Override
    public List<RecordFundsProject> queryList(RecordFundsProjectRequest recordFundsProjectRequest) {
        Condition condition = new Condition(RecordFundsProject.class);
        condition.createCriteria() .andEqualTo("id", recordFundsProjectRequest.getId());
        if (recordFundsProjectRequest.getProjectName() != null) {
            condition.getOredCriteria().get(0).andLike("projectName","%"+recordFundsProjectRequest.getProjectName()+"%");
        }
        if (recordFundsProjectRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordFundsProjectRequest.getStatus());
        }
        return this.recordFundsProjectMapper.selectByCondition(condition);
    }

    @Override
    public RecordFundsProject add(RecordFundsProject recordFundsProject) {
            this.recordFundsProjectMapper.insertUseGeneratedKeys(recordFundsProject);
            return recordFundsProject;
    }

    @Override
    public RecordFundsProject delete(Long id) {
        this.recordFundsProjectMapper.deleteByPrimaryKey(id);
        RecordFundsProject recordFundsProject = new RecordFundsProject();
        recordFundsProject.setId(id);
        return recordFundsProject;
    }

    @Override
    public RecordFundsProject update(RecordFundsProject recordFundsProject) {
        this.recordFundsProjectMapper.updateByPrimaryKeySelective(recordFundsProject);
        return recordFundsProject;
    }
}
