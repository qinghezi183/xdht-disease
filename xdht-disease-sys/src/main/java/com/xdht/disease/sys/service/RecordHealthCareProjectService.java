package com.xdht.disease.sys.service;

import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.model.RecordHealthCareProject;
import com.xdht.disease.sys.vo.request.RecordHealthCareProjectRequest;

import java.util.List;


/**
 * Created by lzf on 2018/06/05.
 */
public interface RecordHealthCareProjectService extends Service<RecordHealthCareProject> {

    /**
     * 查询
     * @param recordHealthCareProjectRequest 查询条件
     * @return 返回结果
     */
    public List<RecordHealthCareProject>  queryList(RecordHealthCareProjectRequest recordHealthCareProjectRequest);

    /**
     * 添加
     * @param recordHealthCareProject 实体
     * @return 返回结果
     */
    public RecordHealthCareProject  add(RecordHealthCareProject recordHealthCareProject);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public RecordHealthCareProject  delete(Long id);

    /**
     * 修改
     * @param recordHealthCareProject 实体
     * @return 返回结果
     */
    public RecordHealthCareProject update(RecordHealthCareProject recordHealthCareProject);
}
