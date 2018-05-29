package com.xdht.disease.common.core;

import com.xdht.disease.common.exception.ServiceException;
import com.xdht.disease.common.model.User;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Condition;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.List;

/**
 * 基于通用MyBatis Mapper插件的Service接口的实现
 * @author lzf
 */
public abstract class AbstractService<T> implements Service<T> {

    @Autowired
    protected Mapper<T> mapper;

    @Autowired
    private UserService userService;
    /**
     * 当前泛型真实类型的Class
     */
    private Class<T> modelClass;

    public AbstractService() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        modelClass = (Class<T>) pt.getActualTypeArguments()[0];
    }

    @Override
    public void save(T model) {
        try {
            User user = userService.getUser();
            if (user != null) {
                Field[] fs = model.getClass().getDeclaredFields();

                for (Field f : fs) {
                    if ("createBy".equals(f.getName()) || "updateBy".equals(f.getName())) {
                        f.setAccessible(true);
                        f.set(model,user.getId());
                    }
                    if ("createDate".equals(f.getName())|| "updateDate".equals(f.getName())) {
                        f.setAccessible(true);
                        f.set(model,new Date());
                    }
                }
            }

        } catch (Exception e) {

        }

        mapper.insertSelective(model);
    }

    @Override
    public void saveUseGenerateKey(T model) {
        try {
            User user = userService.getUser();
            if (user != null) {
                Field[] fs = model.getClass().getDeclaredFields();

                for (Field f : fs) {
                    if ("createBy".equals(f.getName()) || "updateBy".equals(f.getName())) {
                        f.setAccessible(true);
                        f.set(model,user.getId());
                    }
                    if ("createDate".equals(f.getName())|| "updateDate".equals(f.getName())) {
                        f.setAccessible(true);
                        f.set(model,new Date());
                    }
                }
            }

        } catch (Exception e) {

        }

        mapper.insertUseGeneratedKeys(model);
    }


    @Override
    public void save(List<T> models) {

        try {
            User user = userService.getUser();
            if (user != null) {
                for(T model :models){
                    Field[] fs = model.getClass().getDeclaredFields();
                    for (Field f : fs) {
                        if ("createBy".equals(f.getName()) || "updateBy".equals(f.getName())) {
                            f.setAccessible(true);
                            f.set(model,user.getId());
                        }
                        if ("createDate".equals(f.getName())|| "updateDate".equals(f.getName())) {
                            f.setAccessible(true);
                            f.set(model,new Date());
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
        mapper.insertList(models);
    }

    @Override
    public void deleteById(long id) {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIds(String ids) {
        mapper.deleteByIds(ids);
    }

    @Override
    public void update(T model) {
        try {
            User user = userService.getUser();
            if (user != null) {
                Field[] fs = model.getClass().getDeclaredFields();

                for (Field f : fs) {
                    if ("updateBy".equals(f.getName())) {
                        f.setAccessible(true);
                        f.set(model,user.getId());
                    }
                    if ("updateDate".equals(f.getName())) {
                        f.setAccessible(true);
                        f.set(model,new Date());
                    }
                }
            }
        } catch (Exception e) {

        }
        mapper.updateByPrimaryKeySelective(model);
    }

    @Override
    public T findById(long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public T findBy(String fieldName, Object value) throws TooManyResultsException {
        try {
            T model = modelClass.newInstance();
            Field field = modelClass.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(model, value);
            return mapper.selectOne(model);
        } catch (ReflectiveOperationException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public List<T> findByIds(String ids) {
        return mapper.selectByIds(ids);
    }

    @Override
    public List<T> findByCondition(Condition condition) {
        return mapper.selectByCondition(condition);
    }

    @Override
    public List<T> findAll() {
        return mapper.selectAll();
    }

    @Override
    public T findBy(T model) throws TooManyResultsException{
        return mapper.selectOne(model);
    }

    @Override
    public List<T> select(T model){
        return mapper.select(model);
    }

    @Override
    public int selectCount(T model){
        return mapper.selectCount(model);
    }
}
