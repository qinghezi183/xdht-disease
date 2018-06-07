package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.RecordAntiNoiseFacilitiesDataMapper;
import com.xdht.disease.sys.model.RecordAntiNoiseFacilitiesData;
import com.xdht.disease.sys.service.RecordAntiNoiseFacilitiesDataService;
import com.xdht.disease.sys.vo.request.RecordAntiNoiseFacilitiesDataRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by lzf on 2018/06/04.
 */
@Service
@Transactional
public class RecordAntiNoiseFacilitiesDataServiceImpl extends AbstractService<RecordAntiNoiseFacilitiesData> implements RecordAntiNoiseFacilitiesDataService{

    @Autowired
    private RecordAntiNoiseFacilitiesDataMapper recordAntiNoiseFacilitiesDataMapper;

    @Override
    public List<RecordAntiNoiseFacilitiesData> queryList(RecordAntiNoiseFacilitiesDataRequest recordAntiNoiseFacilitiesDataRequest) {
        Condition condition =  new Condition(RecordAntiNoiseFacilitiesData.class);
        condition.createCriteria() .andEqualTo("id", recordAntiNoiseFacilitiesDataRequest.getId())
                .andEqualTo("companyOfficeId",recordAntiNoiseFacilitiesDataRequest.getCompanyOfficeId())
                .andEqualTo("postId",recordAntiNoiseFacilitiesDataRequest.getPostId());
        if (recordAntiNoiseFacilitiesDataRequest.getWorkPlace() != null) {
            condition.getOredCriteria().get(0).andLike("workPlace","%"+recordAntiNoiseFacilitiesDataRequest.getWorkPlace()+"%");
        }
        if (recordAntiNoiseFacilitiesDataRequest.getNoiseSource() != null){
            condition.getOredCriteria().get(0).andLike("noiseSource","%"+recordAntiNoiseFacilitiesDataRequest.getNoiseSource()+"%");
        }
        if (recordAntiNoiseFacilitiesDataRequest.getNoiseProtectionFacilities() != null){
            condition.getOredCriteria().get(0).andLike("noiseProtectionFacilities","%"+recordAntiNoiseFacilitiesDataRequest.getNoiseProtectionFacilities()+"%");
        }
        if (recordAntiNoiseFacilitiesDataRequest.getOperationAndMaintenance() != null){
            condition.getOredCriteria().get(0).andLike("operationAndMaintenance","%"+recordAntiNoiseFacilitiesDataRequest.getOperationAndMaintenance()+"%");
        }
        return this.recordAntiNoiseFacilitiesDataMapper.selectByCondition(condition);
    }

    @Override
    public PageResult<RecordAntiNoiseFacilitiesData> queryListPage(RecordAntiNoiseFacilitiesDataRequest recordAntiNoiseFacilitiesDataRequest, Integer pageNum, Integer pageSize) {
        Condition condition =  new Condition(RecordAntiNoiseFacilitiesData.class);
        condition.createCriteria() .andEqualTo("id", recordAntiNoiseFacilitiesDataRequest.getId())
                .andEqualTo("companyOfficeId",recordAntiNoiseFacilitiesDataRequest.getCompanyOfficeId())
                .andEqualTo("postId",recordAntiNoiseFacilitiesDataRequest.getPostId());
        if (recordAntiNoiseFacilitiesDataRequest.getWorkPlace() != null) {
            condition.getOredCriteria().get(0).andLike("workPlace","%"+recordAntiNoiseFacilitiesDataRequest.getWorkPlace()+"%");
        }
        if (recordAntiNoiseFacilitiesDataRequest.getNoiseSource() != null){
            condition.getOredCriteria().get(0).andLike("noiseSource","%"+recordAntiNoiseFacilitiesDataRequest.getNoiseSource()+"%");
        }
        if (recordAntiNoiseFacilitiesDataRequest.getNoiseProtectionFacilities() != null){
            condition.getOredCriteria().get(0).andLike("noiseProtectionFacilities","%"+recordAntiNoiseFacilitiesDataRequest.getNoiseProtectionFacilities()+"%");
        }
        if (recordAntiNoiseFacilitiesDataRequest.getOperationAndMaintenance() != null){
            condition.getOredCriteria().get(0).andLike("operationAndMaintenance","%"+recordAntiNoiseFacilitiesDataRequest.getOperationAndMaintenance()+"%");
        }
        PageHelper.startPage(pageNum, pageSize);
        List<RecordAntiNoiseFacilitiesData> dataList = this.recordAntiNoiseFacilitiesDataMapper.selectByCondition(condition);
        PageResult<RecordAntiNoiseFacilitiesData> pageList = new  PageResult<RecordAntiNoiseFacilitiesData>();
        pageList.setTotal(dataList.size());
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public RecordAntiNoiseFacilitiesData add(RecordAntiNoiseFacilitiesData recordAntiNoiseFacilitiesData) {
            this.recordAntiNoiseFacilitiesDataMapper.insertUseGeneratedKeys(recordAntiNoiseFacilitiesData);
            return  recordAntiNoiseFacilitiesData;
    }

    @Override
    public RecordAntiNoiseFacilitiesData delete(Long id) {

            this.recordAntiNoiseFacilitiesDataMapper.deleteByPrimaryKey(id);
            RecordAntiNoiseFacilitiesData recordAntiNoiseFacilitiesData = new RecordAntiNoiseFacilitiesData();
            recordAntiNoiseFacilitiesData.setId(id);
            return recordAntiNoiseFacilitiesData;
    }

    @Override
    public RecordAntiNoiseFacilitiesData update(RecordAntiNoiseFacilitiesData recordAntiNoiseFacilitiesData) {
        this.recordAntiNoiseFacilitiesDataMapper.updateByPrimaryKeySelective(recordAntiNoiseFacilitiesData);
        return recordAntiNoiseFacilitiesData;
    }
}
