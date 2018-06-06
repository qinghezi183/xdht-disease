package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.RecordEquipmentDataMapper;
import com.xdht.disease.sys.model.RecordEquipmentData;
import com.xdht.disease.sys.service.RecordEquipmentDataService;
import com.xdht.disease.sys.vo.request.RecordEquipmentDataRequest;
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
public class RecordEquipmentDataServiceImpl extends AbstractService<RecordEquipmentData> implements RecordEquipmentDataService{

    @Autowired
    private RecordEquipmentDataMapper recordEquipmentDataMapper;

    @Override
    public List<RecordEquipmentData> queryList(RecordEquipmentDataRequest recordEquipmentDataRequest) {
        Condition condition = new Condition(RecordEquipmentData.class);
        condition.createCriteria() .andEqualTo("id", recordEquipmentDataRequest.getId())
                .andEqualTo("officdId",recordEquipmentDataRequest.getOfficdId())
                .andEqualTo("epuipmentNumber",recordEquipmentDataRequest.getEpuipmentNumber());
        if (recordEquipmentDataRequest.getEpuipmentNumber() != null) {
            condition.getOredCriteria().get(0).andLike("equipmentName","%"+recordEquipmentDataRequest.getEquipmentName()+"%");
        }
        return this.recordEquipmentDataMapper.selectByCondition(condition);
    }

    @Override
    public PageResult<RecordEquipmentData> queryListPage(RecordEquipmentDataRequest recordEquipmentDataRequest, Integer pageNum, Integer pageSize) {
        Condition condition = new Condition(RecordEquipmentData.class);
        condition.createCriteria() .andEqualTo("id", recordEquipmentDataRequest.getId())
                .andEqualTo("officdId",recordEquipmentDataRequest.getOfficdId())
                .andEqualTo("epuipmentNumber",recordEquipmentDataRequest.getEpuipmentNumber());
        if (recordEquipmentDataRequest.getEpuipmentNumber() != null) {
            condition.getOredCriteria().get(0).andLike("equipmentName","%"+recordEquipmentDataRequest.getEquipmentName()+"%");
        }
        PageHelper.startPage(pageNum, pageSize);
        List<RecordEquipmentData> dataList = this.recordEquipmentDataMapper.selectByCondition(condition);
        PageResult<RecordEquipmentData> pageList = new  PageResult<RecordEquipmentData>();
        pageList.setTotal(dataList.size());
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public RecordEquipmentData add(RecordEquipmentData recordEquipmentData) {
            this.recordEquipmentDataMapper.insertUseGeneratedKeys(recordEquipmentData);
            return  recordEquipmentData;
    }

    @Override
    public RecordEquipmentData delete(Long id) {
        this.recordEquipmentDataMapper.deleteByPrimaryKey(id);
        RecordEquipmentData recordEquipmentData = new RecordEquipmentData();
        recordEquipmentData.setId(id);
        return  recordEquipmentData;
    }

    @Override
    public RecordEquipmentData update(RecordEquipmentData recordEquipmentData) {
        this.recordEquipmentDataMapper.updateByPrimaryKeySelective(recordEquipmentData);
        return  recordEquipmentData;
    }
}
