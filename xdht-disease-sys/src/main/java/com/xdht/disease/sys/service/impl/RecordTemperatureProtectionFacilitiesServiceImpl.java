package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.RecordTemperatureProtectionFacilitiesMapper;
import com.xdht.disease.sys.model.RecordTemperatureProtectionFacilities;
import com.xdht.disease.sys.service.RecordTemperatureProtectionFacilitiesService;
import com.xdht.disease.sys.vo.request.RecordTemperatureProtectionFacilitiesRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;


/**
 * Created by lzf on 2018/06/06.
 */
@Service
@Transactional
public class RecordTemperatureProtectionFacilitiesServiceImpl extends AbstractService<RecordTemperatureProtectionFacilities> implements RecordTemperatureProtectionFacilitiesService{

    @Autowired
    private RecordTemperatureProtectionFacilitiesMapper recordMapper;

    @Override
    public List<RecordTemperatureProtectionFacilities> queryList(RecordTemperatureProtectionFacilitiesRequest recordRequest) {
        Condition condition = new Condition(RecordTemperatureProtectionFacilities.class);
        condition.createCriteria() .andEqualTo("id", recordRequest.getId())
                .andEqualTo("temperatureProtectionFacilitiesNo",recordRequest.getTemperatureProtectionFacilitiesNo());
        if (recordRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordRequest.getVerificationResult()+"%");
        }
        if (recordRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordRequest.getStatus());
        }
        return this.recordMapper.selectByCondition(condition);
    }

    @Override
    public PageResult<RecordTemperatureProtectionFacilities> queryListPage(RecordTemperatureProtectionFacilitiesRequest recordRequest, Integer pageNum, Integer pageSize) {
        Condition condition = new Condition(RecordTemperatureProtectionFacilities.class);
        condition.createCriteria() .andEqualTo("id", recordRequest.getId())
                .andEqualTo("temperatureProtectionFacilitiesNo",recordRequest.getTemperatureProtectionFacilitiesNo());
        if (recordRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordRequest.getVerificationResult()+"%");
        }
        if (recordRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordRequest.getStatus());
        }
        PageHelper.startPage(pageNum, pageSize);
        List<RecordTemperatureProtectionFacilities> dataList = this.recordMapper.selectByCondition(condition);
        PageResult<RecordTemperatureProtectionFacilities> pageList = new  PageResult<RecordTemperatureProtectionFacilities>();
        pageList.setTotal(dataList.size());
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public RecordTemperatureProtectionFacilities add(RecordTemperatureProtectionFacilities record) {
            this.recordMapper.insertUseGeneratedKeys(record);
            return record;
    }

    @Override
    public RecordTemperatureProtectionFacilities delete(Long id) {
            this.recordMapper.deleteByPrimaryKey(id);
            RecordTemperatureProtectionFacilities record = new RecordTemperatureProtectionFacilities();
            record.setId(id);
            return  record;
    }

    @Override
    public RecordTemperatureProtectionFacilities update(RecordTemperatureProtectionFacilities record) {
            this.recordMapper.updateByPrimaryKeySelective(record);
            return record;

    }
}
