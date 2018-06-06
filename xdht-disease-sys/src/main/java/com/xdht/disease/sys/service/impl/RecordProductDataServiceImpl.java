package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.RecordProductDataMapper;
import com.xdht.disease.sys.model.RecordProductData;
import com.xdht.disease.sys.service.RecordProductDataService;
import com.xdht.disease.sys.vo.request.RecordProductDataRequest;
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
public class RecordProductDataServiceImpl extends AbstractService<RecordProductData> implements RecordProductDataService{

    @Autowired
    private RecordProductDataMapper recordProductDataMapper;

    @Override
    public List<RecordProductData> queryList(RecordProductDataRequest recordProductDataRequest) {
        Condition condition =  new Condition(RecordProductData.class);
        condition.createCriteria().andEqualTo("id",recordProductDataRequest.getId())
                .andEqualTo("companyOfficeId",recordProductDataRequest.getCompanyOfficeId());
        if (recordProductDataRequest.getProcessName() != null){
            condition.getOredCriteria().get(0).andLike("processName","%"+recordProductDataRequest.getProcessName()+"%");
        }
        if (recordProductDataRequest.getProductName() != null){
            condition.getOredCriteria().get(0).andLike("productName","%"+recordProductDataRequest.getProductName()+"%");
        }
        return this.recordProductDataMapper.selectByCondition(condition);
    }

    @Override
    public PageResult<RecordProductData> queryListPage(RecordProductDataRequest recordProductDataRequest, Integer pageNum, Integer pageSize) {
        Condition condition =  new Condition(RecordProductData.class);
        condition.createCriteria().andEqualTo("id",recordProductDataRequest.getId())
                .andEqualTo("companyOfficeId",recordProductDataRequest.getCompanyOfficeId());
        if (recordProductDataRequest.getProcessName() != null){
            condition.getOredCriteria().get(0).andLike("processName","%"+recordProductDataRequest.getProcessName()+"%");
        }
        if (recordProductDataRequest.getProductName() != null){
            condition.getOredCriteria().get(0).andLike("productName","%"+recordProductDataRequest.getProductName()+"%");
        }
        PageHelper.startPage(pageNum, pageSize);
        List<RecordProductData> dataList = this.recordProductDataMapper.selectByCondition(condition);
        PageResult<RecordProductData> pageList = new  PageResult<RecordProductData>();
        pageList.setTotal(dataList.size());
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public RecordProductData add(RecordProductData recordProductData) {
            this.recordProductDataMapper.insertUseGeneratedKeys(recordProductData);
            return recordProductData;
    }

    @Override
    public RecordProductData delete(Long id) {
        this.recordProductDataMapper.deleteByPrimaryKey(id);
        RecordProductData recordProductData = new RecordProductData();
        recordProductData.setId(id);
        return recordProductData;
    }

    @Override
    public RecordProductData update(RecordProductData recordProductData) {
        this.recordProductDataMapper.updateByPrimaryKeySelective(recordProductData);
        return recordProductData;
    }
}
