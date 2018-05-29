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

    @Pointcut("execution (* com.tbi.clearing.*.service.*.select*(..)) || execution (* com.tbi.clearing.*.service.*.count*(..))  || execution (* com.tbi.clearing.*.service.*.find*(..)) || execution (* com.tbi.clearing.*.service.*.query*(..))")
    public void readMethodPointcut() {}

    @Pointcut("execution (* com.tbi.clearing.*.service.*.insert*(..)) || execution (* com.tbi.clearing.*.service.*.update*(..)) || execution (* com.tbi.clearing.*.service.*.delete*(..)) || execution (* com.tbi.clearing.*.service.*.save*(..))")
    public void writeMethodPointcut() {}

    @Pointcut("execution (* com.tbi.clearing.*.service.*.insert*(..)) || execution (* com.tbi.clearing.*.service.*.update*(..)) || execution (* com.tbi.clearing.*.service.*.delete*(..)) || execution (* com.tbi.clearing.*.service.*.save*(..))")
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