package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordIndividualProtectiveEquipment;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordIndividualProtectiveEquipmentRequest;

import java.util.List;


/**
 * Created by lzf on 2018/06/05.
 */
public interface RecordIndividualProtectiveEquipmentService extends Service<RecordIndividualProtectiveEquipment> {

    /**
     * 查询
     * @param recordRequest 查询条件
     * @return 返回结果
     */
    public List<RecordIndividualProtectiveEquipment> queryList(RecordIndividualProtectiveEquipmentRequest recordRequest);

    /**
     * 分页查询
     * @param recordRequest 查询条件
     * @param pageNum 页数
     * @param pageSize 每页大小
     * @return 返回结果
     */
    public PageResult<RecordIndividualProtectiveEquipment> queryListPage(RecordIndividualProtectiveEquipmentRequest recordRequest, Integer pageNum, Integer pageSize);

    /**
     * 添加
     * @param record 实体
     * @return 返回结果
     */
    public  RecordIndividualProtectiveEquipment add(RecordIndividualProtectiveEquipment record);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public  RecordIndividualProtectiveEquipment delete(Long id);

    /**
     * 修改
     * @param record 实体
     * @return 返回结果
     */
    public  RecordIndividualProtectiveEquipment update(RecordIndividualProtectiveEquipment record);
}
