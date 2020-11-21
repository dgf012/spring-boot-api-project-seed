package com.company.project.project.web.sys.sysuser;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@ApiModel
@Setter
@Getter
@ToString
public class SysUserListVO {

    @ApiModelProperty(value = "ID", example = "")
    private Integer id;

    @ApiModelProperty(value = "用户名", example = "")
    private String username;

    @ApiModelProperty(value = "密码", example = "")
    private String password;

    @ApiModelProperty(value = "昵称", example = "")
    private String nickName;

    @ApiModelProperty(value = "性别", example = "")
    private Integer sex;

    @ApiModelProperty(value = "注册时间", example = "")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date registerDate;

}
