package ink.poesy.life.controller;

import ink.poesy.life.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "用于用户相关的请求")
@RequestMapping("/user")
public class UserController {

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
}
