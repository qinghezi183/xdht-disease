package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.RecordProductMapper;
import com.xdht.disease.sys.model.RecordProduct;
import com.xdht.disease.sys.service.RecordProductService;
import com.xdht.disease.sys.vo.request.RecordProductRequest;
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
public class RecordProductServiceImpl extends AbstractService<RecordProduct> implements RecordProductService{

    @Autowired
    private RecordProductMapper recordProductMapper;

    @Override
    public List<RecordProduct> queryList(RecordProductRequest recordProductRequest) {
        Condition condition = new Condition(RecordProduct.class);
        condition.createCriteria() .andEqualTo("id", recordProductRequest.getId())
                .andEqualTo("productNo",recordProductRequest.getProductNo());
        if (recordProductRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordProductRequest.getVerificationResult()+"%");
        }
        if (recordProductRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordProductRequest.getStatus());
        }
        return this.recordProductMapper.selectByCondition(condition);
    }

    @Override
    public PageResult<RecordProduct> queryListPage(RecordProductRequest recordProductRequest, Integer pageNum, Integer pageSize) {
        Condition condition = new Condition(RecordProduct.class);
        condition.createCriteria() .andEqualTo("id", recordProductRequest.getId())
                .andEqualTo("productNo",recordProductRequest.getProductNo());
        if (recordProductRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordProductRequest.getVerificationResult()+"%");
        }
        if (recordProductRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordProductRequest.getStatus());
        }
        PageHelper.startPage(pageNum, pageSize);
        List<RecordProduct> dataList = this.recordProductMapper.selectByCondition(condition);
        PageResult<RecordProduct> pageList = new  PageResult<RecordProduct>();
        pageList.setTotal(dataList.size());
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public RecordProduct add(RecordProduct recordProduct) {
        this.recordProductMapper.insertUseGeneratedKeys(recordProduct);
        return  recordProduct;
    }

    @Override
    public RecordProduct delete(Long id) {
        this.recordProductMapper.deleteByPrimaryKey(id);
        RecordProduct recordProduct = new RecordProduct();
        recordProduct.setId(id);
        return  recordProduct;
    }

    @Override
    public RecordProduct update(RecordProduct recordProduct) {
        this.recordProductMapper.updateByPrimaryKeySelective(recordProduct);
        return  recordProduct;
    }
}
