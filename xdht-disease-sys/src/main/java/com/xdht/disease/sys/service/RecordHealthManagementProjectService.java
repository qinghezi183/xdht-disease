package com.xdht.disease.sys.service;
import com.xdht.disease.sys.model.RecordHealthManagementProject;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.RecordHealthManagementProjectRequest;

import java.util.List;


/**
 * Created by lzf on 2018/06/05.
 */
public interface RecordHealthManagementProjectService extends Service<RecordHealthManagementProject> {

    /**
     * 查询
     * @param recordRequest 查询条件
     * @return 返回结果
     */
    public List<RecordHealthManagementProject> queryList(RecordHealthManagementProjectRequest recordRequest);

    /**
     * 添加
     * @param recordHealthManagementProject 实体
     * @return 返回结果
     */
    public RecordHealthManagementProject add(RecordHealthManagementProject recordHealthManagementProject);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public RecordHealthManagementProject delete(Long id);

    /**
     * 修改
     * @param recordHealthManagementProject 实体
     * @return 返回结果
     */
    public RecordHealthManagementProject update(RecordHealthManagementProject recordHealthManagementProject);
}
