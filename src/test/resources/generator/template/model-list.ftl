package ${basePackage}.web.${tableClass.tableName?split('_')[0]}.${tableClass.variableName};

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

<#if tableClass.baseFields??>
    <#list tableClass.baseFields as field>
        <#if field.shortTypeName=="Date" >
import java.util.Date;
import com.alibaba.fastjson.annotation.JSONField;
            <#break>
        </#if>
    </#list>
</#if>

@ApiModel
@Setter
@Getter
@ToString
public class ${tableClass.shortClassName}ListVO {

<#if tableClass.pkFields??>
    <#list tableClass.pkFields as field>
    @ApiModelProperty(value = "${field.remarks}", example = "")
    <#--<#if field.stringColumn && !field.nullable>-->
    <#--@NotBlank(message = "${field.remarks}不能为空")-->
    <#--</#if>-->
    <#--<#if !field.stringColumn && !field.nullable>-->
    <#--@NotNull(message = "${field.remarks}不能为空")-->
    <#--</#if>-->
    <#--<#if field.shortTypeName=="String" >-->
    <#--@Length(max = ${field.length}, message = "${field.remarks}不能超过{max}个字")-->
    <#--</#if>-->
    <#--<#if field.shortTypeName=="Integer" || field.shortTypeName=="Long" >-->
    <#--@Min(value = 0, message = "性别最大不能超过{value}")-->
    <#--@Max(value = ${field.length}, message = "性别最大不能超过{value}")-->
    <#--</#if>-->
    private ${field.shortTypeName} ${field.fieldName};
    </#list>
</#if>

<#if tableClass.baseFields??>
    <#list tableClass.baseFields as field>
    @ApiModelProperty(value = "${field.remarks}", example = "")
    <#--<#if field.stringColumn && !field.nullable>-->
    <#--@NotBlank(message = "${field.remarks}不能为空")-->
    <#--</#if>-->
    <#--<#if !field.stringColumn && !field.nullable>-->
    <#--@NotNull(message = "${field.remarks}不能为空")-->
    <#--</#if>-->
    <#--<#if field.shortTypeName=="String" >-->
    <#--@Length(max = ${field.length}, message = "${field.remarks}不能超过{max}个字")-->
    <#--</#if>-->
    <#--<#if field.shortTypeName=="Integer" || field.shortTypeName=="Long" >-->
    <#--@Min(value = 0, message = "性别最大不能超过{value}")-->
    <#--@Max(value = ${field.length}, message = "性别最大不能超过{value}")-->
    <#--</#if>-->
    <#if field.shortTypeName=="Date" >
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    </#if>
    private ${field.shortTypeName} ${field.fieldName};

    </#list>
</#if>
}
