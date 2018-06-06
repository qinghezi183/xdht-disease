package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.RecordAntiNoiseFacilitiesMapper;
import com.xdht.disease.sys.model.RecordAntiNoiseFacilities;
import com.xdht.disease.sys.service.RecordAntiNoiseFacilitiesService;
import com.xdht.disease.sys.vo.request.RecordAntiNoiseFacilitiesRequest;
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
public class RecordAntiNoiseFacilitiesServiceImpl extends AbstractService<RecordAntiNoiseFacilities> implements RecordAntiNoiseFacilitiesService{

    @Autowired
    private RecordAntiNoiseFacilitiesMapper recordAntiNoiseFacilitiesMapper;

    @Override
    public List<RecordAntiNoiseFacilities> queryList(RecordAntiNoiseFacilitiesRequest recordAntiNoiseFacilitiesRequest) {
        Condition condition =  new Condition(RecordAntiNoiseFacilities.class);
        condition.createCriteria() .andEqualTo("id", recordAntiNoiseFacilitiesRequest.getId())
                .andEqualTo("antiNoiseFacilitiesNo",recordAntiNoiseFacilitiesRequest.getAntiNoiseFacilitiesNo());
        if (recordAntiNoiseFacilitiesRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordAntiNoiseFacilitiesRequest.getVerificationResult()+"%");
        }
        if (recordAntiNoiseFacilitiesRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordAntiNoiseFacilitiesRequest.getStatus());
        }
        return this.recordAntiNoiseFacilitiesMapper.selectByCondition(condition);
    }

    @Override
    public PageResult<RecordAntiNoiseFacilities> queryListPage(RecordAntiNoiseFacilitiesRequest recordAntiNoiseFacilitiesRequest, Integer pageNum, Integer pageSize) {
        Condition condition =  new Condition(RecordAntiNoiseFacilities.class);
        condition.createCriteria() .andEqualTo("id", recordAntiNoiseFacilitiesRequest.getId())
                .andEqualTo("antiNoiseFacilitiesNo",recordAntiNoiseFacilitiesRequest.getAntiNoiseFacilitiesNo());
        if (recordAntiNoiseFacilitiesRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordAntiNoiseFacilitiesRequest.getVerificationResult()+"%");
        }
        if (recordAntiNoiseFacilitiesRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordAntiNoiseFacilitiesRequest.getStatus());
        }
        PageHelper.startPage(pageNum, pageSize);
        List<RecordAntiNoiseFacilities> dataList = this.recordAntiNoiseFacilitiesMapper.selectByCondition(condition);
        PageResult<RecordAntiNoiseFacilities> pageList = new  PageResult<RecordAntiNoiseFacilities>();
        pageList.setTotal(dataList.size());
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public RecordAntiNoiseFacilities addRecordAntiNoiseFacilities(RecordAntiNoiseFacilities recordAntiNoiseFacilities) {
            this.recordAntiNoiseFacilitiesMapper.insertUseGeneratedKeys(recordAntiNoiseFacilities);
            return recordAntiNoiseFacilities;
    }

    @Override
    public RecordAntiNoiseFacilities deleteRecordAntiNoiseFacilities(Long id) {
            this.recordAntiNoiseFacilitiesMapper.deleteByPrimaryKey(id);
            RecordAntiNoiseFacilities recordAntiNoiseFacilities = new RecordAntiNoiseFacilities();
            recordAntiNoiseFacilities.setId(id);
            return recordAntiNoiseFacilities;
    }

    @Override
    public RecordAntiNoiseFacilities updateRecordAntiNoiseFacilities(RecordAntiNoiseFacilities recordAntiNoiseFacilities) {
            this.recordAntiNoiseFacilitiesMapper.updateByPrimaryKeySelective(recordAntiNoiseFacilities);
            return recordAntiNoiseFacilities;
    }
}
