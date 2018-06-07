package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordVddEquipment;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordVddEquipmentRequest;

import java.util.List;


/**
 * Created by lzf on 2018/06/06.
 */
public interface RecordVddEquipmentService extends Service<RecordVddEquipment> {

    /**
     * 查询
     * @param recordVddEquipmentRequest 查询条件
     * @return 返回结果
     */
    public List<RecordVddEquipment> queryList(RecordVddEquipmentRequest recordVddEquipmentRequest);

    /**
     * 分页查询
     * @param recordVddEquipmentRequest 查询条件
     * @param pageNum 页数
     * @param pageSize 每页大小
     * @return 返回结果
     */
    public PageResult<RecordVddEquipment> queryListPage(RecordVddEquipmentRequest recordVddEquipmentRequest, Integer pageNum, Integer pageSize);

    /**
     * 添加
     * @param recordVddEquipment 实体
     * @return 返回结果
     */
    public RecordVddEquipment add(RecordVddEquipment recordVddEquipment);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public RecordVddEquipment delete(Long id);

    /**
     * 修改
     * @param recordVddEquipment 实体
     * @return 返回结果
     */
    public RecordVddEquipment update(RecordVddEquipment recordVddEquipment);
}
