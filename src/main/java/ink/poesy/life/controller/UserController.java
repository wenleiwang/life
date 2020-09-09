package ink.poesy.life.controller;

import ink.poesy.life.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "用于用户相关的请求")
@RequestMapping("/user")
public class UserController {

    @ApiOperation(value = "展示用户信息",notes = "返回用户的信息")
    @PostMapping("/showUserInfo")
    public String showUserInfo(@RequestBody User user){
        return user.toString();
    }
}
