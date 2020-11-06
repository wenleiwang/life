package com.wenwen.common.context;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * <p>
 *  博客用户类
 * </p>
 *
 * @author WenleiWang
 * @since 2020-11-06
 */
@Data
public class UserInfo {
    private Integer userId;

    /**
     * 登录账号
     */
    private String loginName;

    /**
     * 用户密码
     */
    private String userPassword;

    /**
     * 用户名
     */
    private String userName;

    private String realName;

    /**
     * 虚拟年龄
     */
    private Integer userAge;

    /**
     * 真实年龄
     */
    private Integer realAge;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 插入数据时间
     */
    private LocalDateTime addTime;

    /**
     * 修改数据时间
     */
    private LocalDateTime updateTime;

    /**
     * 删除状态
     */
    private Boolean deleted;

    /**
     * 用户头像
     */
    private String userImg;
}
