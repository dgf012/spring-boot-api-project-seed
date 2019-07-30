package ${basePackage}.web.${tableClass.tableName?replace('_','.')};

import ${basePackage}.core.PageResponse;
import ${basePackage}.core.Result;
import ${basePackage}.model.${tableClass.shortClassName};
import ${basePackage}.service.${tableClass.shortClassName}Service;
import ${basePackage}.web.${tableClass.tableName?replace('_','.')}.${tableClass.shortClassName}VO;
import ${basePackage}.web.${tableClass.tableName?replace('_','.')}.${tableClass.shortClassName}ListVO;
import ${basePackage}.web.${tableClass.tableName?replace('_','.')}.${tableClass.shortClassName}SearchVO;
import ${basePackage}.validation.UpdateGroups;
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
@Api(tags = "${tableClass.introspectedTable.remarks}", description = "${tableClass.introspectedTable.remarks}")
@RestController
@RequestMapping("/${tableClass.tableName?replace('_','/')}")
public class ${tableClass.shortClassName}Controller {
    @Resource
    private ${tableClass.shortClassName}Service ${tableClass.variableName}Service;

    @ApiOperation(value = "新增${tableClass.introspectedTable.remarks}", notes = "新增${tableClass.introspectedTable.remarks}")
    @PostMapping("/add")
    public Result add(@Valid @RequestBody ${tableClass.shortClassName}VO ${tableClass.variableName}VO) {
        ${tableClass.shortClassName} ${tableClass.variableName} = new ${tableClass.shortClassName}();
        BeanUtils.copyProperties(${tableClass.variableName}VO, ${tableClass.variableName});
        ${tableClass.variableName}Service.save(${tableClass.variableName});
        log.info("新增${tableClass.introspectedTable.remarks}: {}", ${tableClass.variableName});
        return Result.success();
    }

    @ApiOperation(value = "删除${tableClass.introspectedTable.remarks}", notes = "删除${tableClass.introspectedTable.remarks}")
    @ApiImplicitParam(name = "id", value = "ID", example = "1", required = true)
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        ${tableClass.variableName}Service.deleteById(id);
        log.info("删除${tableClass.introspectedTable.remarks},id : {}", id);
        return Result.success();
    }

    @ApiOperation(value = "更新${tableClass.introspectedTable.remarks}", notes = "更新${tableClass.introspectedTable.remarks}")
    @PutMapping("update")
    public Result update(@Validated({UpdateGroups.class, Default.class}) @RequestBody ${tableClass.shortClassName}VO ${tableClass.variableName}VO) {
        ${tableClass.shortClassName} ${tableClass.variableName} = new ${tableClass.shortClassName}();
        BeanUtils.copyProperties(${tableClass.variableName}VO, ${tableClass.variableName});
        ${tableClass.variableName}Service.update(${tableClass.variableName});
        log.info("更新${tableClass.introspectedTable.remarks}: {}", ${tableClass.variableName});
        return Result.success();
    }

    @ApiOperation(value = "查看${tableClass.introspectedTable.remarks}详情", notes = "查看${tableClass.introspectedTable.remarks}详情")
    @ApiImplicitParam(name = "id", value = "ID", example = "1", required = true)
    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        ${tableClass.shortClassName} ${tableClass.variableName} = ${tableClass.variableName}Service.findById(id);
        ${tableClass.shortClassName}VO ${tableClass.variableName}VO = new ${tableClass.shortClassName}VO();
        BeanUtils.copyProperties(${tableClass.variableName}, ${tableClass.variableName}VO);
        return Result.success(${tableClass.variableName}VO);
    }

    @ApiOperation(value = "查看${tableClass.introspectedTable.remarks}列表", notes = "查看${tableClass.introspectedTable.remarks}列表")
    @PostMapping("/list")
    public Result<PageResponse<${tableClass.shortClassName}ListVO>> list(@RequestBody ${tableClass.shortClassName}SearchVO searchVO) {
        //TODO 根据实际修改
        WeekendSqls<${tableClass.shortClassName}> custom = WeekendSqls.custom();
        custom.andEqualTo(SysUsers::getId, searchVO.getId());
        Example example = Example.builder(${tableClass.shortClassName}.class)
            .where(custom)
            .orderByDesc("id")
            .build();
        PageInfo<${tableClass.shortClassName}> pageInfo = PageHelper.startPage(searchVO.getPageNum(), searchVO.getPageSize()).doSelectPageInfo(() -> ${tableClass.variableName}Service.findByExample(example));

        List<${tableClass.shortClassName}ListVO> voList = new ArrayList<>();
        for (${tableClass.shortClassName} ${tableClass.variableName} : pageInfo.getList()) {
            ${tableClass.shortClassName}ListVO vo = new ${tableClass.shortClassName}ListVO();
            BeanUtils.copyProperties(${tableClass.variableName}, vo);
            voList.add(vo);
        }
        return Result.success(PageResponse.getPage(pageInfo, voList));
    }
}
