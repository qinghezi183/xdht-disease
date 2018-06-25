package com.xdht.disease.stu.dao;

import com.xdht.disease.common.core.Mapper;
import com.xdht.disease.stu.model.TestStu;

public interface TestStuMapper extends Mapper<TestStu> {
    /**
     * 新增测试-添加
     */
    public void insertStu(TestStu testStu);
}