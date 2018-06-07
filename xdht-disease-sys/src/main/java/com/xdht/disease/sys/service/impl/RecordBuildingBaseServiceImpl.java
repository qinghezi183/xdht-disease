package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.RecordBuildingBaseMapper;
import com.xdht.disease.sys.model.RecordBuildingBase;
import com.xdht.disease.sys.service.RecordBuildingBaseService;
import com.xdht.disease.sys.vo.request.RecordBuildingBaseRequest;
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
public class RecordBuildingBaseServiceImpl extends AbstractService<RecordBuildingBase> implements RecordBuildingBaseService{

    @Autowired
    private RecordBuildingBaseMapper recordBuildingBaseMapper;

    @Override
    public List<RecordBuildingBase> queryList(RecordBuildingBaseRequest recordBuildingBaseRequest) {
        Condition condition = new Condition(RecordBuildingBase.class);
        condition.createCriteria() .andEqualTo("id", recordBuildingBaseRequest.getId())
                .andEqualTo("buildingBaseNo",recordBuildingBaseRequest.getBuildingBaseNo());
        if (recordBuildingBaseRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordBuildingBaseRequest.getVerificationResult()+"%");
        }
        if (recordBuildingBaseRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordBuildingBaseRequest.getStatus());
        }
        return this.recordBuildingBaseMapper.selectByCondition(condition);
    }

    @Override
    public PageResult<RecordBuildingBase> queryListPage(RecordBuildingBaseRequest recordBuildingBaseRequest, Integer pageNum, Integer pageSize) {
        Condition condition = new Condition(RecordBuildingBase.class);
        condition.createCriteria() .andEqualTo("id", recordBuildingBaseRequest.getId())
                .andEqualTo("buildingBaseNo",recordBuildingBaseRequest.getBuildingBaseNo());
        if (recordBuildingBaseRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordBuildingBaseRequest.getVerificationResult()+"%");
        }
        if (recordBuildingBaseRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordBuildingBaseRequest.getStatus());
        }
        PageHelper.startPage(pageNum, pageSize);
        List<RecordBuildingBase> dataList = this.recordBuildingBaseMapper.selectByCondition(condition);
        PageResult<RecordBuildingBase> pageList = new  PageResult<RecordBuildingBase>();
        pageList.setTotal(dataList.size());
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public RecordBuildingBase add(RecordBuildingBase recordBuildingBase) {
            this.recordBuildingBaseMapper.insertUseGeneratedKeys(recordBuildingBase);
            return recordBuildingBase;
    }

    @Override
    public RecordBuildingBase delete(Long id) {
            this.recordBuildingBaseMapper.deleteByPrimaryKey(id);
            RecordBuildingBase recordBuildingBase = new RecordBuildingBase();
            recordBuildingBase.setId(id);
            return  recordBuildingBase;
    }

    @Override
    public RecordBuildingBase update(RecordBuildingBase recordBuildingBase) {
        this.recordBuildingBaseMapper.updateByPrimaryKeySelective(recordBuildingBase);
        return recordBuildingBase;
    }
}
