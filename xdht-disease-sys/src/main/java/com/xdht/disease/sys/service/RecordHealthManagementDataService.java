package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordHealthManagementData;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordHealthManagementDataRequest;

import java.util.List;


/**
 * Created by lzf on 2018/06/05.
 */
public interface RecordHealthManagementDataService extends Service<RecordHealthManagementData> {

    /**
     * 查询
     * @param recordHealthManagementDataRequest 查询条件
     * @return 返回结果
     */
    public List<RecordHealthManagementData> queryList(RecordHealthManagementDataRequest recordHealthManagementDataRequest);

    /**
     * 分页查询
     * @param recordHealthManagementDataRequest 查询条件
     * @param pageNum  页数
     * @param pageSize 每页大小
     * @return 返回结果
     */
    public PageResult<RecordHealthManagementData> queryListPage(RecordHealthManagementDataRequest recordHealthManagementDataRequest, Integer pageNum, Integer pageSize);

    /**
     * 添加
     * @param recordHealthManagementData 实体
     * @return 返回结果
     */
    public RecordHealthManagementData add(RecordHealthManagementData recordHealthManagementData);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public RecordHealthManagementData delete(Long id);

    /**
     * 修改
     * @param recordHealthManagementData 实体
     * @return 返回结果
     */
    public RecordHealthManagementData update(RecordHealthManagementData recordHealthManagementData);
}
