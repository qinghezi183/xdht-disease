package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordHazardFactorsData;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordHazardFactorsDataRequest;

import java.util.List;


/**
 * Created by lzf on 2018/06/05.
 */
public interface RecordHazardFactorsDataService extends Service<RecordHazardFactorsData> {

    /**
     * 查询
     * @param recordHazardFactorsDataRequest 查询条件
     * @return 返回结果
     */
    public List<RecordHazardFactorsData> queryList(RecordHazardFactorsDataRequest recordHazardFactorsDataRequest);

    /**
     * 分页查询
     * @param recordHazardFactorsDataRequest 查询条件
     * @param pageNum  页数
     * @param pageSize  每页大小
     * @return 返回结果
     */
    public PageResult<RecordHazardFactorsData> queryListPage(RecordHazardFactorsDataRequest recordHazardFactorsDataRequest, Integer pageNum, Integer pageSize);

    /**
     * 添加
     * @param recordHazardFactorsData 实体
     * @return 返回结果
     */
    public RecordHazardFactorsData add(RecordHazardFactorsData recordHazardFactorsData);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public RecordHazardFactorsData delete(Long id);

    /**
     * 修改
     * @param recordHazardFactorsData 实体
     * @return 返回结果
     */
    public RecordHazardFactorsData update(RecordHazardFactorsData recordHazardFactorsData);
}
