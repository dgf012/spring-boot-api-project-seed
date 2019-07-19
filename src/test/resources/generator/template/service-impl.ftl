package ${package};

import ${basePackage}.mapper.${tableClass.shortClassName}Mapper;
import ${tableClass.fullClassName};
import ${basePackage}.service.${tableClass.shortClassName}Service;
import ${basePackage}.core.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* 通用 Mapper 代码生成器
*
* @author mapper-generator
*/
@Service
public class ${tableClass.shortClassName}ServiceImpl extends AbstractService<${tableClass.shortClassName}> implements ${tableClass.shortClassName}Service {
    @Resource
    private ${tableClass.shortClassName}Mapper ${tableClass.shortClassName}Mapper;

}
