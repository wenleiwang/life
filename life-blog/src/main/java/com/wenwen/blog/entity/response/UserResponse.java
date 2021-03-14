package com.wenwen.blog.entity.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户响应体
 * @author WangWenLei
 * @DATE: 2020/11/6
 **/
@Data
public class UserResponse implements Serializable {

    private static final long serialVersionUID = -171991745408169099L;

    @ApiModelProperty("用户ID")
    private Integer userId;

    @ApiModelProperty("登录账号")
    private String loginName;

    @ApiModelProperty("用户密码")
    private String userPassword;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("真实年龄")
    private String realName;

    @ApiModelProperty("虚拟年龄")
    private Integer userAge;

    @ApiModelProperty("真实年龄")
    private Integer realAge;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("插入数据时间")
    private Date addTime;

    @ApiModelProperty("修改数据时间")
    private Date updateTime;

    @ApiModelProperty("删除状态")
    private Boolean deleted;

    @ApiModelProperty("用户头像")
    private String userImg;

    @ApiModelProperty("拼接的Cookie")
    private String authorization;
}
