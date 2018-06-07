package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.SysEmployeeDisease;
import com.xdht.disease.sys.model.SysEmployeeJob;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.SysEmployeeJobRequest;
import com.xdht.disease.sys.vo.response.SysEmployeeJobResponse;

import java.util.List;


/**
 * Created by lzf on 2018/06/01.
 */
public interface SysEmployeeJobService extends Service<SysEmployeeJob> {

    /**
     * 分页查询员工工作
     * @param sysEmployeeIobRequest 查询条件
     * @return 返回结果
     */
    public PageResult<SysEmployeeJob> querySysEmpJobPage(SysEmployeeJobRequest sysEmployeeIobRequest);

    /**
     * 查询员工工作
     * @param sysEmployeeIob 查询条件
     * @return 返回结果
     */
    public List<SysEmployeeJob> querySysEmpJobList(SysEmployeeJob sysEmployeeIob);

    /**
     * 添加员工工作
     * @param sysEmployeeJob 员工工作实体
     * @return 返回结果
     */
    public SysEmployeeJobResponse addEmployeeJob(SysEmployeeJob sysEmployeeJob);

    /**
     * 删除员工工作
     * @param id 主键id
     * @return 返回结果
     */
    public SysEmployeeJobResponse deleteEmployeeJob(Long id);

    /**
     * 修改员工工作
     * @param sysEmployeeJob 员工工作实体
     * @return 返回结果
     */
    public SysEmployeeJobResponse updateEmployeeJob(SysEmployeeJob sysEmployeeJob);


}
