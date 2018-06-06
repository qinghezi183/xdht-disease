package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordWorkLog;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordWorkLogRequest;

import java.util.List;


/**
 * Created by lzf on 2018/06/06.
 */
public interface RecordWorkLogService extends Service<RecordWorkLog> {

    /**
     * 查询
     * @param recordWorkLogRequest 查询条件
     * @return 返回结果
     */
    public List<RecordWorkLog> queryList(RecordWorkLogRequest recordWorkLogRequest);

    /**
     * 分页查询
     * @param recordWorkLogRequest 查询条件
     * @param pageNum 页数
     * @param pageSize 每页大小
     * @return 返回结果
     */
    public PageResult<RecordWorkLog> queryListPage(RecordWorkLogRequest recordWorkLogRequest, Integer pageNum, Integer pageSize);

    /**
     * 添加
     * @param recordWorkLog 实体
     * @return 返回结果
     */
    public RecordWorkLog add(RecordWorkLog recordWorkLog);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public RecordWorkLog delete(Long id);

    /**
     * 修改
     * @param recordWorkLog 实体
     * @return 返回结果
     */
    public RecordWorkLog update(RecordWorkLog recordWorkLog);
}
