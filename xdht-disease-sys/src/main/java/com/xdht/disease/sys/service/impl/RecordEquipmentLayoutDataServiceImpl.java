package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.RecordEquipmentLayoutDataMapper;
import com.xdht.disease.sys.model.RecordEquipmentLayoutData;
import com.xdht.disease.sys.service.RecordEquipmentLayoutDataService;
import com.xdht.disease.sys.vo.request.RecordEquipmentLayoutDataRequest;
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
public class RecordEquipmentLayoutDataServiceImpl extends AbstractService<RecordEquipmentLayoutData> implements RecordEquipmentLayoutDataService{

    @Autowired
    private RecordEquipmentLayoutDataMapper recordEquipmentLayoutDataMapper;

    @Override
    public List<RecordEquipmentLayoutData> queryList(RecordEquipmentLayoutDataRequest recordEquipmentLayoutDataRequest) {
        Condition condition = new Condition(RecordEquipmentLayoutData.class);
        condition.createCriteria() .andEqualTo("id", recordEquipmentLayoutDataRequest.getId());
        if (recordEquipmentLayoutDataRequest.getHazardFactors() != null) {
            condition.getOredCriteria().get(0).andLike("hazardFactors","%"+recordEquipmentLayoutDataRequest.getHazardFactors()+"%");
        }
        return this.recordEquipmentLayoutDataMapper.selectByCondition(condition);
    }

    @Override
    public PageResult<RecordEquipmentLayoutData> queryListPage(RecordEquipmentLayoutDataRequest recordEquipmentLayoutDataRequest, Integer pageNum, Integer pageSize) {
        Condition condition = new Condition(RecordEquipmentLayoutData.class);
        condition.createCriteria() .andEqualTo("id", recordEquipmentLayoutDataRequest.getId());
        if (recordEquipmentLayoutDataRequest.getHazardFactors() != null) {
            condition.getOredCriteria().get(0).andLike("hazardFactors","%"+recordEquipmentLayoutDataRequest.getHazardFactors()+"%");
        }
        PageHelper.startPage(pageNum, pageSize);
        List<RecordEquipmentLayoutData> dataList = this.recordEquipmentLayoutDataMapper.selectByCondition(condition);
        PageResult<RecordEquipmentLayoutData> pageList = new  PageResult<RecordEquipmentLayoutData>();
        pageList.setTotal(dataList.size());
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public RecordEquipmentLayoutData add(RecordEquipmentLayoutData recordEquipmentLayoutData) {
            this.recordEquipmentLayoutDataMapper.insertUseGeneratedKeys(recordEquipmentLayoutData);
            return recordEquipmentLayoutData;
    }

    @Override
    public RecordEquipmentLayoutData delete(Long id) {
            this.recordEquipmentLayoutDataMapper.deleteByPrimaryKey(id);
            RecordEquipmentLayoutData recordEquipmentLayoutData = new RecordEquipmentLayoutData();
            recordEquipmentLayoutData.setId(id);
            return recordEquipmentLayoutData;
    }

    @Override
    public RecordEquipmentLayoutData update(RecordEquipmentLayoutData recordEquipmentLayoutData) {
            this.recordEquipmentLayoutDataMapper.updateByPrimaryKeySelective(recordEquipmentLayoutData);
            return recordEquipmentLayoutData;
    }
}
