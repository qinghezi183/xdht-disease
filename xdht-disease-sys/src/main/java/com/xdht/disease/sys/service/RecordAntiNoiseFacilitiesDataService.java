package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordAntiNoiseFacilitiesData;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordAntiNoiseFacilitiesDataRequest;

import java.util.List;


/**
 * Created by lzf on 2018/06/04.
 */
public interface RecordAntiNoiseFacilitiesDataService extends Service<RecordAntiNoiseFacilitiesData> {

    /**
     * 查询列表
     * @param recordAntiNoiseFacilitiesDataRequest 查询条件
     * @return 返回结果
     */
    public List<RecordAntiNoiseFacilitiesData> queryList(RecordAntiNoiseFacilitiesDataRequest recordAntiNoiseFacilitiesDataRequest);

    /**
     * 分页查询
     * @param recordAntiNoiseFacilitiesDataRequest 查询条件
     * @param pageNum 页数
     * @param pageSize 每页大小
     * @return 返回结果
     */
    public PageResult<RecordAntiNoiseFacilitiesData> queryListPage(RecordAntiNoiseFacilitiesDataRequest recordAntiNoiseFacilitiesDataRequest, Integer pageNum, Integer pageSize);

    /**
     * 添加
     * @param recordAntiNoiseFacilitiesData 实体
     * @return 返回结果
     */
    public RecordAntiNoiseFacilitiesData add(RecordAntiNoiseFacilitiesData recordAntiNoiseFacilitiesData);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public RecordAntiNoiseFacilitiesData delete(Long id);

    /**
     * 修改
     * @param recordAntiNoiseFacilitiesData 实体
     * @return 返回结果
     */
    public RecordAntiNoiseFacilitiesData update(RecordAntiNoiseFacilitiesData recordAntiNoiseFacilitiesData);
}
