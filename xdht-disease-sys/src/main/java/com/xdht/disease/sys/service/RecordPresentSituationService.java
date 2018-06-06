package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordPresentSituation;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordPresentSituationRequest;

import java.util.List;


/**
 * Created by lzf on 2018/06/04.
 */
public interface RecordPresentSituationService extends Service<RecordPresentSituation> {

    /**
     * 查询列表
     * @param recordPresentSituationRequest 查询条件
     * @return 返回结果
     */
    public List<RecordPresentSituation> queryList(RecordPresentSituationRequest recordPresentSituationRequest);

    /**
     * 分页查询
     * @param recordPresentSituationRequest 查询条件
     * @param pageNum 页数
     * @param pageSize 每页大小
     * @return 返回结果
     */
    public PageResult<RecordPresentSituation> queryListPage(RecordPresentSituationRequest recordPresentSituationRequest, Integer pageNum, Integer pageSize);

    /**
     * 添加
     * @param recordPresentSituation 实体
     * @return 返回结果
     */
    public RecordPresentSituation addRecordPresentSituation(RecordPresentSituation recordPresentSituation);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public RecordPresentSituation deleteRecordPresentSituation(Long id);

    /**
     * 修改
     * @param recordPresentSituation 实体
     * @return 返回结果
     */
    public RecordPresentSituation updateRecordPresentSituation(RecordPresentSituation recordPresentSituation);

}
