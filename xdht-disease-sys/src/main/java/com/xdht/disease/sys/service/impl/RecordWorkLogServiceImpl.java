package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.RecordWorkLogMapper;
import com.xdht.disease.sys.model.RecordWorkLog;
import com.xdht.disease.sys.service.RecordWorkLogService;
import com.xdht.disease.sys.vo.request.RecordWorkLogRequest;
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
public class RecordWorkLogServiceImpl extends AbstractService<RecordWorkLog> implements RecordWorkLogService{

    @Autowired
    private RecordWorkLogMapper recordWorkLogMapper;

    @Override
    public List<RecordWorkLog> queryList(RecordWorkLogRequest recordWorkLogRequest) {

        Condition condition = new Condition(RecordWorkLog.class);
        condition.createCriteria() .andEqualTo("id", recordWorkLogRequest.getId())
                .andEqualTo("workLogNo",recordWorkLogRequest.getWorkLogNo());
        if (recordWorkLogRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordWorkLogRequest.getVerificationResult()+"%");
        }
        if (recordWorkLogRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordWorkLogRequest.getStatus());
        }
        return this.recordWorkLogMapper.selectByCondition(condition);
    }

    @Override
    public PageResult<RecordWorkLog> queryListPage(RecordWorkLogRequest recordWorkLogRequest, Integer pageNum, Integer pageSize) {

        Condition condition = new Condition(RecordWorkLog.class);
        condition.createCriteria() .andEqualTo("id", recordWorkLogRequest.getId())
                .andEqualTo("workLogNo",recordWorkLogRequest.getWorkLogNo());
        if (recordWorkLogRequest.getVerificationResult() != null) {
            condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordWorkLogRequest.getVerificationResult()+"%");
        }
        if (recordWorkLogRequest.getStatus() != null){
            condition.getOredCriteria().get(0).andEqualTo("status",recordWorkLogRequest.getStatus());
        }
        PageHelper.startPage(pageNum, pageSize);
        List<RecordWorkLog> dataList = this.recordWorkLogMapper.selectByCondition(condition);
        PageResult<RecordWorkLog> pageList = new  PageResult<RecordWorkLog>();
        pageList.setTotal(dataList.size());
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public RecordWorkLog add(RecordWorkLog recordWorkLog) {
            this.recordWorkLogMapper.insertUseGeneratedKeys(recordWorkLog);
            return recordWorkLog;
    }

    @Override
    public RecordWorkLog delete(Long id) {
        this.recordWorkLogMapper.deleteByPrimaryKey(id);
        RecordWorkLog recordWorkLog = new RecordWorkLog();
        recordWorkLog.setId(id);
        return recordWorkLog;
    }

    @Override
    public RecordWorkLog update(RecordWorkLog recordWorkLog) {
            this.recordWorkLogMapper.updateByPrimaryKeySelective(recordWorkLog);
            return recordWorkLog;
    }
}
