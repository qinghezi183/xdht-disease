package com.xdht.disease.sys.service.impl;

import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.sys.dao.RecordControlEffectProjectMapper;
import com.xdht.disease.sys.model.RecordControlEffectProject;
import com.xdht.disease.sys.service.RecordControlEffectProjectService;
import com.xdht.disease.sys.vo.request.RecordControlEffectProjectRequest;
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
public class RecordControlEffectProjectServiceImpl extends AbstractService<RecordControlEffectProject> implements RecordControlEffectProjectService{

    @Autowired
    private RecordControlEffectProjectMapper recordControlEffectProjectMapper;

    @Override
    public List<RecordControlEffectProject> queryList(RecordControlEffectProjectRequest recordControlEffectProjectRequest) {
        Condition condition = new Condition(RecordControlEffectProject.class);
        condition.createCriteria() .andEqualTo("id", recordControlEffectProjectRequest.getId());
        if (recordControlEffectProjectRequest.getProjectName() != null) {
            condition.getOredCriteria().get(0).andLike("projectName","%"+recordControlEffectProjectRequest.getProjectName()+"%");
        }
        if (recordControlEffectProjectRequest.getStatus() != null) {
            condition.getOredCriteria().get(0).andLike("status",recordControlEffectProjectRequest.getStatus());
        }
        return this.recordControlEffectProjectMapper.selectByCondition(condition);
    }

    @Override
    public RecordControlEffectProject add(RecordControlEffectProject recordControlEffectProject) {
            this.recordControlEffectProjectMapper.insertUseGeneratedKeys(recordControlEffectProject);
            return recordControlEffectProject;
    }

    @Override
    public RecordControlEffectProject delete(Long id) {
            this.recordControlEffectProjectMapper.deleteByPrimaryKey(id);
            RecordControlEffectProject recordControlEffectProject = new RecordControlEffectProject();
            recordControlEffectProject.setId(id);
            return recordControlEffectProject;
    }

    @Override
    public RecordControlEffectProject update(RecordControlEffectProject recordControlEffectProject) {
            this.recordControlEffectProjectMapper.updateByPrimaryKeySelective(recordControlEffectProject);
            return recordControlEffectProject;
    }
}
