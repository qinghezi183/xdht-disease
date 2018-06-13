package com.xdht.disease.sys.service;

import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.model.RecordPresentSituationData;
import com.xdht.disease.sys.vo.request.RecordPresentSituationDataRequest;

import java.util.List;


/**
 * Created by lzf on 2018/06/04.
 */
public interface RecordPresentSituationDataService extends Service<RecordPresentSituationData> {

    /**
     * 查询列表
     * @param recordPresentSituationDataRequest 查询条件
     * @return 返回结果
     */
    public List<RecordPresentSituationData> queryList(RecordPresentSituationDataRequest recordPresentSituationDataRequest);

    /**
     * 分页查询
     * @param recordPresentSituationDataRequest 查询条件
     * @param pageNum 页数
     * @param pageSize 每页大小
     * @return 返回结果
     */
    public PageResult<RecordPresentSituationData> queryListPage(RecordPresentSituationDataRequest recordPresentSituationDataRequest, Integer pageNum, Integer pageSize);

    /**
     * 添加
     * @param recordPresentSituationData 实体
     * @return 返回结果
     */
    public RecordPresentSituationData addRecordPresentSituationData(RecordPresentSituationData recordPresentSituationData);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public RecordPresentSituationData deleteRecordPresentSituationData(Long id);

    /**
     * 修改
     * @param recordPresentSituationData 实体
     * @return 返回结果
     */
    public RecordPresentSituationData updateRecordPresentSituationData(RecordPresentSituationData recordPresentSituationData);

}
