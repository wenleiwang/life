package com.wenwen.blog.controller.admin;

import com.wenwen.blog.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author WangWenLei
 * @DATE: 2020/11/5
 **/

@RestController
public class Login {

    @Autowired
    UserMapper userMapper;

//    @GetMapping("/listUser")
    public String listUser(){
        final List<Map<String, String>> maps = userMapper.listUser();
        final Map<String, String> stringStringMap = userMapper.listUserOne();
        System.out.println(maps);
        System.out.println(stringStringMap);
        return "";
    }
}
