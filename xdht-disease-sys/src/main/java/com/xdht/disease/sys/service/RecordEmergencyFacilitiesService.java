package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordEmergencyFacilities;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordEmergencyFacilitiesRequest;

import java.util.List;


/**
 * Created by lzf on 2018/06/05.
 */
public interface RecordEmergencyFacilitiesService extends Service<RecordEmergencyFacilities> {

    /**
     * 查询
     * @param recordEmergencyFacilitiesRequest 查询条件
     * @return 返回结果
     */
    public List<RecordEmergencyFacilities> queryList(RecordEmergencyFacilitiesRequest recordEmergencyFacilitiesRequest);

    /**
     * 分页查询
     * @param recordEmergencyFacilitiesRequest 查询条件
     * @param pageNum 页数
     * @param pageSize 每页大小
     * @return 返回结果
     */
    public PageResult<RecordEmergencyFacilities> queryListPage(RecordEmergencyFacilitiesRequest recordEmergencyFacilitiesRequest, Integer pageNum, Integer pageSize);

    /**
     * 添加
     * @param recordEmergencyFacilities 实体
     * @return 返回结果
     */
    public RecordEmergencyFacilities add(RecordEmergencyFacilities recordEmergencyFacilities);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public RecordEmergencyFacilities delete(Long id);

    /**
     * 修改
     * @param recordEmergencyFacilities 实体
     * @return 返回结果
     */
    public RecordEmergencyFacilities update(RecordEmergencyFacilities recordEmergencyFacilities);
}
