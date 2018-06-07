package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.SysEmployeeDisease;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.SysEmployeeDiseaseRequest;
import com.xdht.disease.sys.vo.response.SysEmployeeDiseaseResponse;

import java.util.List;


/**
 * Created by lzf on 2018/06/01.
 */
public interface SysEmployeeDiseaseService extends Service<SysEmployeeDisease> {

    /**
     * 分页查询员工职业病
     * @param sysEmployeeDiseaseRequest 查询条件
     * @return 返回结果
     */
    public PageResult<SysEmployeeDisease> querySysEmpDiseasePage(SysEmployeeDiseaseRequest sysEmployeeDiseaseRequest);

    /**
     * 查询员工职业病
     * @param sysEmployeeDisease 查询条件
     * @return 返回结果
     */
    public List<SysEmployeeDisease> querySysEmpDiseaseList(SysEmployeeDisease sysEmployeeDisease);

    /**
     * 添加员工职业病
     * @param sysEmployeeDisease 员工职业病实体
     * @return 返回结果
     */
    public SysEmployeeDiseaseResponse addEmployeeDisease(SysEmployeeDisease sysEmployeeDisease);

    /**
     * 删除员工职业病
     * @param id 主键id
     * @return 返回结果
     */
    public SysEmployeeDiseaseResponse deleteEmployeeDisease(Long id);

    /**
     * 修改员工职业病
     * @param sysEmployeeDisease 员工职业病实体
     * @return 返回结果
     */
    public SysEmployeeDiseaseResponse updateEmployeeDisease(SysEmployeeDisease sysEmployeeDisease);


}
