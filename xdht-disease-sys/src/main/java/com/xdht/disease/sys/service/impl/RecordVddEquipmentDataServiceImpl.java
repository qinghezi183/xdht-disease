package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.RecordVddEquipmentDataMapper;
import com.xdht.disease.sys.model.RecordVddEquipmentData;
import com.xdht.disease.sys.service.RecordVddEquipmentDataService;
import com.xdht.disease.sys.vo.request.RecordVddEquipmentDataRequest;
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
public class RecordVddEquipmentDataServiceImpl extends AbstractService<RecordVddEquipmentData> implements RecordVddEquipmentDataService{

    @Autowired
    private RecordVddEquipmentDataMapper recordVddEquipmentDataMapper;

    @Override
    public List<RecordVddEquipmentData> queryList(RecordVddEquipmentDataRequest recordDataRequest) {
        Condition condition =  new Condition(RecordVddEquipmentData.class);
        condition.createCriteria().andEqualTo("id",recordDataRequest.getId())
                .andEqualTo("officeId",recordDataRequest.getOfficeId())
                .andEqualTo("postId",recordDataRequest.getPostId());
        if (recordDataRequest.getWorkPlace() != null){
            condition.getOredCriteria().get(0).andLike("workPlace","%"+recordDataRequest.getWorkPlace()+"%");
        }
        if (recordDataRequest.getVddEquipmentName() != null){
            condition.getOredCriteria().get(0).andLike("vddEquipmentName","%"+recordDataRequest.getVddEquipmentName()+"%");
        }
        if (recordDataRequest.getPoisonOrDustName() != null){
            condition.getOredCriteria().get(0).andLike("poisonOrDustName","%"+recordDataRequest.getPoisonOrDustName()+"%");
        }
        return this.recordVddEquipmentDataMapper.selectByCondition(condition);
    }

    @Override
    public PageResult<RecordVddEquipmentData> queryListPage(RecordVddEquipmentDataRequest recordDataRequest, Integer pageNum, Integer pageSize) {
        Condition condition =  new Condition(RecordVddEquipmentData.class);
        condition.createCriteria().andEqualTo("id",recordDataRequest.getId())
                .andEqualTo("officeId",recordDataRequest.getOfficeId())
                .andEqualTo("postId",recordDataRequest.getPostId());
        if (recordDataRequest.getWorkPlace() != null){
            condition.getOredCriteria().get(0).andLike("workPlace","%"+recordDataRequest.getWorkPlace()+"%");
        }
        if (recordDataRequest.getVddEquipmentName() != null){
            condition.getOredCriteria().get(0).andLike("vddEquipmentName","%"+recordDataRequest.getVddEquipmentName()+"%");
        }
        if (recordDataRequest.getPoisonOrDustName() != null){
            condition.getOredCriteria().get(0).andLike("poisonOrDustName","%"+recordDataRequest.getPoisonOrDustName()+"%");
        }
        PageHelper.startPage(pageNum, pageSize);
        List<RecordVddEquipmentData> dataList = this.recordVddEquipmentDataMapper.selectByCondition(condition);
        PageResult<RecordVddEquipmentData> pageList = new  PageResult<RecordVddEquipmentData>();
        pageList.setTotal(dataList.size());
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public RecordVddEquipmentData add(RecordVddEquipmentData recordData) {
            this.recordVddEquipmentDataMapper.insertUseGeneratedKeys(recordData);
            return recordData;
    }

    @Override
    public RecordVddEquipmentData delete(Long id) {
        this.recordVddEquipmentDataMapper.deleteByPrimaryKey(id);
        RecordVddEquipmentData recordVddEquipmentData = new  RecordVddEquipmentData();
        recordVddEquipmentData.setId(id);
        return recordVddEquipmentData;
    }

    @Override
    public RecordVddEquipmentData update(RecordVddEquipmentData recordData) {
        this.recordVddEquipmentDataMapper.updateByPrimaryKeySelective(recordData);
        return recordData;
    }
}
