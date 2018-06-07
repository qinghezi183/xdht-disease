package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.SysEmployeeCase;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.SysEmployeeCaseRequest;
import com.xdht.disease.sys.vo.response.SysEmployeeCaseResponse;

import java.util.List;


/**
 * Created by lzf on 2018/06/01.
 */
public interface SysEmployeeCaseService extends Service<SysEmployeeCase> {

    /**
     * 分页查询员工疾病列表
     * @param sysEmployeeCaseRequest 查询条件
     * @return 返回结果
     */
    public PageResult<SysEmployeeCase> querySysEmpCasePage(SysEmployeeCaseRequest sysEmployeeCaseRequest);

    /**
     * 查询员工疾病列表
     * @param sysEmployeeCase 查询条件
     * @return 返回结果
     */
    public List<SysEmployeeCase> querySysEmpCaseList(SysEmployeeCase sysEmployeeCase);
    /**
     * 添加员工疾病
     * @param sysEmployeeCase 员工疾病实体
     * @return 返回结果
     */
    public SysEmployeeCaseResponse addEmployeeCase(SysEmployeeCase sysEmployeeCase);

    /**
     * 删除员工疾病
     * @param id 主键id
     * @return 返回结果
     */
    public SysEmployeeCaseResponse deleteEmployeeCase(Long id);

    /**
     * 修改员工疾病实体
     * @param sysEmployeeCase 员工疾病实体
     * @return 返回结果
     */
    public SysEmployeeCaseResponse updateEmployeeCase(SysEmployeeCase sysEmployeeCase);


}
