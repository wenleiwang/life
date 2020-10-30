package ink.poesy.life.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import ink.poesy.life.dao.mapper.UserMapper;
import ink.poesy.life.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "用于用户相关的请求")
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserMapper userMapper;

    @ApiOperation(value = "展示用户信息",notes = "返回用户的信息")
    @PostMapping("/showUserInfo")
    public String showUserInfo(@RequestBody User user){
        return user.toString();
    }

    @ApiOperation(value = "根据id查询用户信息")
    @GetMapping("/getUserInfo")
    public User userInfo(String id){
        User user = new User();
        return user;
    }

    @GetMapping("/getUserCount")
    public String getUserCount(Integer id){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id",id);
        Integer integer = userMapper.selectCount(queryWrapper);
        if(integer == null){
            return "数量为空！";
        }else if(integer <= 0){
            return "数量为零！";
        }else{
            return "数量为"+integer;
        }

    }
}
