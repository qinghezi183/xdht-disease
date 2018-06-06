package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.RecordTemperatureProtectionFacilitiesDataMapper;
import com.xdht.disease.sys.model.RecordTemperatureProtectionFacilitiesData;
import com.xdht.disease.sys.service.RecordTemperatureProtectionFacilitiesDataService;
import com.xdht.disease.sys.vo.request.RecordTemperatureProtectionFacilitiesDataRequest;
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
public class RecordTemperatureProtectionFacilitiesDataServiceImpl extends AbstractService<RecordTemperatureProtectionFacilitiesData> implements RecordTemperatureProtectionFacilitiesDataService{

    @Autowired
    private RecordTemperatureProtectionFacilitiesDataMapper recordDataMapper;

        @Override
        public List<RecordTemperatureProtectionFacilitiesData> queryList(RecordTemperatureProtectionFacilitiesDataRequest recordDataRequest) {
            Condition condition =  new Condition(RecordTemperatureProtectionFacilitiesData.class);
            condition.createCriteria().andEqualTo("id",recordDataRequest.getId())
                    .andEqualTo("companyOfficeId",recordDataRequest.getCompanyOfficeId())
                    .andEqualTo("postId",recordDataRequest.getPostId());
            if (recordDataRequest.getWorkPlace() != null){
                condition.getOredCriteria().get(0).andLike("workPlace","%"+recordDataRequest.getWorkPlace()+"%");
            }
            if (recordDataRequest.getTemperatureProtectionFacilities() != null){
                condition.getOredCriteria().get(0).andLike("temperatureProtectionFacilities","%"+recordDataRequest.getTemperatureProtectionFacilities()+"%");
            }
            return this.recordDataMapper.selectByCondition(condition);
        }

        @Override
        public PageResult<RecordTemperatureProtectionFacilitiesData> queryListPage(RecordTemperatureProtectionFacilitiesDataRequest recordDataRequest, Integer pageNum, Integer pageSize) {
            Condition condition =  new Condition(RecordTemperatureProtectionFacilitiesData.class);
            condition.createCriteria().andEqualTo("id",recordDataRequest.getId())
                    .andEqualTo("companyOfficeId",recordDataRequest.getCompanyOfficeId())
                    .andEqualTo("postId",recordDataRequest.getPostId());
            if (recordDataRequest.getWorkPlace() != null){
                condition.getOredCriteria().get(0).andLike("workPlace","%"+recordDataRequest.getWorkPlace()+"%");
            }
            if (recordDataRequest.getTemperatureProtectionFacilities() != null){
                condition.getOredCriteria().get(0).andLike("temperatureProtectionFacilities","%"+recordDataRequest.getTemperatureProtectionFacilities()+"%");
            }
            PageHelper.startPage(pageNum, pageSize);
            List<RecordTemperatureProtectionFacilitiesData> dataList = this.recordDataMapper.selectByCondition(condition);
            PageResult<RecordTemperatureProtectionFacilitiesData> pageList = new  PageResult<RecordTemperatureProtectionFacilitiesData>();
            pageList.setTotal(dataList.size());
            pageList.setDataList(dataList);
            return pageList;
        }

        @Override
        public RecordTemperatureProtectionFacilitiesData add(RecordTemperatureProtectionFacilitiesData recordData) {
                this.recordDataMapper.insertUseGeneratedKeys(recordData);
                return recordData;
        }

        @Override
        public RecordTemperatureProtectionFacilitiesData delete(Long id) {
                this.recordDataMapper.deleteByPrimaryKey(id);
                RecordTemperatureProtectionFacilitiesData recordData = new RecordTemperatureProtectionFacilitiesData();
                recordData.setId(id);
                return recordData;
        }

        @Override
        public RecordTemperatureProtectionFacilitiesData update(RecordTemperatureProtectionFacilitiesData recordData) {
                this.recordDataMapper.updateByPrimaryKeySelective(recordData);
                return recordData;
        }

}

