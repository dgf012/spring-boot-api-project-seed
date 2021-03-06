package com.company.project.project.web.sys.sysuser;

import com.company.project.project.core.PageResponse;
import com.company.project.project.core.Result;
import com.company.project.project.model.SysUser;
import com.company.project.project.service.SysUserService;
import com.company.project.project.validation.UpdateGroups;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.weekend.WeekendSqls;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.groups.Default;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Api(tags = "", description = "")
@RestController
@RequestMapping("/sys/sysUser")
public class SysUserController {
    @Resource
    private SysUserService sysUserService;

    @ApiOperation(value = "新增", notes = "新增")
    @PostMapping("/add")
    public Result add(@Valid @RequestBody SysUserVO sysUserVO) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(sysUserVO, sysUser);
        sysUserService.save(sysUser);
        log.info("新增: {}", sysUser);
        return Result.success();
    }

    @ApiOperation(value = "删除", notes = "删除")
    @ApiImplicitParam(name = "id", value = "ID", example = "1", required = true)
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        sysUserService.deleteById(id);
        log.info("删除,id : {}", id);
        return Result.success();
    }

    @ApiOperation(value = "更新", notes = "更新")
    @PutMapping("update")
    public Result update(@Validated({UpdateGroups.class, Default.class}) @RequestBody SysUserVO sysUserVO) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(sysUserVO, sysUser);
        sysUserService.update(sysUser);
        log.info("更新: {}", sysUser);
        return Result.success();
    }

    @ApiOperation(value = "查看详情", notes = "查看详情")
    @ApiImplicitParam(name = "id", value = "ID", example = "1", required = true)
    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        SysUser sysUser = sysUserService.findById(id);
        SysUserVO sysUserVO = new SysUserVO();
        BeanUtils.copyProperties(sysUser, sysUserVO);
        return Result.success(sysUserVO);
    }

    @ApiOperation(value = "查看列表", notes = "查看列表")
    @PostMapping("/list")
    public Result<PageResponse<SysUserListVO>> list(@RequestBody SysUserSearchVO searchVO) {
        //TODO 根据实际修改
        WeekendSqls<SysUser> custom = WeekendSqls.custom();
        custom.andEqualTo(SysUser::getId, searchVO.getId());
        Example example = Example.builder(SysUser.class)
            .where(custom)
            .orderByDesc("id")
            .build();
        PageInfo<SysUser> pageInfo = PageHelper.startPage(searchVO.getPageNum(), searchVO.getPageSize()).doSelectPageInfo(() -> sysUserService.findByExample(example));

        List<SysUserListVO> voList = new ArrayList<>();
        for (SysUser sysUser : pageInfo.getList()) {
            SysUserListVO vo = new SysUserListVO();
            BeanUtils.copyProperties(sysUser, vo);
            voList.add(vo);
        }
        return Result.success(PageResponse.getPage(pageInfo, voList));
    }
}
