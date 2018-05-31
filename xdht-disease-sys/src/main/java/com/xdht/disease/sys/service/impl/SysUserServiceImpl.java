package com.xdht.disease.sys.service.impl;

import com.xdht.disease.sys.dao.SysUserMapper;
import com.xdht.disease.sys.model.SysUser;
import com.xdht.disease.sys.service.SysUserService;
import com.xdht.disease.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by lzf on 2018/05/31.
 */
@Service
@Transactional
public class SysUserServiceImpl extends AbstractService<SysUser> implements SysUserService

    @Autowired
    private SysUserMapper sysUserMapper;

}
