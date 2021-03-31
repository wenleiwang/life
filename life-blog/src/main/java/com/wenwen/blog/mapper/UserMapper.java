package com.wenwen.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wenwen.blog.entity.User;
import com.wenwen.blog.entity.response.UserResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author WenleiWang
 * @since 2020-11-05
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
    List<Map<String,String>> listUser();
    Map<String,String> listUserOne();

    /**
     * 用户登录
     * @param loginName 用户名
     * @param password 用户密码
     * @return 通过用户名密码获取用户信息
     */
    UserResponse login(@Param("loginName") String loginName, @Param("password") String password);
}
