package com.xdht.disease.sys.service;
import com.xdht.disease.common.core.PageResult;
import com.xdht.disease.sys.model.SysPost;
import com.xdht.disease.common.core.Service;
import com.xdht.disease.sys.vo.request.SysPostRequest;

import java.util.List;


/**
 * Created by lzf on 2018/06/06.
 */
public interface SysPostService extends Service<SysPost> {

    /**
     * 查询
     * @param sysPostRequest 查询条件
     * @return 返回结果
     */
    public List<SysPost> queryList(SysPostRequest sysPostRequest);

    /**
     * 分页查询
     * @param sysPostRequest 查询条件
     * @param pageNum 页数
     * @param pageSize 每页大小
     * @return 返回结果
     */
    public PageResult<SysPost> queryListPage(SysPostRequest sysPostRequest, Integer pageNum, Integer pageSize);

    /**
     * 添加
     * @param sysPost 实体
     * @return 返回结果
     */
    public SysPost add(SysPost sysPost);

    /**
     * 删除
     * @param id 主键id
     * @return 返回结果
     */
    public SysPost delete(Long id);

    /**
     * 修改
     * @param sysPost 实体
     * @return 返回结果
     */
    public SysPost update(SysPost sysPost);
}
