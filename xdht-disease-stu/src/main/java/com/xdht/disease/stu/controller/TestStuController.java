package com.xdht.disease.stu.controller;
import com.xdht.disease.stu.model.TestStu;
import com.xdht.disease.stu.service.TestStuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.IdGenerator;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by gugx on 2018/06/19.
*/
@RestController
@RequestMapping("/test/stu")
public class TestStuController {
    @Resource
    private TestStuService testStuService;

    @PostMapping("/add")
    public String add(TestStu testStu) {
        testStuService.insertSelective(testStu);
        return "add";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Integer id) {
        testStuService.deleteByPrimaryKey(id);
        return "delete";
    }

    @PostMapping("/update")
    public String update(TestStu testStu) {
        testStuService.updateByPrimaryKeySelective(testStu);
        return "update";
    }

    @PostMapping("/detail")
    public String detail(TestStu testStu) {
        testStuService.selectOne(testStu);
        return "detail";
    }

    @PostMapping("/list")
    public String list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {

        return "list";
    }

    /**
     * 测试新增
     * @param testStu
     * @return
     */
    @RequestMapping(value = "insertStu",method = RequestMethod.POST )
    @ApiOperation("测试新增")
    public String insertStu(TestStu testStu){
        testStuService.insertStu(testStu);
        return "测试新增成功";
    }
    /**
     * 查询
     */
    @RequestMapping(value = "get/{id}",method =RequestMethod.POST)
    @ApiOperation(value = "查询详情")
    public TestStu get(@PathVariable("id")String id){
        TestStu testStu=new TestStu();
        testStu.setId(id);
        return testStuService.selectOne(testStu);
    }
}
