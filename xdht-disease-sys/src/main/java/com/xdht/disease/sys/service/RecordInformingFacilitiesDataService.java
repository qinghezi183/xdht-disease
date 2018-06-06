package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordInformingFacilitiesData;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordInformingFacilitiesDataRequest;

import java.util.List;


/**
 * Created by lzf on 2018/06/05.
 */
public interface RecordInformingFacilitiesDataService extends Service<RecordInformingFacilitiesData> {

    /**
     * 查询
     * @param recordDataRequest 查询条件
     * @return 返回结果
     */
    public List<RecordInformingFacilitiesData> queryList(RecordInformingFacilitiesDataRequest recordDataRequest);

    /**
     * 分页查询
     * @param recordDataRequest 查询条件
     * @param pageNum   页数
     * @param pageSize  每页大小
     * @return 返回结果
     */
    public PageResult<RecordInformingFacilitiesData> queryListPage(RecordInformingFacilitiesDataRequest recordDataRequest, Integer pageNum, Integer pageSize);

    /**
     * 添加
     * @param recordInformingFacilitiesData 实体
     * @return 返回结果
     */
    public RecordInformingFacilitiesData add(RecordInformingFacilitiesData recordInformingFacilitiesData);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public RecordInformingFacilitiesData delete(Long id);

    /**
     * 修改
     * @param recordInformingFacilitiesData 实体
     * @return 返回结果
     */
    public RecordInformingFacilitiesData update(RecordInformingFacilitiesData recordInformingFacilitiesData);
}
