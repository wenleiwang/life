package com.wenwen.blog.entity;

import lombok.Data;

/**
 * @author WangWenLei
 * @DATE: 2021/2/25
 **/
@Data
public class UserBase {
    /**
     * 登录账号
     */
    private String loginName;

    /**
     * 用户密码
     */
    private String userPassword;
}
