package ${package};

import ${basePackage}.core.PageRequest;
import ${basePackage}.core.PageResponse;
import ${basePackage}.core.Result;
import ${basePackage}.model.${tableClass.shortClassName};
import ${basePackage}.service.${tableClass.shortClassName}Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "${tableClass.introspectedTable.remarks}", description = "${tableClass.introspectedTable.remarks}")
@RestController
@RequestMapping("/${tableClass.tableName?replace('_','/')}")
public class ${tableClass.shortClassName}Controller {
    @Resource
    private ${tableClass.shortClassName}Service ${tableClass.variableName}Service;

    @ApiOperation(value = "新增${tableClass.introspectedTable.remarks}", notes = "新增${tableClass.introspectedTable.remarks}")
    @PostMapping("/add")
    public Result add(@RequestBody ${tableClass.shortClassName} ${tableClass.variableName}) {
        ${tableClass.variableName}Service.save(${tableClass.variableName});
        return Result.success();
    }

    @ApiOperation(value = "删除${tableClass.introspectedTable.remarks}", notes = "删除${tableClass.introspectedTable.remarks}")
    @ApiImplicitParam(name = "id", value = "ID", example = "1", required = true)
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        ${tableClass.variableName}Service.deleteById(id);
        return Result.success();
    }

    @ApiOperation(value = "更新${tableClass.introspectedTable.remarks}", notes = "更新${tableClass.introspectedTable.remarks}")
    @PutMapping("update")
    public Result update(@RequestBody ${tableClass.shortClassName} ${tableClass.variableName}) {
        ${tableClass.variableName}Service.update(${tableClass.variableName});
        return Result.success();
    }

    @ApiOperation(value = "查看${tableClass.introspectedTable.remarks}详情", notes = "查看${tableClass.introspectedTable.remarks}详情")
    @ApiImplicitParam(name = "id", value = "ID", example = "1", required = true)
    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        ${tableClass.shortClassName} ${tableClass.variableName} = ${tableClass.variableName}Service.findById(id);
        return Result.success(${tableClass.variableName});
    }

    @ApiOperation(value = "查看${tableClass.introspectedTable.remarks}列表", notes = "查看${tableClass.introspectedTable.remarks}列表")
    @PostMapping("/list")
    public Result<PageResponse<${tableClass.shortClassName}>> list(@RequestBody PageRequest request) {
        PageInfo<${tableClass.shortClassName}> pageInfo = PageHelper.startPage(request.getPageNum(), request.getPageSize()).doSelectPageInfo(() -> ${tableClass.variableName}Service.findAll());
        return Result.success(PageResponse.getPage(pageInfo));
    }
}
