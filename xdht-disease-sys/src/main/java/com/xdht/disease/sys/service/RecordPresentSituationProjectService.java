package com.xdht.disease.sys.service;
import com.xdht.disease.sys.model.RecordPresentSituationProject;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordPresentSituationProjectRequest;

import java.util.List;


/**
 * Created by lzf on 2018/06/05.
 */
public interface RecordPresentSituationProjectService extends Service<RecordPresentSituationProject> {

    /**
     * 查询
     * @param recordPresentSituationProjectRequest 查询条件
     * @return 返回结果
     */
    public List<RecordPresentSituationProject> queryList(RecordPresentSituationProjectRequest recordPresentSituationProjectRequest);

    /**
     * 添加
     * @param recordPresentSituationProject 实体
     * @return 返回结果
     */
    public RecordPresentSituationProject add(RecordPresentSituationProject recordPresentSituationProject);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public RecordPresentSituationProject delete(Long id);

    /**
     * 修改
     * @param recordPresentSituationProject 实体
     * @return 返回结果
     */
    public RecordPresentSituationProject update(RecordPresentSituationProject recordPresentSituationProject);
}
