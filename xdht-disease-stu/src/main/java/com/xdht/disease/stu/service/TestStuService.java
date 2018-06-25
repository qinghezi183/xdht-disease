package com.xdht.disease.stu.service;
import com.xdht.disease.stu.model.TestStu;
import com.xdht.disease.common.core.Service;


/**
 * Created by gugx on 2018/06/19.
 */
public interface TestStuService extends Service<TestStu> {

    /**
     * 新增测试-添加
     */
    public void insertStu(TestStu testStu);
}
