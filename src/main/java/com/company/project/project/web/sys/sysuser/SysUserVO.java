package com.company.project.project.web.sys.sysuser;

import com.alibaba.fastjson.annotation.JSONField;
import com.company.project.project.validation.UpdateGroups;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@ApiModel
@Setter
@Getter
@ToString
public class SysUserVO {

    @ApiModelProperty(value = "ID(新增时不填，更新时必填)", example = "")
    @NotNull(message = "ID不能为空", groups = UpdateGroups.class)
    private Integer id;

    @ApiModelProperty(value = "用户名", example = "", required = true)
    @NotBlank(message = "用户名不能为空")
    @Length(max = 255, message = "用户名不能超过{max}个字")
    private String username;

    @ApiModelProperty(value = "密码", example = "", required = true)
    @NotBlank(message = "密码不能为空")
    @Length(max = 255, message = "密码不能超过{max}个字")
    private String password;

    @ApiModelProperty(value = "昵称", example = "")
    @Length(max = 255, message = "昵称不能超过{max}个字")
    private String nickName;

    @ApiModelProperty(value = "性别", example = "")
    @Min(value = 0, message = "性别最大不能超过{value}")
    @Max(value = 10, message = "性别最大不能超过{value}")
    private Integer sex;

    @ApiModelProperty(value = "注册时间", example = "", required = true)
    @NotNull(message = "注册时间不能为空")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date registerDate;

}
