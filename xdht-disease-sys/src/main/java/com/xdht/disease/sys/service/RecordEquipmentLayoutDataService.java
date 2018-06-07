package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordEquipmentLayoutData;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordEquipmentLayoutDataRequest;

import java.util.List;


/**
 * Created by lzf on 2018/06/05.
 */
public interface RecordEquipmentLayoutDataService extends Service<RecordEquipmentLayoutData> {

    /**
     * 查询
     * @param recordEquipmentLayoutDataRequest 查询条件
     * @return 返回结果
     */
    public List<RecordEquipmentLayoutData> queryList(RecordEquipmentLayoutDataRequest recordEquipmentLayoutDataRequest);

    /**
     * 分页查询
     * @param recordEquipmentLayoutDataRequest 查询条件
     * @param pageNum 页数
     * @param pageSize 每页大小
     * @return 返回结果
     */
    public PageResult<RecordEquipmentLayoutData> queryListPage(RecordEquipmentLayoutDataRequest recordEquipmentLayoutDataRequest, Integer pageNum, Integer pageSize);

    /**
     * 添加
     * @param recordEquipmentLayoutData 实体
     * @return 返回结果
     */
    public RecordEquipmentLayoutData add(RecordEquipmentLayoutData recordEquipmentLayoutData);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public RecordEquipmentLayoutData delete(Long id);

    /**
     * 修改
     * @param recordEquipmentLayoutData 实体
     * @return 返回结果
     */
    public RecordEquipmentLayoutData update(RecordEquipmentLayoutData recordEquipmentLayoutData);
}
