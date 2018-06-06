package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.RecordWorkLogDataMapper;
import com.xdht.disease.sys.model.RecordWorkLogData;
import com.xdht.disease.sys.service.RecordWorkLogDataService;
import com.xdht.disease.sys.vo.request.RecordWorkLogDataRequest;
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
public class RecordWorkLogDataServiceImpl extends AbstractService<RecordWorkLogData> implements RecordWorkLogDataService{

    @Autowired
    private RecordWorkLogDataMapper recordWorkLogDataMapper;

    @Override
    public List<RecordWorkLogData> queryList(RecordWorkLogDataRequest recordDataRequest) {
        Condition condition =  new Condition(RecordWorkLogData.class);
        condition.createCriteria().andEqualTo("id",recordDataRequest.getId())
                .andEqualTo("companyOfficeId",recordDataRequest.getCompanyOfficeId())
                .andEqualTo("postId",recordDataRequest.getPostId());
        if (recordDataRequest.getWorkPlace() != null){
            condition.getOredCriteria().get(0).andLike("workPlace","%"+recordDataRequest.getWorkPlace()+"%");
        }
        if (recordDataRequest.getHazardFactors() != null){
            condition.getOredCriteria().get(0).andLike("hazardFactors","%"+recordDataRequest.getHazardFactors()+"%");
        }
        return this.recordWorkLogDataMapper.selectByCondition(condition);
    }

    @Override
    public PageResult<RecordWorkLogData> queryListPage(RecordWorkLogDataRequest recordDataRequest, Integer pageNum, Integer pageSize) {
        Condition condition =  new Condition(RecordWorkLogData.class);
        condition.createCriteria().andEqualTo("id",recordDataRequest.getId())
                .andEqualTo("companyOfficeId",recordDataRequest.getCompanyOfficeId())
                .andEqualTo("postId",recordDataRequest.getPostId());
        if (recordDataRequest.getWorkPlace() != null){
            condition.getOredCriteria().get(0).andLike("workPlace","%"+recordDataRequest.getWorkPlace()+"%");
        }
        if (recordDataRequest.getHazardFactors() != null){
            condition.getOredCriteria().get(0).andLike("hazardFactors","%"+recordDataRequest.getHazardFactors()+"%");
        }
        PageHelper.startPage(pageNum, pageSize);
        List<RecordWorkLogData> dataList = this.recordWorkLogDataMapper.selectByCondition(condition);
        PageResult<RecordWorkLogData> pageList = new  PageResult<RecordWorkLogData>();
        pageList.setTotal(dataList.size());
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public RecordWorkLogData add(RecordWorkLogData recordData) {
            this.recordWorkLogDataMapper.insertUseGeneratedKeys(recordData);
            return recordData;
    }

    @Override
    public RecordWorkLogData delete(Long id) {
        this.recordWorkLogDataMapper.deleteByPrimaryKey(id);
        RecordWorkLogData recordWorkLogData = new RecordWorkLogData();
        recordWorkLogData.setId(id);
        return recordWorkLogData;
    }

    @Override
    public RecordWorkLogData update(RecordWorkLogData recordData) {
            this.recordWorkLogDataMapper.updateByPrimaryKeySelective(recordData);
            return recordData;
    }
}
