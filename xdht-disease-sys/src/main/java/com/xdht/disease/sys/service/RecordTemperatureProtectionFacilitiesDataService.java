package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordTemperatureProtectionFacilitiesData;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordTemperatureProtectionFacilitiesDataRequest;

import java.util.List;


/**
 * Created by lzf on 2018/06/06.
 */
public interface RecordTemperatureProtectionFacilitiesDataService extends Service<RecordTemperatureProtectionFacilitiesData> {

    /**
     * 查询
     * @param recordDataRequest 查询条件
     * @return 返回结果
     */
    public List<RecordTemperatureProtectionFacilitiesData> queryList(RecordTemperatureProtectionFacilitiesDataRequest recordDataRequest);

    /**
     * 分页查询
     * @param recordDataRequest 查询条件
     * @param pageNum  页数
     * @param pageSize  每页大小
     * @return 返回结果
     */
    public PageResult<RecordTemperatureProtectionFacilitiesData> queryListPage(RecordTemperatureProtectionFacilitiesDataRequest recordDataRequest, Integer pageNum, Integer pageSize);

    /**
     * 添加
     * @param recordData 实体
     * @return 返回结果
     */
    public RecordTemperatureProtectionFacilitiesData add(RecordTemperatureProtectionFacilitiesData recordData);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public RecordTemperatureProtectionFacilitiesData delete(Long id);

    /**
     * 修改
     * @param recordData 实体
     * @return 返回结果
     */
    public RecordTemperatureProtectionFacilitiesData update(RecordTemperatureProtectionFacilitiesData recordData);
}
