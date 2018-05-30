package com.xdht.disease.common.configure;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

/**
 *
 * @author lzf
 * @date 2017/9/4
 */
@Component
@EnableAspectJAutoProxy(exposeProxy=true,proxyTargetClass=true)
@Aspect
public class DynamicDataSourceAspect implements PriorityOrdered {

    @Pointcut("execution (* com.xdht.disease.*.service.*.select*(..)) || execution (* com.xdht.disease.*.service.*.count*(..))  || execution (* com.xdht.disease.*.service.*.find*(..)) || execution (* com.xdht.disease.*.service.*.query*(..))")
    public void readMethodPointcut() {}

    @Pointcut("execution (* com.xdht.disease.*.service.*.insert*(..)) || execution (* com.xdht.disease.*.service.*.update*(..)) || execution (* com.xdht.disease.*.service.*.delete*(..)) || execution (* com.xdht.disease.*.service.*.save*(..))")
    public void writeMethodPointcut() {}

    @Pointcut("execution (* com.xdht.disease.*.service.*.insert*(..)) || execution (* com.xdht.disease.*.service.*.update*(..)) || execution (* com.xdht.disease.*.service.*.delete*(..)) || execution (* com.xdht.disease.*.service.*.save*(..))")
    public void obtFrontPointcut() {}

    @Before("readMethodPointcut()")
    public void switchReadDataSource(){
        //切换到读数据源
        DataSourceContextHolder.setType(DataSourceContextHolder.DATA_SOURCE_READ);
    }

    @Before("writeMethodPointcut()")
    public void switchWriteDataSource(){
        //切换到写数据源
        DataSourceContextHolder.setType(DataSourceContextHolder.DATA_SOURCE_WRITE);
    }

    @Override
    public int getOrder() {
        return 1;
    }
}