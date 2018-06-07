package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.RecordIndividualProtectiveEquipmentMapper;
import com.xdht.disease.sys.model.RecordIndividualProtectiveEquipment;
import com.xdht.disease.sys.service.RecordIndividualProtectiveEquipmentService;
import com.xdht.disease.sys.vo.request.RecordIndividualProtectiveEquipmentRequest;
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
public class RecordIndividualProtectiveEquipmentServiceImpl extends AbstractService<RecordIndividualProtectiveEquipment> implements RecordIndividualProtectiveEquipmentService{

    @Autowired
    private RecordIndividualProtectiveEquipmentMapper recordMapper;

    @Override
    public List<RecordIndividualProtectiveEquipment> queryList(RecordIndividualProtectiveEquipmentRequest recordRequest) {
        Condition condition = new Condition(RecordIndividualProtectiveEquipment.class);
        condition.createCriteria() .andEqualTo("id", recordRequest.getId())
                .andEqualTo("individualProtectiveEquipmentNo",recordRequest.getIndividualProtectiveEquipmentNo());
        if (recordRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordRequest.getVerificationResult()+"%");
        }
        if (recordRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordRequest.getStatus());
        }
        return this.recordMapper.selectByCondition(condition);
    }

    @Override
    public PageResult<RecordIndividualProtectiveEquipment> queryListPage(RecordIndividualProtectiveEquipmentRequest recordRequest, Integer pageNum, Integer pageSize) {

        Condition condition = new Condition(RecordIndividualProtectiveEquipment.class);
        condition.createCriteria() .andEqualTo("id", recordRequest.getId())
                .andEqualTo("individualProtectiveEquipmentNo",recordRequest.getIndividualProtectiveEquipmentNo());
        if (recordRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordRequest.getVerificationResult()+"%");
        }
        if (recordRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordRequest.getStatus());
        }
        PageHelper.startPage(pageNum, pageSize);
        List<RecordIndividualProtectiveEquipment> dataList = this.recordMapper.selectByCondition(condition);
        PageResult<RecordIndividualProtectiveEquipment> pageList = new  PageResult<RecordIndividualProtectiveEquipment>();
        pageList.setTotal(dataList.size());
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public RecordIndividualProtectiveEquipment add(RecordIndividualProtectiveEquipment record) {
        this.recordMapper.insertUseGeneratedKeys(record);
        return  record;
    }

    @Override
    public RecordIndividualProtectiveEquipment delete(Long id) {
            this.recordMapper.deleteByPrimaryKey(id);
            RecordIndividualProtectiveEquipment recordIndividualProtectiveEquipment = new RecordIndividualProtectiveEquipment();
            recordIndividualProtectiveEquipment.setId(id);
            return recordIndividualProtectiveEquipment;
    }

    @Override
    public RecordIndividualProtectiveEquipment update(RecordIndividualProtectiveEquipment record) {
            this.recordMapper.updateByPrimaryKeySelective(record);
            return record;
    }
}
