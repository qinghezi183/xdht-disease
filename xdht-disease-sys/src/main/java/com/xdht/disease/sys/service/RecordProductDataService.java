package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordProductData;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordProductDataRequest;

import java.util.List;


/**
 * Created by lzf on 2018/06/05.
 */
public interface RecordProductDataService extends Service<RecordProductData> {

    /**
     * 查询
     * @param recordProductDataRequest 查询条件
     * @return 返回结果
     */
    public List<RecordProductData> queryList(RecordProductDataRequest recordProductDataRequest);

    /**
     * 分页查询
     * @param recordProductDataRequest 查询条件
     * @param pageNum 页数
     * @param pageSize 每页大小
     * @return 返回结果
     */
    public PageResult<RecordProductData> queryListPage(RecordProductDataRequest recordProductDataRequest, Integer pageNum, Integer pageSize);

    /**
     * 添加
     * @param recordProductData 实体
     * @return 返回结果
     */
    public RecordProductData add(RecordProductData recordProductData);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public RecordProductData delete(Long id);

    /**
     * 修改
     * @param recordProductData 实体
     * @return 返回结果
     */
    public RecordProductData update(RecordProductData recordProductData);
}
