package com.wenwen.blog.controller.admin;

import com.wenwen.blog.entity.User;
import com.wenwen.blog.mapper.UserMapper;
import com.wenwen.blog.service.IUserService;
import com.wenwen.blog.util.response.ResponseDataBase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    IUserService iUserService;

//    @GetMapping("/listUser")
    public String listUser(){
        final List<Map<String, String>> maps = userMapper.listUser();
        final Map<String, String> stringStringMap = userMapper.listUserOne();
        System.out.println(maps);
        System.out.println(stringStringMap);
        return "";
    }

    @ApiOperation("用户登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "loginName",value = "loginName"),
            @ApiImplicitParam(name = "password" ,value = "password")
    })
    @PostMapping("/login")
    public ResponseDataBase<User> login( @RequestBody User user){
        ResponseDataBase<User> response = new ResponseDataBase<>();
        if(StringUtils.isBlank(user.getLoginName())){
            response.fail("请输入用户名！");
            return response;
        }
        if(StringUtils.isBlank(user.getUserPassword())){
            response.fail("请输入密码！");
            return response;
        }

        return iUserService.login(user.getLoginName(),user.getUserPassword());
    }
}
