package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordEquipmentData;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordEquipmentDataRequest;

import java.util.List;


/**
 * Created by lzf on 2018/06/05.
 */
public interface RecordEquipmentDataService extends Service<RecordEquipmentData> {

    /**
     * 查询
     * @param recordEquipmentDataRequest 查询条件
     * @return 返回结果
     */
    public List<RecordEquipmentData> queryList(RecordEquipmentDataRequest recordEquipmentDataRequest);

    /**
     * 分页查询
     * @param recordEquipmentDataRequest 查询条件
     * @param pageNum 页数
     * @param pageSize 每页大小
     * @return 返回结果
     */
    public PageResult<RecordEquipmentData> queryListPage(RecordEquipmentDataRequest recordEquipmentDataRequest, Integer pageNum, Integer pageSize);

    /**
     * 添加
     * @param recordEquipmentData 实体
     * @return 返回结果
     */
    public RecordEquipmentData add(RecordEquipmentData recordEquipmentData);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public RecordEquipmentData delete(Long id);

    /**
     * 修改
     * @param recordEquipmentData 实体
     * @return 返回结果
     */
    public RecordEquipmentData  update(RecordEquipmentData recordEquipmentData);
}
