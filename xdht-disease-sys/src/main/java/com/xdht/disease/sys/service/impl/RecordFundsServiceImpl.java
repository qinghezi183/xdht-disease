package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.RecordFundsMapper;
import com.xdht.disease.sys.model.RecordFunds;
import com.xdht.disease.sys.service.RecordFundsService;
import com.xdht.disease.sys.vo.request.RecordFundsRequest;
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
public class RecordFundsServiceImpl extends AbstractService<RecordFunds> implements RecordFundsService{

    @Autowired
    private RecordFundsMapper recordFundsMapper;

    @Override
    public List<RecordFunds> queryList(RecordFundsRequest recordFundsRequest) {
        Condition condition = new Condition(RecordFunds.class);
        condition.createCriteria() .andEqualTo("id", recordFundsRequest.getId())
                .andEqualTo("fundsNo",recordFundsRequest.getFundsNo());
        if (recordFundsRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordFundsRequest.getVerificationResult()+"%");
        }
        if (recordFundsRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordFundsRequest.getStatus());
        }
        return this.recordFundsMapper.selectByCondition(condition);
    }

    @Override
    public PageResult<RecordFunds> queryListPage(RecordFundsRequest recordFundsRequest, Integer pageNum, Integer pageSize) {
        Condition condition = new Condition(RecordFunds.class);
        condition.createCriteria() .andEqualTo("id", recordFundsRequest.getId())
                .andEqualTo("fundsNo",recordFundsRequest.getFundsNo());
        if (recordFundsRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordFundsRequest.getVerificationResult()+"%");
        }
        if (recordFundsRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordFundsRequest.getStatus());
        }
        PageHelper.startPage(pageNum, pageSize);
        List<RecordFunds> dataList = this.recordFundsMapper.selectByCondition(condition);
        PageResult<RecordFunds> pageList = new  PageResult<RecordFunds>();
        pageList.setTotal(dataList.size());
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public RecordFunds add(RecordFunds recordFunds) {
            this.recordFundsMapper.insertUseGeneratedKeys(recordFunds);
            return recordFunds;
    }

    @Override
    public RecordFunds delete(Long id) {
            this.recordFundsMapper.deleteByPrimaryKey(id);
            RecordFunds recordFunds = new RecordFunds();
            recordFunds.setId(id);
            return recordFunds;
    }

    @Override
    public RecordFunds update(RecordFunds recordFunds) {
        this.recordFundsMapper.updateByPrimaryKeySelective(recordFunds);
        return recordFunds;
    }
}
