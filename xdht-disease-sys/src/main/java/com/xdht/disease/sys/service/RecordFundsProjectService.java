package com.xdht.disease.sys.service;
import com.xdht.disease.sys.model.RecordFundsProject;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordFundsProjectRequest;

import java.util.List;


/**
 * Created by lzf on 2018/06/05.
 */
public interface RecordFundsProjectService extends Service<RecordFundsProject> {

    /**
     * 查询
     * @param recordFundsProjectRequest 查询条件
     * @return 返回结果
     */
    public List<RecordFundsProject> queryList(RecordFundsProjectRequest recordFundsProjectRequest);

    /**
     * 添加
     * @param recordFundsProject 实体
     * @return 返回结果
     */
    public RecordFundsProject add(RecordFundsProject recordFundsProject);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public RecordFundsProject delete(Long id);

    /**
     * 修改
     * @param recordFundsProject 实体
     * @return 返回结果
     */
    public RecordFundsProject update(RecordFundsProject recordFundsProject);
}
