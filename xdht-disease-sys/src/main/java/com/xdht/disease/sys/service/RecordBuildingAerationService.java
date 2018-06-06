package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordBuildingAeration;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordBuildingAerationRequest;

import java.util.List;


/**
 * Created by lzf on 2018/06/05.
 */
public interface RecordBuildingAerationService extends Service<RecordBuildingAeration> {

    /**
     * 查询列表
     * @param recordBuildingAerationRequest 查询条件
     * @return 返回结果
     */
    public List<RecordBuildingAeration> queryList(RecordBuildingAerationRequest recordBuildingAerationRequest);

    /**
     * 分页查询
     * @param recordBuildingAerationRequest 查询条件
     * @param pageNum 页数
     * @param pageSize 每页大小
     * @return 返回结果
     */
    public PageResult<RecordBuildingAeration> queryListPage(RecordBuildingAerationRequest recordBuildingAerationRequest, Integer pageNum, Integer pageSize);

    /**
     * 添加
     * @param recordBuildingAeration 实体
     * @return 返回结果
     */
    public RecordBuildingAeration add(RecordBuildingAeration recordBuildingAeration);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public RecordBuildingAeration  delete(Long id);

    /**
     * 修改
     * @param recordBuildingAeration 实体
     * @return 返回结果
     */
    public RecordBuildingAeration update(RecordBuildingAeration recordBuildingAeration);
}
