package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.RecordInformingFacilitiesMapper;
import com.xdht.disease.sys.model.RecordInformingFacilities;
import com.xdht.disease.sys.service.RecordInformingFacilitiesService;
import com.xdht.disease.sys.vo.request.RecordInformingFacilitiesRequest;
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
public class RecordInformingFacilitiesServiceImpl extends AbstractService<RecordInformingFacilities> implements RecordInformingFacilitiesService{

    @Autowired
    private RecordInformingFacilitiesMapper recordMapper;

    @Override
    public List<RecordInformingFacilities> queryList(RecordInformingFacilitiesRequest recordRequest) {
        Condition condition = new Condition(RecordInformingFacilities.class);
        condition.createCriteria() .andEqualTo("id", recordRequest.getId())
                .andEqualTo("informingFacilitiesNo",recordRequest.getInformingFacilitiesNo());
        if (recordRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordRequest.getVerificationResult()+"%");
        }
        if (recordRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordRequest.getStatus());
        }
        return this.recordMapper.selectByCondition(condition);
    }

    @Override
    public PageResult<RecordInformingFacilities> queryListPage(RecordInformingFacilitiesRequest recordRequest, Integer pageNum, Integer pageSize) {
        Condition condition = new Condition(RecordInformingFacilities.class);
        condition.createCriteria() .andEqualTo("id", recordRequest.getId())
                .andEqualTo("informingFacilitiesNo",recordRequest.getInformingFacilitiesNo());
        if (recordRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordRequest.getVerificationResult()+"%");
        }
        if (recordRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordRequest.getStatus());
        }
        PageHelper.startPage(pageNum, pageSize);
        List<RecordInformingFacilities> dataList = this.recordMapper.selectByCondition(condition);
        PageResult<RecordInformingFacilities> pageList = new  PageResult<RecordInformingFacilities>();
        pageList.setTotal(dataList.size());
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public RecordInformingFacilities add(RecordInformingFacilities recordInformingFacilities) {
            this.recordMapper.insertUseGeneratedKeys(recordInformingFacilities);
            return recordInformingFacilities;
    }

    @Override
    public RecordInformingFacilities delete(Long id) {
            this.recordMapper.deleteByPrimaryKey(id);
            RecordInformingFacilities recordInformingFacilities = new RecordInformingFacilities();
            recordInformingFacilities.setId(id);
            return recordInformingFacilities;
    }

    @Override
    public RecordInformingFacilities update(RecordInformingFacilities recordInformingFacilities) {
            this.recordMapper.updateByPrimaryKeySelective(recordInformingFacilities);
            return recordInformingFacilities;
    }
}
