package com.wenwen.blog.contrller.admin;

import com.wenwen.blog.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author WangWenLei
 * @DATE: 2020/11/25
 **/
@SpringBootTest
public class Login {
    @Autowired
    UserMapper userMapper;
    @Test
    public void listUser(){
        final List<Map<String, String>> maps = userMapper.listUser();
        final Map<String, String> stringStringMap = userMapper.listUserOne();
        //取值要加判断
        if(maps.size() > 0){
            final String user_password1 = maps.get(0).get("user_password");
        }
        if(stringStringMap != null){
            final String user_password2 = stringStringMap.get("user_password");
        }
        Map<String ,String> map = new HashMap<>();
        maps.stream().forEach(item -> map.put(item.get("user_password"),item.get("user_name")));
        System.out.println(map);
        System.out.println(maps);
        System.out.println(stringStringMap);
    }
}
