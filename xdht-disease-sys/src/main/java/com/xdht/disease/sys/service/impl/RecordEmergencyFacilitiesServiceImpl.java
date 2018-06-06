package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.RecordEmergencyFacilitiesMapper;
import com.xdht.disease.sys.model.RecordEmergencyFacilities;
import com.xdht.disease.sys.service.RecordEmergencyFacilitiesService;
import com.xdht.disease.sys.vo.request.RecordEmergencyFacilitiesRequest;
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
public class RecordEmergencyFacilitiesServiceImpl extends AbstractService<RecordEmergencyFacilities> implements RecordEmergencyFacilitiesService{

    @Autowired
    private RecordEmergencyFacilitiesMapper recordEmergencyFacilitiesMapper;

    @Override
    public List<RecordEmergencyFacilities> queryList(RecordEmergencyFacilitiesRequest recordEmergencyFacilitiesRequest) {
        Condition condition = new Condition(RecordEmergencyFacilities.class);
        condition.createCriteria() .andEqualTo("id", recordEmergencyFacilitiesRequest.getId())
                .andEqualTo("emergencyFacilitiesNo",recordEmergencyFacilitiesRequest.getEmergencyFacilitiesNo());
        if (recordEmergencyFacilitiesRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordEmergencyFacilitiesRequest.getVerificationResult()+"%");
        }
        if (recordEmergencyFacilitiesRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordEmergencyFacilitiesRequest.getStatus());
        }
        return this.recordEmergencyFacilitiesMapper.selectByCondition(condition);
    }

    @Override
    public PageResult<RecordEmergencyFacilities> queryListPage(RecordEmergencyFacilitiesRequest recordEmergencyFacilitiesRequest, Integer pageNum, Integer pageSize) {
        Condition condition = new Condition(RecordEmergencyFacilities.class);
        condition.createCriteria() .andEqualTo("id", recordEmergencyFacilitiesRequest.getId())
                .andEqualTo("emergencyFacilitiesNo",recordEmergencyFacilitiesRequest.getEmergencyFacilitiesNo());
        if (recordEmergencyFacilitiesRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordEmergencyFacilitiesRequest.getVerificationResult()+"%");
        }
        if (recordEmergencyFacilitiesRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordEmergencyFacilitiesRequest.getStatus());
        }
        PageHelper.startPage(pageNum, pageSize);
        List<RecordEmergencyFacilities> dataList = this.recordEmergencyFacilitiesMapper.selectByCondition(condition);
        PageResult<RecordEmergencyFacilities> pageList = new  PageResult<RecordEmergencyFacilities>();
        pageList.setTotal(dataList.size());
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public RecordEmergencyFacilities add(RecordEmergencyFacilities recordEmergencyFacilities) {
            this.recordEmergencyFacilitiesMapper.insertUseGeneratedKeys(recordEmergencyFacilities);
            return recordEmergencyFacilities;
    }

    @Override
    public RecordEmergencyFacilities delete(Long id) {
            this.recordEmergencyFacilitiesMapper.deleteByPrimaryKey(id);
            RecordEmergencyFacilities recordEmergencyFacilities = new RecordEmergencyFacilities();
            recordEmergencyFacilities.setId(id);
            return  recordEmergencyFacilities;
    }

    @Override
    public RecordEmergencyFacilities update(RecordEmergencyFacilities recordEmergencyFacilities) {
        this.recordEmergencyFacilitiesMapper.updateByPrimaryKeySelective(recordEmergencyFacilities);
        return recordEmergencyFacilities;
    }
}
