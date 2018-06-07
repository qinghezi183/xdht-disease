package com.xdht.disease.sys.service;
import com.github.pagehelper.Page;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordTemperatureProtectionFacilities;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordTemperatureProtectionFacilitiesRequest;

import java.util.List;


/**
 * Created by lzf on 2018/06/06.
 */
public interface RecordTemperatureProtectionFacilitiesService extends Service<RecordTemperatureProtectionFacilities> {

    /**
     * 查询
     * @param recordRequest 查询条件
     * @return 返回结果
     */
    public List<RecordTemperatureProtectionFacilities> queryList(RecordTemperatureProtectionFacilitiesRequest recordRequest);

    /**
     * 分页查询
     * @param recordRequest 查询条件
     * @param pageNum  页数
     * @param pageSize 每页大小
     * @return 返回结果
     */
    public PageResult<RecordTemperatureProtectionFacilities> queryListPage(RecordTemperatureProtectionFacilitiesRequest recordRequest, Integer pageNum, Integer pageSize);

    /**
     * 添加
     * @param record 实体
     * @return 返回结果
     */
    public RecordTemperatureProtectionFacilities add(RecordTemperatureProtectionFacilities record);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public RecordTemperatureProtectionFacilities delete(Long id);

    /**
     * 修改
     * @param record 实体
     * @return 返回结果
     */
    public RecordTemperatureProtectionFacilities update(RecordTemperatureProtectionFacilities record);
}
