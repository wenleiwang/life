package com.wenwen.blog.service.impl;

import com.wenwen.blog.entity.User;
import com.wenwen.blog.mapper.UserMapper;
import com.wenwen.blog.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wenwen.blog.util.response.ResponseDataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author WenleiWang
 * @since 2020-11-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public ResponseDataBase<User> login(String loginName, String password) {
        ResponseDataBase<User> response = new ResponseDataBase<>();
        User user = userMapper.login(loginName,password);
        if(user != null){
            response.setData(user);
            response.successful("登录成功！");
            return response;
        }else{
            response.fail("获取用户信息失败！");
            return response;
        }
    }
}
