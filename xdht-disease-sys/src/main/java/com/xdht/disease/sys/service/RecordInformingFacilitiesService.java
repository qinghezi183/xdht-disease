package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordInformingFacilities;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordInformingFacilitiesRequest;

import java.util.List;


/**
 * Created by lzf on 2018/06/05.
 */
public interface RecordInformingFacilitiesService extends Service<RecordInformingFacilities> {

    /**
     * 查询
     * @param recordRequest 查询条件
     * @return 返回结果
     */
    public List<RecordInformingFacilities> queryList(RecordInformingFacilitiesRequest recordRequest);

    /**
     * 分页查询
     * @param recordRequest 查询条件
     * @param pageNum   页数
     * @param pageSize  每页大小
     * @return 返回结果
     */
    public PageResult<RecordInformingFacilities> queryListPage(RecordInformingFacilitiesRequest recordRequest, Integer pageNum, Integer pageSize);

    /**
     * 添加
     * @param recordInformingFacilities 实体
     * @return 返回结果
     */
    public RecordInformingFacilities add(RecordInformingFacilities recordInformingFacilities);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public RecordInformingFacilities delete(Long id);

    /**
     * 修改
     * @param recordInformingFacilities 实体
     * @return 返回结果
     */
    public RecordInformingFacilities update(RecordInformingFacilities recordInformingFacilities);
}
