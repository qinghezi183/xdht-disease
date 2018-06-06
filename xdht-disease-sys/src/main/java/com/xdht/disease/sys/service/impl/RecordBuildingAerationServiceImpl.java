package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.RecordBuildingAerationMapper;
import com.xdht.disease.sys.model.RecordBuildingAeration;
import com.xdht.disease.sys.service.RecordBuildingAerationService;
import com.xdht.disease.sys.vo.request.RecordBuildingAerationRequest;
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
public class RecordBuildingAerationServiceImpl extends AbstractService<RecordBuildingAeration> implements RecordBuildingAerationService{

    @Autowired
    private RecordBuildingAerationMapper recordBuildingAerationMapper;

    @Override
    public List<RecordBuildingAeration> queryList(RecordBuildingAerationRequest recordBuildingAerationRequest) {
        Condition condition = new Condition(RecordBuildingAeration.class);
        condition.createCriteria() .andEqualTo("id", recordBuildingAerationRequest.getId())
                .andEqualTo("buildingAerationNo",recordBuildingAerationRequest.getBuildingAerationNo());
        if (recordBuildingAerationRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordBuildingAerationRequest.getVerificationResult()+"%");
        }
        if (recordBuildingAerationRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordBuildingAerationRequest.getStatus());
        }
        return this.recordBuildingAerationMapper.selectByCondition(condition);
    }

    @Override
    public PageResult<RecordBuildingAeration> queryListPage(RecordBuildingAerationRequest recordBuildingAerationRequest, Integer pageNum, Integer pageSize) {
        Condition condition = new Condition(RecordBuildingAeration.class);
        condition.createCriteria() .andEqualTo("id", recordBuildingAerationRequest.getId())
                .andEqualTo("buildingAerationNo",recordBuildingAerationRequest.getBuildingAerationNo());
        if (recordBuildingAerationRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordBuildingAerationRequest.getVerificationResult()+"%");
        }
        if (recordBuildingAerationRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordBuildingAerationRequest.getStatus());
        }
        PageHelper.startPage(pageNum, pageSize);
        List<RecordBuildingAeration> dataList = this.recordBuildingAerationMapper.selectByCondition(condition);
        PageResult<RecordBuildingAeration> pageList = new  PageResult<RecordBuildingAeration>();
        pageList.setTotal(dataList.size());
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public RecordBuildingAeration add(RecordBuildingAeration recordBuildingAeration) {
        this.recordBuildingAerationMapper.insertUseGeneratedKeys(recordBuildingAeration);
        return recordBuildingAeration;
    }

    @Override
    public RecordBuildingAeration delete(Long id) {
        this.recordBuildingAerationMapper.deleteByPrimaryKey(id);
        RecordBuildingAeration recordBuildingAeration = new RecordBuildingAeration();
        recordBuildingAeration.setId(id);
        return recordBuildingAeration;
    }

    @Override
    public RecordBuildingAeration update(RecordBuildingAeration recordBuildingAeration) {
        this.recordBuildingAerationMapper.updateByPrimaryKeySelective(recordBuildingAeration);
        return recordBuildingAeration;
    }
}
