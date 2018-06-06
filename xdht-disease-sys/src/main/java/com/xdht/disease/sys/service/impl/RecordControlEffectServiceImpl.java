package com.xdht.disease.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdht.disease.common.core.AbstractService;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.dao.RecordControlEffectMapper;
import com.xdht.disease.sys.model.RecordControlEffect;
import com.xdht.disease.sys.service.RecordControlEffectService;
import com.xdht.disease.sys.vo.request.RecordControlEffectRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;


/**
 * Created by lzf on 2018/06/04.
 */
@Service
@Transactional
public class RecordControlEffectServiceImpl extends AbstractService<RecordControlEffect> implements RecordControlEffectService{

    @Autowired
    private RecordControlEffectMapper recordControlEffectMapper;

        @Override
        public List<RecordControlEffect> queryList(RecordControlEffectRequest recordControlEffectRequest) {
            Condition condition = new Condition(RecordControlEffect.class);
            condition.createCriteria() .andEqualTo("id", recordControlEffectRequest.getId())
            .andEqualTo("preEvaluationNo",recordControlEffectRequest.getPreEvaluationNo());
            if (recordControlEffectRequest.getVerificationResult() != null) {
                condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordControlEffectRequest.getVerificationResult()+"%");
            }
            if (recordControlEffectRequest.getStatus() != null){
                condition.getOredCriteria().get(0).andEqualTo("status",recordControlEffectRequest.getStatus());
            }
            return this.recordControlEffectMapper.selectByCondition(condition);
        }

        @Override
        public PageResult<RecordControlEffect> queryListPage(RecordControlEffectRequest recordControlEffectRequest, Integer pageNum, Integer pageSize) {
            Condition condition = new Condition(RecordControlEffect.class);
            condition.createCriteria() .andEqualTo("id", recordControlEffectRequest.getId())
                    .andEqualTo("preEvaluationNo",recordControlEffectRequest.getPreEvaluationNo());
            if (recordControlEffectRequest.getVerificationResult() != null) {
                condition.getOredCriteria().get(0).andLike("verificationResult","%"+recordControlEffectRequest.getVerificationResult()+"%");
            }
            if (recordControlEffectRequest.getStatus() != null){
                condition.getOredCriteria().get(0).andEqualTo("status",recordControlEffectRequest.getStatus());
            }
            PageHelper.startPage(pageNum, pageSize);
            List<RecordControlEffect> dataList = this.recordControlEffectMapper.selectByCondition(condition);
            PageResult<RecordControlEffect> pageList = new  PageResult<RecordControlEffect>();
            pageList.setTotal(dataList.size());
            pageList.setDataList(dataList);
            return pageList;
        }

    @Override
        public RecordControlEffect addRecordControlEffect(RecordControlEffect recordControlEffect) {
            this.recordControlEffectMapper.insertUseGeneratedKeys(recordControlEffect);
            return  recordControlEffect;
        }

        @Override
        public RecordControlEffect deleteRecordControlEffect(Long id) {
            this.recordControlEffectMapper.deleteByPrimaryKey(id);
            RecordControlEffect recordControlEffect = new RecordControlEffect();
            recordControlEffect.setId(id);
            return  recordControlEffect;
        }

        @Override
        public RecordControlEffect updateRecordControlEffect(RecordControlEffect recordControlEffect) {
        this.recordControlEffectMapper.updateByPrimaryKeySelective(recordControlEffect);
        return recordControlEffect;
        }

}
