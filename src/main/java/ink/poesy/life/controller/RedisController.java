package ink.poesy.life.controller;

import ink.poesy.life.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName RedisController
 * @Author wwl
 * @Date 2020/9/13 17:16
 * @Version 1.0
 **/
@Slf4j
@RequestMapping("/redis")
@RestController
public class RedisController {
    private static int ExpireTime = 60;   // redis中存储的过期时间60s

    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("/set")
    public boolean redisSet(@RequestParam("key")String key,@RequestParam("value")String vale){
        return redisUtil.set( key,vale);
    }

    @RequestMapping("get")
    public Object redisget(String key){
        return redisUtil.get(key);
    }

    @RequestMapping("/expire")
    public boolean expire(String key){
        return redisUtil.expire(key,ExpireTime);
    }
}
