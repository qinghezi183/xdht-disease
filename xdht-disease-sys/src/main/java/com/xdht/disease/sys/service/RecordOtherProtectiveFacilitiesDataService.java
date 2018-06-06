package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordOtherProtectiveFacilitiesData;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordOtherProtectiveFacilitiesDataRequest;

import java.util.List;


/**
 * Created by lzf on 2018/06/05.
 */
public interface RecordOtherProtectiveFacilitiesDataService extends Service<RecordOtherProtectiveFacilitiesData> {

    /**
     * 查询
     * @param recordDataRequest 查询条件
     * @return 返回结果
     */
    public List<RecordOtherProtectiveFacilitiesData> queryList(RecordOtherProtectiveFacilitiesDataRequest recordDataRequest);

    /**
     * 分页查询
     * @param recordDataRequest 查询条件
     * @param pageNum  页数
     * @param pageSize 每页大小
     * @return 返回结果
     */
    public PageResult<RecordOtherProtectiveFacilitiesData> queryListPage(RecordOtherProtectiveFacilitiesDataRequest recordDataRequest, Integer pageNum, Integer pageSize);

    /**
     * 添加
     * @param recordOtherProtectiveFacilitiesData 实体
     * @return 返回结果
     */
    public  RecordOtherProtectiveFacilitiesData add(RecordOtherProtectiveFacilitiesData recordOtherProtectiveFacilitiesData);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public  RecordOtherProtectiveFacilitiesData delete(Long id);

    /**
     * 修改
     * @param recordOtherProtectiveFacilitiesData 实体
     * @return 返回结果
     */
    public  RecordOtherProtectiveFacilitiesData update(RecordOtherProtectiveFacilitiesData recordOtherProtectiveFacilitiesData);
}
