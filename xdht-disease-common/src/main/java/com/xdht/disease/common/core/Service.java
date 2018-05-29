package com.xdht.disease.common.core;

import org.apache.ibatis.exceptions.TooManyResultsException;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

/**
 * Service 层 基础接口，其他Service 接口 请继承该接口
 * @author lzf
 */
public interface Service<T> {
    /**
     * 持久化
     * @param model
     */
    void save(T model);

    /**
     * 持久化 并返回自增主键
     * @param model
     */
    void saveUseGenerateKey(T model);

    /**
     * 批量持久化
     * @param models
     */
    void save(List<T> models);

    /**
     * 通过主鍵刪除
     * @param id
     */
    void deleteById(long id);

    /**
     * /批量刪除 eg：ids -> “1,2,3,4”
     * @param ids
     */
    void deleteByIds(String ids);

    /**
     * 更新
     * @param model
     */
    void update(T model);

    /**
     * 通过ID查找
     * @param id
     * @return
     */
    T findById(long id);

    /**
     * 通过Model中某个成员变量名称（非数据表中column的名称）查找,value需符合unique约束
     * @param fieldName
     * @param value
     * @return
     * @throws TooManyResultsException
     */
    T findBy(String fieldName, Object value) throws TooManyResultsException;

    /**
     * 通过多个ID查找//eg：ids -> “1,2,3,4”
     * @param ids
     * @return
     */
    List<T> findByIds(String ids);

    /**
     * 根据条件查找
     * @param condition
     * @return
     */
    List<T> findByCondition(Condition condition);

    /**
     * 获取所有
     * @return
     */
    List<T> findAll();

    /**
     * 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
     * @param model
     * @return
     * @throws TooManyResultsException
     */
    T findBy(T model) throws TooManyResultsException;

    /**
     * 根据实体中的属性值进行查询，查询条件使用等号
     * @param model
     * @return
     */
    List<T> select(T model);

    /**
     * 根据实体中的属性查询总数，查询条件使用等号
     * @param model
     * @return
     */
    int selectCount(T model);
}
