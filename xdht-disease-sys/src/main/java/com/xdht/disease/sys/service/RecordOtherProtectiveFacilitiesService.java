package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordOtherProtectiveFacilities;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordOtherProtectiveFacilitiesRequest;

import java.util.List;


/**
 * Created by lzf on 2018/06/05.
 */
public interface RecordOtherProtectiveFacilitiesService extends Service<RecordOtherProtectiveFacilities> {

    /**
     * 查询
     * @param recordRequest 查询条件
     * @return 返回结果
     */
    public List<RecordOtherProtectiveFacilities> queryList(RecordOtherProtectiveFacilitiesRequest recordRequest);

    /**
     * 分页查询
     * @param recordRequest 查询条件
     * @param pageNum   页数
     * @param pageSize  每页大小
     * @return 返回结果
     */
    public PageResult<RecordOtherProtectiveFacilities> queryListPage(RecordOtherProtectiveFacilitiesRequest recordRequest, Integer pageNum, Integer pageSize);

    /**
     * 添加
     * @param recordOtherProtectiveFacilities   实体
     * @return 返回结果
     */
    public RecordOtherProtectiveFacilities add(RecordOtherProtectiveFacilities recordOtherProtectiveFacilities);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public RecordOtherProtectiveFacilities delete(Long id);

    /**
     * 修改
     * @param recordOtherProtectiveFacilities 实体
     * @return 返回结果
     */
    public RecordOtherProtectiveFacilities update(RecordOtherProtectiveFacilities recordOtherProtectiveFacilities);
}
