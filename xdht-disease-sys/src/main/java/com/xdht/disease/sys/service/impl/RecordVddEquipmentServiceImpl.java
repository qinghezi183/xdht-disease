package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.RecordVddEquipmentMapper;
import com.xdht.disease.sys.model.RecordVddEquipment;
import com.xdht.disease.sys.service.RecordVddEquipmentService;
import com.xdht.disease.sys.vo.request.RecordVddEquipmentRequest;
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
public class RecordVddEquipmentServiceImpl extends AbstractService<RecordVddEquipment> implements RecordVddEquipmentService{

    @Autowired
    private RecordVddEquipmentMapper recordVddEquipmentMapper;

    @Override
    public List<RecordVddEquipment> queryList(RecordVddEquipmentRequest recordVddEquipmentRequest) {
        Condition condition = new Condition(RecordVddEquipment.class);
        condition.createCriteria() .andEqualTo("id", recordVddEquipmentRequest.getId())
                .andEqualTo("vddEquipmentNo",recordVddEquipmentRequest.getVddEquipmentNo());
        if (recordVddEquipmentRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordVddEquipmentRequest.getVerificationResult()+"%");
        }
        if (recordVddEquipmentRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordVddEquipmentRequest.getStatus());
        }
        return this.recordVddEquipmentMapper.selectByCondition(condition);
    }

    @Override
    public PageResult<RecordVddEquipment> queryListPage(RecordVddEquipmentRequest recordVddEquipmentRequest, Integer pageNum, Integer pageSize) {
        Condition condition = new Condition(RecordVddEquipment.class);
        condition.createCriteria() .andEqualTo("id", recordVddEquipmentRequest.getId())
                .andEqualTo("vddEquipmentNo",recordVddEquipmentRequest.getVddEquipmentNo());
        if (recordVddEquipmentRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordVddEquipmentRequest.getVerificationResult()+"%");
        }
        if (recordVddEquipmentRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordVddEquipmentRequest.getStatus());
        }
        PageHelper.startPage(pageNum, pageSize);
        List<RecordVddEquipment> dataList = this.recordVddEquipmentMapper.selectByCondition(condition);
        PageResult<RecordVddEquipment> pageList = new  PageResult<RecordVddEquipment>();
        pageList.setTotal(dataList.size());
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public RecordVddEquipment add(RecordVddEquipment recordVddEquipment) {
            this.recordVddEquipmentMapper.insertUseGeneratedKeys(recordVddEquipment);
            return recordVddEquipment;
    }

    @Override
    public RecordVddEquipment delete(Long id) {
            this.recordVddEquipmentMapper.deleteByPrimaryKey(id);
            RecordVddEquipment recordVddEquipment = new RecordVddEquipment();
            recordVddEquipment.setId(id);
            return recordVddEquipment;
    }

    @Override
    public RecordVddEquipment update(RecordVddEquipment recordVddEquipment) {
        this.recordVddEquipmentMapper.updateByPrimaryKeySelective(recordVddEquipment);
        return recordVddEquipment;
    }
}
