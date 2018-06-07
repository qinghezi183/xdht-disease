package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.RecordPostPersonnelDataMapper;
import com.xdht.disease.sys.model.RecordPostPersonnelData;
import com.xdht.disease.sys.service.RecordPostPersonnelDataService;
import com.xdht.disease.sys.vo.request.RecordPostPersonnelDataRequest;
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
public class RecordPostPersonnelDataServiceImpl extends AbstractService<RecordPostPersonnelData> implements RecordPostPersonnelDataService{

    @Autowired
    private RecordPostPersonnelDataMapper recordDataMapper;

    @Override
    public List<RecordPostPersonnelData> queryList(RecordPostPersonnelDataRequest recordDataRequest) {

        Condition condition = new Condition(RecordPostPersonnelData.class);
        condition.createCriteria() .andEqualTo("id", recordDataRequest.getId())
                .andEqualTo("companyOfficeId",recordDataRequest.getCompanyOfficeId())
                .andEqualTo("postId",recordDataRequest.getPostId())
                .andEqualTo("totalNumber",recordDataRequest.getTotalNumber());
        return this.recordDataMapper.selectByCondition(condition);
    }

    @Override
    public PageResult<RecordPostPersonnelData> queryListPage(RecordPostPersonnelDataRequest recordDataRequest, Integer pageNum, Integer pageSize) {
        Condition condition = new Condition(RecordPostPersonnelData.class);
        condition.createCriteria() .andEqualTo("id", recordDataRequest.getId())
                .andEqualTo("companyOfficeId",recordDataRequest.getCompanyOfficeId())
                .andEqualTo("postId",recordDataRequest.getPostId())
                .andEqualTo("totalNumber",recordDataRequest.getTotalNumber());
        PageHelper.startPage(pageNum, pageSize);
        List<RecordPostPersonnelData> dataList = this.recordDataMapper.selectByCondition(condition);
        PageResult<RecordPostPersonnelData> pageList = new  PageResult<RecordPostPersonnelData>();
        pageList.setTotal(dataList.size());
        pageList.setDataList(dataList);
        return pageList;
    }

    @Override
    public RecordPostPersonnelData add(RecordPostPersonnelData recordPostPersonnelData) {
            this.recordDataMapper.insertUseGeneratedKeys(recordPostPersonnelData);
            return recordPostPersonnelData;
    }

    @Override
    public RecordPostPersonnelData delete(Long id) {
        this.recordDataMapper.deleteByPrimaryKey(id);
        RecordPostPersonnelData recordPostPersonnelData = new RecordPostPersonnelData();
        recordPostPersonnelData.setId(id);
        return recordPostPersonnelData;
    }

    @Override
    public RecordPostPersonnelData update(RecordPostPersonnelData recordPostPersonnelData) {
        this.recordDataMapper.updateByPrimaryKeySelective(recordPostPersonnelData);
        return  recordPostPersonnelData;
    }
}
