package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordScene;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordSceneRequest;

import java.util.List;


/**
 * Created by lzf on 2018/06/04.
 */
public interface RecordSceneService extends Service<RecordScene> {

    /**
     * 查询列表
     * @param recordSceneRequest 查询条件
     * @return 返回结果
     */
    public List<RecordScene> queryList(RecordSceneRequest recordSceneRequest);

    /**
     * 分页查询
     * @param recordSceneRequest 查询条件
     * @param pageNum 页数
     * @param pageSize 每页数据大小
     * @return 返回结果
     */
    public PageResult<RecordScene> queryListPage(RecordSceneRequest recordSceneRequest, Integer pageNum, Integer pageSize);

    /**
     * 添加
     * @param recordScene 实体
     * @return 返回结果
     */
    public RecordScene addRecordScene(RecordScene recordScene);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public RecordScene deleteRecordScene(Long id);

    /**
     * 修改
     * @param recordScene 实体
     * @return 返回结果
     */
    public RecordScene updateRecordScene(RecordScene recordScene);
}
