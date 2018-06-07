package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordPreEvaluation;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordPreEvaluationRequest;

import java.util.List;


/**
 * Created by lzf on 2018/06/04.
 */
public interface RecordPreEvaluationService extends Service<RecordPreEvaluation> {

    /**
     * 查询列表
     * @param recordPreEvaluationRequest 查询条件
     * @return 返回结果
     */
    public List<RecordPreEvaluation> queryList(RecordPreEvaluationRequest recordPreEvaluationRequest);

    /**
     * 分页查询
     * @param recordPreEvaluationRequest 查询条件
     * @param pageNum 页数
     * @param pageSize 每页大小
     * @return 返回结果
     */
    public PageResult<RecordPreEvaluation> queryListPage(RecordPreEvaluationRequest recordPreEvaluationRequest, Integer pageNum, Integer pageSize);

    /**
     * 添加
     * @param recordPreEvaluation 实体
     * @return 返回结果
     */
    public RecordPreEvaluation addRecordPreEvaluation(RecordPreEvaluation recordPreEvaluation);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public RecordPreEvaluation deleteRecordPreEvaluation(Long id);

    /**
     * 修改
     * @param recordPreEvaluation 实体
     * @return 返回结果
     */
    public RecordPreEvaluation updateRecordPreEvaluation(RecordPreEvaluation recordPreEvaluation);

}
