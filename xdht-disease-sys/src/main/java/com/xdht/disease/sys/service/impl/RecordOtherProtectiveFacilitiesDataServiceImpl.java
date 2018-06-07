package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.RecordOtherProtectiveFacilitiesDataMapper;
import com.xdht.disease.sys.model.RecordOtherProtectiveFacilitiesData;
import com.xdht.disease.sys.service.RecordOtherProtectiveFacilitiesDataService;
import com.xdht.disease.sys.vo.request.RecordOtherProtectiveFacilitiesDataRequest;
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
public class RecordOtherProtectiveFacilitiesDataServiceImpl extends AbstractService<RecordOtherProtectiveFacilitiesData> implements RecordOtherProtectiveFacilitiesDataService{

    @Autowired
    private RecordOtherProtectiveFacilitiesDataMapper recordDataMapper;

        @Override
        public List<RecordOtherProtectiveFacilitiesData> queryList(RecordOtherProtectiveFacilitiesDataRequest recordDataRequest) {
            Condition condition = new Condition(RecordOtherProtectiveFacilitiesData.class);
            condition.createCriteria() .andEqualTo("id", recordDataRequest.getId())
                    .andEqualTo("officeId",recordDataRequest.getOfficeId())
                    .andEqualTo("postId",recordDataRequest.getPostId());
            if (recordDataRequest.getWorkPlace() != null) {
                condition.getOredCriteria().get(0).andLike("workPlace","%"+recordDataRequest.getWorkPlace()+"%");
            }
            if (recordDataRequest.getHazardFactors() != null) {
                condition.getOredCriteria().get(0).andLike("hazardFactors","%"+recordDataRequest.getHazardFactors()+"%");
            }
            return this.recordDataMapper.selectByCondition(condition);
        }

        @Override
        public PageResult<RecordOtherProtectiveFacilitiesData> queryListPage(RecordOtherProtectiveFacilitiesDataRequest recordDataRequest, Integer pageNum, Integer pageSize) {
            Condition condition = new Condition(RecordOtherProtectiveFacilitiesData.class);
            condition.createCriteria() .andEqualTo("id", recordDataRequest.getId())
                    .andEqualTo("officeId",recordDataRequest.getOfficeId())
                    .andEqualTo("postId",recordDataRequest.getPostId());
            if (recordDataRequest.getWorkPlace() != null) {
                condition.getOredCriteria().get(0).andLike("workPlace","%"+recordDataRequest.getWorkPlace()+"%");
            }
            if (recordDataRequest.getHazardFactors() != null) {
                condition.getOredCriteria().get(0).andLike("hazardFactors","%"+recordDataRequest.getHazardFactors()+"%");
            }
            PageHelper.startPage(pageNum, pageSize);
            List<RecordOtherProtectiveFacilitiesData> dataList = this.recordDataMapper.selectByCondition(condition);
            PageResult<RecordOtherProtectiveFacilitiesData> pageList = new  PageResult<RecordOtherProtectiveFacilitiesData>();
            pageList.setTotal(dataList.size());
            pageList.setDataList(dataList);
            return pageList;
        }

        @Override
        public RecordOtherProtectiveFacilitiesData add(RecordOtherProtectiveFacilitiesData recordOtherProtectiveFacilitiesData) {
                this.recordDataMapper.insertUseGeneratedKeys(recordOtherProtectiveFacilitiesData);
                return recordOtherProtectiveFacilitiesData;
        }

        @Override
        public RecordOtherProtectiveFacilitiesData delete(Long id) {
                this.recordDataMapper.deleteByPrimaryKey(id);
                RecordOtherProtectiveFacilitiesData recordOtherProtectiveFacilitiesData = new RecordOtherProtectiveFacilitiesData();
                recordOtherProtectiveFacilitiesData.setId(id);
                return recordOtherProtectiveFacilitiesData;
        }

        @Override
        public RecordOtherProtectiveFacilitiesData update(RecordOtherProtectiveFacilitiesData recordOtherProtectiveFacilitiesData) {
                this.recordDataMapper.updateByPrimaryKeySelective(recordOtherProtectiveFacilitiesData);
                return recordOtherProtectiveFacilitiesData;
        }

}
