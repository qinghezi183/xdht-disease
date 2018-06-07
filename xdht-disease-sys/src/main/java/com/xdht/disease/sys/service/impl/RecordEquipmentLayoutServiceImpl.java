package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.RecordEquipmentLayoutMapper;
import com.xdht.disease.sys.model.RecordEquipmentLayout;
import com.xdht.disease.sys.service.RecordEquipmentLayoutService;
import com.xdht.disease.sys.vo.request.RecordEquipmentLayoutRequest;
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
public class RecordEquipmentLayoutServiceImpl extends AbstractService<RecordEquipmentLayout> implements RecordEquipmentLayoutService{

    @Autowired
    private RecordEquipmentLayoutMapper recordEquipmentLayoutMapper;

    @Override
    public List<RecordEquipmentLayout> queryList(RecordEquipmentLayoutRequest recordEquipmentLayoutRequest) {
        Condition condition = new Condition(RecordEquipmentLayout.class);
        condition.createCriteria() .andEqualTo("id", recordEquipmentLayoutRequest.getId())
                .andEqualTo("equipmentLayoutNo",recordEquipmentLayoutRequest.getEquipmentLayoutNo());
        if (recordEquipmentLayoutRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordEquipmentLayoutRequest.getVerificationResult()+"%");
        }
        if (recordEquipmentLayoutRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordEquipmentLayoutRequest.getStatus());
        }
        return this.recordEquipmentLayoutMapper.selectByCondition(condition);
    }

    @Override
    public PageResult<RecordEquipmentLayout> queryListPage(RecordEquipmentLayoutRequest recordEquipmentLayoutRequest, Integer pageNum, Integer pageSize) {
        Condition condition = new Condition(RecordEquipmentLayout.class);
        condition.createCriteria() .andEqualTo("id", recordEquipmentLayoutRequest.getId())
                .andEqualTo("equipmentLayoutNo",recordEquipmentLayoutRequest.getEquipmentLayoutNo());
        if (recordEquipmentLayoutRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordEquipmentLayoutRequest.getVerificationResult()+"%");
        }
        if (recordEquipmentLayoutRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordEquipmentLayoutRequest.getStatus());
        }
        PageHelper.startPage(pageNum, pageSize);
        List<RecordEquipmentLayout> dataList = this.recordEquipmentLayoutMapper.selectByCondition(condition);
        PageResult<RecordEquipmentLayout> pageList = new  PageResult<RecordEquipmentLayout>();
        pageList.setTotal(dataList.size());
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public RecordEquipmentLayout add(RecordEquipmentLayout recordEquipmentLayout) {
            this.recordEquipmentLayoutMapper.insertUseGeneratedKeys(recordEquipmentLayout);
            return recordEquipmentLayout;
    }

    @Override
    public RecordEquipmentLayout delete(Long id) {
            this.recordEquipmentLayoutMapper.deleteByPrimaryKey(id);
            RecordEquipmentLayout recordEquipmentLayout = new RecordEquipmentLayout();
            recordEquipmentLayout.setId(id);
            return recordEquipmentLayout;

    }

    @Override
    public RecordEquipmentLayout update(RecordEquipmentLayout recordEquipmentLayout) {
        this.recordEquipmentLayoutMapper.updateByPrimaryKeySelective(recordEquipmentLayout);
        return recordEquipmentLayout;
    }
}
