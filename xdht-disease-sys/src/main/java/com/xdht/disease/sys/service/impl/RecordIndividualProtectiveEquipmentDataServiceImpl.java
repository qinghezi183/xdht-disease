package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.RecordIndividualProtectiveEquipmentDataMapper;
import com.xdht.disease.sys.model.RecordIndividualProtectiveEquipmentData;
import com.xdht.disease.sys.service.RecordIndividualProtectiveEquipmentDataService;
import com.xdht.disease.sys.vo.request.RecordIndividualProtectiveEquipmentDataRequest;
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
public class RecordIndividualProtectiveEquipmentDataServiceImpl extends AbstractService<RecordIndividualProtectiveEquipmentData> implements RecordIndividualProtectiveEquipmentDataService{

    @Autowired
    private RecordIndividualProtectiveEquipmentDataMapper recordDataMapper;

    @Override
    public List<RecordIndividualProtectiveEquipmentData> queryList(RecordIndividualProtectiveEquipmentDataRequest recordDataRequest) {
        Condition condition = new Condition(RecordIndividualProtectiveEquipmentData.class);
        condition.createCriteria() .andEqualTo("id", recordDataRequest.getId())
                .andEqualTo("companyOfficeId",recordDataRequest.getCompanyOfficeId())
                .andEqualTo("postId",recordDataRequest.getPostId());
        if (recordDataRequest.getHazardFactors() != null) {
            condition.getOredCriteria().get(0).andLike("hazardFactors","%"+recordDataRequest.getHazardFactors()+"%");
        }
        if (recordDataRequest.getProtectiveEquipment() != null) {
            condition.getOredCriteria().get(0).andLike("protectiveEquipment","%"+recordDataRequest.getProtectiveEquipment()+"%");
        }
        return this.recordDataMapper.selectByCondition(condition);
    }

    @Override
    public PageResult<RecordIndividualProtectiveEquipmentData> queryListPage(RecordIndividualProtectiveEquipmentDataRequest recordDataRequest, Integer pageNum, Integer pageSize) {
        Condition condition = new Condition(RecordIndividualProtectiveEquipmentData.class);
        condition.createCriteria() .andEqualTo("id", recordDataRequest.getId())
                .andEqualTo("companyOfficeId",recordDataRequest.getCompanyOfficeId())
                .andEqualTo("postId",recordDataRequest.getPostId());
        if (recordDataRequest.getHazardFactors() != null) {
            condition.getOredCriteria().get(0).andLike("hazardFactors","%"+recordDataRequest.getHazardFactors()+"%");
        }
        if (recordDataRequest.getProtectiveEquipment() != null) {
            condition.getOredCriteria().get(0).andLike("protectiveEquipment","%"+recordDataRequest.getProtectiveEquipment()+"%");
        }
        PageHelper.startPage(pageNum, pageSize);
        List<RecordIndividualProtectiveEquipmentData> dataList = this.recordDataMapper.selectByCondition(condition);
        PageResult<RecordIndividualProtectiveEquipmentData> pageList = new  PageResult<RecordIndividualProtectiveEquipmentData>();
        pageList.setTotal(dataList.size());
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public RecordIndividualProtectiveEquipmentData add(RecordIndividualProtectiveEquipmentData recordData) {
            this.recordDataMapper.insertUseGeneratedKeys(recordData);
            return  recordData;
    }

    @Override
    public RecordIndividualProtectiveEquipmentData delete(Long id) {
            this.recordDataMapper.deleteByPrimaryKey(id);
            RecordIndividualProtectiveEquipmentData recordData = new RecordIndividualProtectiveEquipmentData();
            recordData.setId(id);
            return recordData;
    }

    @Override
    public RecordIndividualProtectiveEquipmentData update(RecordIndividualProtectiveEquipmentData recordData) {
            this.recordDataMapper.updateByPrimaryKeySelective(recordData);
            return  recordData;
    }
}
