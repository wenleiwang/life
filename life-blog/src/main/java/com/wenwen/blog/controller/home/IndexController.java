package com.wenwen.blog.controller.home;

import com.wenwen.blog.entity.User;
import com.wenwen.blog.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WangWenLei
 * @DATE: 2020/11/5
 **/
@RestController
public class IndexController {
    @Autowired
    UserMapper userMapper;

    @GetMapping("/user")
    public String test(){
        final User user = userMapper.selectById(1);
        return "";
    }
}
