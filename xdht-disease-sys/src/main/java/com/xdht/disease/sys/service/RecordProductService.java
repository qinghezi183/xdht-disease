package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordProduct;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordProductRequest;

import java.util.List;


/**
 * Created by lzf on 2018/06/05.
 */
public interface RecordProductService extends Service<RecordProduct> {

    /**
     * 查询
     * @param recordProductRequest 查询条件
     * @return 返回结果
     */
    public List<RecordProduct> queryList(RecordProductRequest recordProductRequest);

    /**
     * 分页查询
     * @param recordProductRequest 查询条件
     * @param pageNum  页数
     * @param pageSize  每页大小
     * @return 返回结果
     */
    public PageResult<RecordProduct> queryListPage(RecordProductRequest recordProductRequest, Integer pageNum, Integer pageSize);

    /**
     * 添加
     * @param recordProduct 实体
     * @return 返回结果
     */
    public  RecordProduct add(RecordProduct recordProduct);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public  RecordProduct delete(Long id);

    /**
     * 修改
     * @param recordProduct 实体
     * @return 返回结果
     */
    public  RecordProduct update(RecordProduct recordProduct);
}
