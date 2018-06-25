package com.xdht.disease.stu.service.impl;

import com.xdht.disease.stu.dao.TestStuMapper;
import com.xdht.disease.stu.model.TestStu;
import com.xdht.disease.stu.service.TestStuService;
import com.xdht.disease.common.core.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by gugx on 2018/06/19.
 */
@Service
@Transactional
public class TestStuServiceImpl extends AbstractService<TestStu> implements TestStuService {

    @Autowired
    private TestStuMapper testStuMapperMapper;

    /**
     * 新增测试-添加
     */
    public void insertStu(TestStu testStu){
        testStuMapperMapper.insertStu(testStu);
    }
}
