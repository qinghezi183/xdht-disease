package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.RecordControlEffect;
import com.xdht.disease.sys.model.RecordControlEffectData;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordControlEffectDataRequest;

import java.util.List;


/**
 * Created by lzf on 2018/06/04.
 */
public interface RecordControlEffectDataService extends Service<RecordControlEffectData> {

    /**
     * 查询列表
     * @param recordControlEffectDataRequest 查询条件
     * @return 返回结果
     */
    public List<RecordControlEffectData> queryList(RecordControlEffectDataRequest recordControlEffectDataRequest);

    /**
     * 分页查询
     * @param recordControlEffectDataRequest 查询条件
     * @param pageNum 页数
     * @param pageSize 每页大小
     * @return 返回结果
     */
    public PageResult<RecordControlEffectData> queryListPage(RecordControlEffectDataRequest recordControlEffectDataRequest, Integer pageNum, Integer pageSize);

    /**
     * 添加
     * @param recordControlEffectData 实体
     * @return 返回结果
     */
    public  RecordControlEffectData addRecordControlEffectData(RecordControlEffectData recordControlEffectData);

    /**
     * 删除
     * @param id 主键
     * @return 返回结果
     */
    public  RecordControlEffectData deleteRecordControlEffectData(Long id);

    /**
     * 修改
     * @param recordControlEffectData 实体
     * @return 返回结果
     */
    public  RecordControlEffectData updateRecordControlEffectData(RecordControlEffectData recordControlEffectData);

}
