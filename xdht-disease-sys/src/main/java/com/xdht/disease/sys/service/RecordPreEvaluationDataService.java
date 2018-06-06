package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordPreEvaluation;
import com.xdht.disease.sys.model.RecordPreEvaluationData;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordPreEvaluationDataRequest;

import java.util.List;


/**
 * Created by lzf on 2018/06/04.
 */
public interface RecordPreEvaluationDataService extends Service<RecordPreEvaluationData> {

    /**
     * 查询列表
     * @param recordPreEvaluationDataRequest 查询条件
     * @return 返回结果
     */
    public List<RecordPreEvaluationData> queryList(RecordPreEvaluationDataRequest recordPreEvaluationDataRequest);

    /**
     * 分页查询
     * @param recordPreEvaluationDataRequest 查询条件
     * @param pageNum 页数
     * @param pageSize 每页大小
     * @return 返回结果
     */
    public PageResult<RecordPreEvaluationData> queryListPage(RecordPreEvaluationDataRequest recordPreEvaluationDataRequest, Integer pageNum, Integer pageSize);
    /**
     * 添加
     * @param recordPreEvaluationData 实体
     * @return 返回结果
     */
    public RecordPreEvaluationData addRecordPreEvaluationData(RecordPreEvaluationData recordPreEvaluationData);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public RecordPreEvaluationData deleteRecordPreEvaluationData(Long id);

    /**
     * 修改
     * @param recordPreEvaluationData 实体
     * @return 返回结果
     */
    public RecordPreEvaluationData updateRecordPreEvaluationData(RecordPreEvaluationData recordPreEvaluationData);

}
