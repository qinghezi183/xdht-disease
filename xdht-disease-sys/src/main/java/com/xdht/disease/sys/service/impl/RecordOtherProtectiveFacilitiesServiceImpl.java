package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.RecordOtherProtectiveFacilitiesMapper;
import com.xdht.disease.sys.model.RecordOtherProtectiveFacilities;
import com.xdht.disease.sys.service.RecordOtherProtectiveFacilitiesService;
import com.xdht.disease.sys.vo.request.RecordOtherProtectiveFacilitiesRequest;
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
public class RecordOtherProtectiveFacilitiesServiceImpl extends AbstractService<RecordOtherProtectiveFacilities> implements RecordOtherProtectiveFacilitiesService{

    @Autowired
    private RecordOtherProtectiveFacilitiesMapper recordMapper;

    @Override
    public List<RecordOtherProtectiveFacilities> queryList(RecordOtherProtectiveFacilitiesRequest recordRequest) {
        Condition condition = new Condition(RecordOtherProtectiveFacilities.class);
        condition.createCriteria() .andEqualTo("id", recordRequest.getId())
                .andEqualTo("otherProtectiveFacilitiesNo",recordRequest.getOtherProtectiveFacilitiesNo());
        if (recordRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordRequest.getVerificationResult()+"%");
        }
        if (recordRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordRequest.getStatus());
        }
        return this.recordMapper.selectByCondition(condition);
    }

    @Override
    public PageResult<RecordOtherProtectiveFacilities> queryListPage(RecordOtherProtectiveFacilitiesRequest recordRequest, Integer pageNum, Integer pageSize) {
        Condition condition = new Condition(RecordOtherProtectiveFacilities.class);
        condition.createCriteria() .andEqualTo("id", recordRequest.getId())
                .andEqualTo("otherProtectiveFacilitiesNo",recordRequest.getOtherProtectiveFacilitiesNo());
        if (recordRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordRequest.getVerificationResult()+"%");
        }
        if (recordRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordRequest.getStatus());
        }
        PageHelper.startPage(pageNum, pageSize);
        List<RecordOtherProtectiveFacilities> dataList = this.recordMapper.selectByCondition(condition);
        PageResult<RecordOtherProtectiveFacilities> pageList = new  PageResult<RecordOtherProtectiveFacilities>();
        pageList.setTotal(dataList.size());
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public RecordOtherProtectiveFacilities add(RecordOtherProtectiveFacilities recordOtherProtectiveFacilities) {
            this.recordMapper.insertUseGeneratedKeys(recordOtherProtectiveFacilities);
            return recordOtherProtectiveFacilities;
    }

    @Override
    public RecordOtherProtectiveFacilities delete(Long id) {
        this.recordMapper.deleteByPrimaryKey(id);
        RecordOtherProtectiveFacilities recordOtherProtectiveFacilities = new RecordOtherProtectiveFacilities();
        recordOtherProtectiveFacilities.setId(id);
        return  recordOtherProtectiveFacilities;
    }

    @Override
    public RecordOtherProtectiveFacilities update(RecordOtherProtectiveFacilities recordOtherProtectiveFacilities) {
        this.recordMapper.updateByPrimaryKeySelective(recordOtherProtectiveFacilities);
        return  recordOtherProtectiveFacilities;
    }
}
