package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordAntiNoiseFacilities;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordAntiNoiseFacilitiesRequest;

import java.util.List;


/**
 * Created by lzf on 2018/06/04.
 */
public interface RecordAntiNoiseFacilitiesService extends Service<RecordAntiNoiseFacilities> {

    /**
     * 查询列表
     * @param recordAntiNoiseFacilitiesRequest 查询条件
     * @return 返回结果
     */
    public List<RecordAntiNoiseFacilities> queryList(RecordAntiNoiseFacilitiesRequest recordAntiNoiseFacilitiesRequest);

    /**
     * 分页查询
     * @param recordAntiNoiseFacilitiesRequest 查询条件
     * @param pageNum 页数
     * @param pageSize 每页大小
     * @return 返回结果
     */
    public PageResult<RecordAntiNoiseFacilities> queryListPage(RecordAntiNoiseFacilitiesRequest recordAntiNoiseFacilitiesRequest, Integer pageNum, Integer pageSize);

    /**
     * 添加
     * @param recordControlEffect 实体
     * @return 返回结果
     */
    public RecordAntiNoiseFacilities addRecordAntiNoiseFacilities(RecordAntiNoiseFacilities recordControlEffect);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public RecordAntiNoiseFacilities deleteRecordAntiNoiseFacilities(Long id);

    /**
     * 修改
     * @param recordAntiNoiseFacilities 实体
     * @return 返回结果
     */
    public RecordAntiNoiseFacilities updateRecordAntiNoiseFacilities(RecordAntiNoiseFacilities recordAntiNoiseFacilities);
}
