package com.company.project.project.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@ToString
@Accessors(chain = true)
@ApiModel("")
@Table(name = "`sys_user`")
public class SysUser {
    /**
     * ID
     */
    @Id
    @Column(name = "`id`")
    @GeneratedValue(generator = "JDBC")
    @ApiModelProperty("ID")
    private Integer id;

    /**
     * 用户名
     */
    @Column(name = "`username`")
    @ApiModelProperty("用户名")
    private String username;

    /**
     * 密码
     */
    @Column(name = "`password`")
    @ApiModelProperty("密码")
    private String password;

    /**
     * 昵称
     */
    @Column(name = "`nick_name`")
    @ApiModelProperty("昵称")
    private String nickName;

    /**
     * 性别
     */
    @Column(name = "`sex`")
    @ApiModelProperty("性别")
    private Integer sex;

    /**
     * 注册时间
     */
    @Column(name = "`register_date`")
    @ApiModelProperty("注册时间")
    private Date registerDate;
}