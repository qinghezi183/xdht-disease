package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.RecordHealthManagementDataMapper;
import com.xdht.disease.sys.model.RecordHealthManagementData;
import com.xdht.disease.sys.service.RecordHealthManagementDataService;
import com.xdht.disease.sys.vo.request.RecordHealthManagementDataRequest;
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
public class RecordHealthManagementDataServiceImpl extends AbstractService<RecordHealthManagementData> implements RecordHealthManagementDataService{

    @Autowired
    private RecordHealthManagementDataMapper recordHealthManagementDataMapper;

    @Override
    public List<RecordHealthManagementData> queryList(RecordHealthManagementDataRequest recordHealthManagementDataRequest) {

        Condition condition = new Condition(RecordHealthManagementData.class);
        condition.createCriteria() .andEqualTo("id", recordHealthManagementDataRequest.getId())
                .andEqualTo("healthManagementId",recordHealthManagementDataRequest.getHealthManagementId())
                .andEqualTo("healthManagementProjectId",recordHealthManagementDataRequest.getHealthManagementProjectId());
        return this.recordHealthManagementDataMapper.selectByCondition(condition);
    }

    @Override
    public PageResult<RecordHealthManagementData> queryListPage(RecordHealthManagementDataRequest recordHealthManagementDataRequest, Integer pageNum, Integer pageSize) {
        Condition condition = new Condition(RecordHealthManagementData.class);
        condition.createCriteria() .andEqualTo("id", recordHealthManagementDataRequest.getId())
                .andEqualTo("healthManagementId",recordHealthManagementDataRequest.getHealthManagementId())
                .andEqualTo("healthManagementProjectId",recordHealthManagementDataRequest.getHealthManagementProjectId());
        PageHelper.startPage(pageNum, pageSize);
        List<RecordHealthManagementData> dataList = this.recordHealthManagementDataMapper.selectByCondition(condition);
        PageResult<RecordHealthManagementData> pageList = new  PageResult<RecordHealthManagementData>();
        pageList.setTotal(dataList.size());
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public RecordHealthManagementData add(RecordHealthManagementData recordHealthManagementData) {
            this.recordHealthManagementDataMapper.insertUseGeneratedKeys(recordHealthManagementData);
            return recordHealthManagementData;
    }

    @Override
    public RecordHealthManagementData delete(Long id) {
            this.recordHealthManagementDataMapper.deleteByPrimaryKey(id);
            RecordHealthManagementData recordHealthManagementData = new RecordHealthManagementData();
            recordHealthManagementData.setId(id);
            return recordHealthManagementData;
    }

    @Override
    public RecordHealthManagementData update(RecordHealthManagementData recordHealthManagementData) {
        this.recordHealthManagementDataMapper.updateByPrimaryKeySelective(recordHealthManagementData);
        return recordHealthManagementData;
    }
}
