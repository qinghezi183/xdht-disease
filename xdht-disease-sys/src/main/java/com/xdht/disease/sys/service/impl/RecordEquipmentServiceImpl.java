package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.RecordEquipmentMapper;
import com.xdht.disease.sys.model.RecordEquipment;
import com.xdht.disease.sys.service.RecordEquipmentService;
import com.xdht.disease.sys.vo.request.RecordEquipmentRequest;
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
public class RecordEquipmentServiceImpl extends AbstractService<RecordEquipment> implements RecordEquipmentService{

    @Autowired
    private RecordEquipmentMapper recordEquipmentMapper;

    @Override
    public List<RecordEquipment> queryList(RecordEquipmentRequest recordEquipmentRequest) {
        Condition condition = new Condition(RecordEquipment.class);
        condition.createCriteria() .andEqualTo("id", recordEquipmentRequest.getId())
                .andEqualTo("equipmentNo",recordEquipmentRequest.getEquipmentNo());
        if (recordEquipmentRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordEquipmentRequest.getVerificationResult()+"%");
        }
        if (recordEquipmentRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordEquipmentRequest.getStatus());
        }
        return this.recordEquipmentMapper.selectByCondition(condition);
    }

    @Override
    public PageResult<RecordEquipment> queryListPage(RecordEquipmentRequest recordEquipmentRequest, Integer pageNum, Integer pageSize) {
        Condition condition = new Condition(RecordEquipment.class);
        condition.createCriteria() .andEqualTo("id", recordEquipmentRequest.getId())
                .andEqualTo("equipmentNo",recordEquipmentRequest.getEquipmentNo());
        if (recordEquipmentRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordEquipmentRequest.getVerificationResult()+"%");
        }
        if (recordEquipmentRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordEquipmentRequest.getStatus());
        }
        PageHelper.startPage(pageNum, pageSize);
        List<RecordEquipment> dataList = this.recordEquipmentMapper.selectByCondition(condition);
        PageResult<RecordEquipment> pageList = new  PageResult<RecordEquipment>();
        pageList.setTotal(dataList.size());
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public RecordEquipment add(RecordEquipment recordEquipment) {
            this.recordEquipmentMapper.insertUseGeneratedKeys(recordEquipment);
            return recordEquipment;
    }

    @Override
    public RecordEquipment delete(Long id) {

        this.recordEquipmentMapper.deleteByPrimaryKey(id);
        RecordEquipment recordEquipment = new RecordEquipment();
        recordEquipment.setId(id);
        return recordEquipment;
    }

    @Override
    public RecordEquipment update(RecordEquipment recordEquipment) {
            this.recordEquipmentMapper.updateByPrimaryKeySelective(recordEquipment);
            return recordEquipment;
    }
}
