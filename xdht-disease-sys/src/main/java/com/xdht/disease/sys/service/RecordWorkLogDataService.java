package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordWorkLogData;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordWorkLogDataRequest;

import java.util.List;


/**
 * Created by lzf on 2018/06/06.
 */
public interface RecordWorkLogDataService extends Service<RecordWorkLogData> {

    /**
     * 查询
     * @param recordDataRequest 查询条件
     * @return 返回结果
     */
    public List<RecordWorkLogData> queryList(RecordWorkLogDataRequest recordDataRequest);

    /**
     * 分页查询
     * @param recordDataRequest 查询条件
     * @param pageNum  页数
     * @param pageSize 每页大小
     * @return 返回结果
     */
    public PageResult<RecordWorkLogData> queryListPage(RecordWorkLogDataRequest recordDataRequest, Integer pageNum, Integer pageSize);

    /**
     * 添加
     * @param recordData 实体
     * @return 返回结果
     */
    public RecordWorkLogData add(RecordWorkLogData recordData);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public RecordWorkLogData delete(Long id);

    /**
     * 修改
     * @param recordData 实体
     * @return 返回结果
     */
    public RecordWorkLogData update(RecordWorkLogData recordData);
}
