package com.xdht.disease.sys.service.impl;

import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.sys.dao.RecordPresentSituationProjectMapper;
import com.xdht.disease.sys.model.RecordPresentSituationProject;
import com.xdht.disease.sys.service.RecordPresentSituationProjectService;
import com.xdht.disease.sys.vo.request.RecordPresentSituationProjectRequest;
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
public class RecordPresentSituationProjectServiceImpl extends AbstractService<RecordPresentSituationProject> implements RecordPresentSituationProjectService{

    @Autowired
    private RecordPresentSituationProjectMapper recordPresentSituationProjectMapper;

    @Override
    public List<RecordPresentSituationProject> queryList(RecordPresentSituationProjectRequest recordPresentSituationProjectRequest) {
        Condition condition =  new Condition(RecordPresentSituationProject.class);
        condition.createCriteria().andEqualTo("id",recordPresentSituationProjectRequest.getId());
        if (recordPresentSituationProjectRequest.getProjectName() != null){
            condition.getOredCriteria().get(0).andLike("projectName","%"+recordPresentSituationProjectRequest.getProjectName()+"%");
        }
        return this.recordPresentSituationProjectMapper.selectByCondition(condition);
    }

    @Override
    public RecordPresentSituationProject add(RecordPresentSituationProject recordPresentSituationProject) {
        this.recordPresentSituationProjectMapper.insertUseGeneratedKeys(recordPresentSituationProject);
        return recordPresentSituationProject;
    }

    @Override
    public RecordPresentSituationProject delete(Long id) {
            this.recordPresentSituationProjectMapper.deleteByPrimaryKey(id);
            RecordPresentSituationProject recordPresentSituationProject = new RecordPresentSituationProject();
            recordPresentSituationProject.setId(id);
            return recordPresentSituationProject;
    }

    @Override
    public RecordPresentSituationProject update(RecordPresentSituationProject recordPresentSituationProject) {
        this.recordPresentSituationProjectMapper.updateByPrimaryKeySelective(recordPresentSituationProject);
        return recordPresentSituationProject;
    }
}
