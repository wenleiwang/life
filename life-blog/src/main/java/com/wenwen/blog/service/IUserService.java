package com.wenwen.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wenwen.blog.entity.User;
import com.wenwen.blog.entity.response.UserResponse;
import com.wenwen.blog.util.response.ResponseDataBase;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author WenleiWang
 * @since 2020-11-05
 */
public interface IUserService extends IService<User> {

    /**
     * 用户登录接口
     * @param loginName 用户名
     * @param password 用户密码
     * @return 登录成功返回用户信息
     */
    ResponseDataBase<UserResponse> login(String loginName, String password);
}
