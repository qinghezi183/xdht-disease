package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordHealthManagement;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordHealthManagementRequest;

import java.util.List;


/**
 * Created by lzf on 2018/06/05.
 */
public interface RecordHealthManagementService extends Service<RecordHealthManagement> {

    /**
     * 查询
     * @param recordHealthManagementRequest 查询条件
     * @return 返回结果
     */
    public List<RecordHealthManagement> queryList(RecordHealthManagementRequest recordHealthManagementRequest);

    /**
     * 分页查询
     * @param recordHealthManagementRequest 查询条件
     * @param pageNum 页数
     * @param pageSize 每页大小
     * @return 返回结果
     */
    public PageResult<RecordHealthManagement> queryListPage(RecordHealthManagementRequest recordHealthManagementRequest, Integer pageNum, Integer pageSize);

    /**
     * 添加
     * @param recordHealthManagement 实体
     * @return 返回结果
     */
    public RecordHealthManagement add(RecordHealthManagement recordHealthManagement);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public RecordHealthManagement delete(Long id);

    /**
     * 修改
     * @param recordHealthManagement 实体
     * @return 返回结果
     */
    public RecordHealthManagement update(RecordHealthManagement recordHealthManagement);
}
