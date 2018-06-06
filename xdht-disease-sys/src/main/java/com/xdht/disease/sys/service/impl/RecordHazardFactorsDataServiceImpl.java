package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.RecordHazardFactorsDataMapper;
import com.xdht.disease.sys.model.RecordHazardFactorsData;
import com.xdht.disease.sys.service.RecordHazardFactorsDataService;
import com.xdht.disease.sys.vo.request.RecordHazardFactorsDataRequest;
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
public class RecordHazardFactorsDataServiceImpl extends AbstractService<RecordHazardFactorsData> implements RecordHazardFactorsDataService{

    @Autowired
    private RecordHazardFactorsDataMapper recordHazardFactorsDataMapper;

    @Override
    public List<RecordHazardFactorsData> queryList(RecordHazardFactorsDataRequest recordHazardFactorsDataRequest) {
        Condition condition = new Condition(RecordHazardFactorsData.class);
        condition.createCriteria() .andEqualTo("id", recordHazardFactorsDataRequest.getId())
                .andEqualTo("officeId",recordHazardFactorsDataRequest.getOfficeId());
        if (recordHazardFactorsDataRequest.getHazardFactors() != null) {
            condition.getOredCriteria().get(0).andLike("hazardFactors","%"+recordHazardFactorsDataRequest.getHazardFactors()+"%");
        }
        return this.recordHazardFactorsDataMapper.selectByCondition(condition);
    }

    @Override
    public PageResult<RecordHazardFactorsData> queryListPage(RecordHazardFactorsDataRequest recordHazardFactorsDataRequest, Integer pageNum, Integer pageSize) {

        Condition condition = new Condition(RecordHazardFactorsData.class);
        condition.createCriteria() .andEqualTo("id", recordHazardFactorsDataRequest.getId())
                .andEqualTo("officeId",recordHazardFactorsDataRequest.getOfficeId());
        if (recordHazardFactorsDataRequest.getHazardFactors() != null) {
            condition.getOredCriteria().get(0).andLike("hazardFactors","%"+recordHazardFactorsDataRequest.getHazardFactors()+"%");
        }
        PageHelper.startPage(pageNum, pageSize);
        List<RecordHazardFactorsData> dataList = this.recordHazardFactorsDataMapper.selectByCondition(condition);
        PageResult<RecordHazardFactorsData> pageList = new  PageResult<RecordHazardFactorsData>();
        pageList.setTotal(dataList.size());
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public RecordHazardFactorsData add(RecordHazardFactorsData recordHazardFactorsData) {
            this.recordHazardFactorsDataMapper.insertUseGeneratedKeys(recordHazardFactorsData);
            return recordHazardFactorsData;
    }

    @Override
    public RecordHazardFactorsData delete(Long id) {
        this.recordHazardFactorsDataMapper.deleteByPrimaryKey(id);
        RecordHazardFactorsData recordHazardFactorsData = new RecordHazardFactorsData();
        return recordHazardFactorsData;
    }

    @Override
    public RecordHazardFactorsData update(RecordHazardFactorsData recordHazardFactorsData) {
        this.recordHazardFactorsDataMapper.updateByPrimaryKeySelective(recordHazardFactorsData);
        return recordHazardFactorsData;
    }
}
