package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.RecordInformingFacilitiesDataMapper;
import com.xdht.disease.sys.model.RecordInformingFacilitiesData;
import com.xdht.disease.sys.service.RecordInformingFacilitiesDataService;
import com.xdht.disease.sys.vo.request.RecordInformingFacilitiesDataRequest;
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
public class RecordInformingFacilitiesDataServiceImpl extends AbstractService<RecordInformingFacilitiesData> implements RecordInformingFacilitiesDataService{

    @Autowired
    private RecordInformingFacilitiesDataMapper recordDataMapper;

    @Override
    public List<RecordInformingFacilitiesData> queryList(RecordInformingFacilitiesDataRequest recordDataRequest) {
        Condition condition = new Condition(RecordInformingFacilitiesData.class);
        condition.createCriteria() .andEqualTo("id", recordDataRequest.getId())
                .andEqualTo("companyOfficeId",recordDataRequest.getCompanyOfficeId());
        if (recordDataRequest.getHazardFactors() != null) {
            condition.getOredCriteria().get(0).andLike("hazardFactors","%"+recordDataRequest.getHazardFactors()+"%");
        }
        if (recordDataRequest.getSettingPlace() != null){
            condition.getOredCriteria().get(0).andEqualTo("settingPlace","%"+recordDataRequest.getSettingPlace()+"%");
        }
        return this.recordDataMapper.selectByCondition(condition);
    }

    @Override
    public PageResult<RecordInformingFacilitiesData> queryListPage(RecordInformingFacilitiesDataRequest recordDataRequest, Integer pageNum, Integer pageSize) {
        Condition condition = new Condition(RecordInformingFacilitiesData.class);
        condition.createCriteria() .andEqualTo("id", recordDataRequest.getId())
                .andEqualTo("companyOfficeId",recordDataRequest.getCompanyOfficeId());
        if (recordDataRequest.getHazardFactors() != null) {
            condition.getOredCriteria().get(0).andLike("hazardFactors","%"+recordDataRequest.getHazardFactors()+"%");
        }
        if (recordDataRequest.getSettingPlace() != null){
            condition.getOredCriteria().get(0).andEqualTo("settingPlace","%"+recordDataRequest.getSettingPlace()+"%");
        }
        PageHelper.startPage(pageNum, pageSize);
        List<RecordInformingFacilitiesData> dataList = this.recordDataMapper.selectByCondition(condition);
        PageResult<RecordInformingFacilitiesData> pageList = new  PageResult<RecordInformingFacilitiesData>();
        pageList.setTotal(dataList.size());
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public RecordInformingFacilitiesData add(RecordInformingFacilitiesData recordInformingFacilitiesData) {
        this.recordDataMapper.insertUseGeneratedKeys(recordInformingFacilitiesData);
        return recordInformingFacilitiesData;
    }

    @Override
    public RecordInformingFacilitiesData delete(Long id) {
        this.recordDataMapper.deleteByPrimaryKey(id);
        RecordInformingFacilitiesData recordInformingFacilitiesData = new RecordInformingFacilitiesData();
        recordInformingFacilitiesData.setId(id);
        return recordInformingFacilitiesData;
    }

    @Override
    public RecordInformingFacilitiesData update(RecordInformingFacilitiesData recordInformingFacilitiesData) {
        this.recordDataMapper.updateByPrimaryKeySelective(recordInformingFacilitiesData);
        return recordInformingFacilitiesData;
    }
}
