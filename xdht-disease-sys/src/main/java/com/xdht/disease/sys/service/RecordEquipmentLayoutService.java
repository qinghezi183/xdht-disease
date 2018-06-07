package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordEquipmentLayout;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordEquipmentLayoutRequest;

import java.util.List;


/**
 * Created by lzf on 2018/06/05.
 */
public interface RecordEquipmentLayoutService extends Service<RecordEquipmentLayout> {

    /**
     * 查询
     * @param recordEquipmentLayoutRequest 查询条件
     * @return 返回结果
     */
    public List<RecordEquipmentLayout> queryList(RecordEquipmentLayoutRequest recordEquipmentLayoutRequest);

    /**
     * 分页查询
     * @param recordEquipmentLayoutRequest 查询条件
     * @param pageNum 页数
     * @param pageSize 每页大小
     * @return 返回结果
     */
    public PageResult<RecordEquipmentLayout> queryListPage(RecordEquipmentLayoutRequest recordEquipmentLayoutRequest, Integer pageNum, Integer pageSize);

    /**
     * 添加
     * @param recordEquipmentLayout 实体
     * @return 返回结果
     */
    public RecordEquipmentLayout add(RecordEquipmentLayout recordEquipmentLayout);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public RecordEquipmentLayout delete(Long id);

    /**
     * 修改
     * @param recordEquipmentLayout 实体
     * @return 返回结果
     */
    public RecordEquipmentLayout update(RecordEquipmentLayout recordEquipmentLayout);
}
