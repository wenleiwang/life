package com.wenwen.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author WenleiWang
 * @since 2020-11-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id", type = IdType.AUTO)
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


}
