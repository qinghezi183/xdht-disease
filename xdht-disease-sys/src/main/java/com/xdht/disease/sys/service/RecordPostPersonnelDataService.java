package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordPostPersonnelData;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordPostPersonnelDataRequest;

import java.util.List;


/**
 * Created by lzf on 2018/06/05.
 */
public interface RecordPostPersonnelDataService extends Service<RecordPostPersonnelData> {

    /**
     * 查询
     * @param recordDataRequest 查询条件
     * @return 返回结果
     */
    public List<RecordPostPersonnelData> queryList(RecordPostPersonnelDataRequest recordDataRequest);

    /**
     * 分页查询
     * @param recordDataRequest 查询条件
     * @param pageNum 页数
     * @param pageSize 每页大小
     * @return 返回结果
     */
    public PageResult<RecordPostPersonnelData> queryListPage(RecordPostPersonnelDataRequest recordDataRequest, Integer pageNum, Integer pageSize);

    /**
     * 添加
     * @param recordPostPersonnelData 实体
     * @return 返回结果
     */
    public RecordPostPersonnelData add(RecordPostPersonnelData recordPostPersonnelData);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public RecordPostPersonnelData delete(Long id);

    /**
     * 修改
     * @param recordPostPersonnelData 实体
     * @return 返回结果
     */
    public RecordPostPersonnelData update(RecordPostPersonnelData recordPostPersonnelData);
}
