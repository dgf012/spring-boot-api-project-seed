package com.company.project.project.service.serviceimpl;

import com.company.project.project.core.AbstractService;
import com.company.project.project.mapper.SysUserMapper;
import com.company.project.project.model.SysUser;
import com.company.project.project.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* 通用 Mapper 代码生成器
*
* @author mapper-generator
*/
@Slf4j
@Service
public class SysUserServiceImpl extends AbstractService<SysUser> implements SysUserService {
    @Resource
    private SysUserMapper sysUserMapper;

}
