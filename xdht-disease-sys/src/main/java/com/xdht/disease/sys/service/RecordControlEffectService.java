package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordControlEffect;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordControlEffectRequest;

import java.util.List;


/**
 * Created by lzf on 2018/06/04.
 */
public interface RecordControlEffectService extends Service<RecordControlEffect> {

    /**
     * 查询列表
     * @param recordControlEffectRequest 查询条件
     * @return 返回结果
     */
    public List<RecordControlEffect> queryList(RecordControlEffectRequest recordControlEffectRequest);

    /**
     * 分页查询
     * @param recordControlEffectRequest 查询条件
     * @param pageNum 页数
     * @param pageSize 每页大小
     * @return 返回结果
     */
    public PageResult<RecordControlEffect> queryListPage(RecordControlEffectRequest recordControlEffectRequest, Integer pageNum, Integer pageSize);
    /**
     * 添加
     * @param recordControlEffect 实体
     * @return 返回结果
     */
    public  RecordControlEffect addRecordControlEffect(RecordControlEffect recordControlEffect);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public RecordControlEffect deleteRecordControlEffect(Long id);

    /**
     * 修改
     * @param recordControlEffect 实体
     * @return 返回结果
     */
    public RecordControlEffect updateRecordControlEffect(RecordControlEffect recordControlEffect);

}
