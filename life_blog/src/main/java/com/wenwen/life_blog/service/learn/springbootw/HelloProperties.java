package com.wenwen.life_blog.service.learn.springbootw;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author WangWenLei
 * @DATE: 2020/10/30
 **/
@ConfigurationProperties(prefix = "hello")
public class HelloProperties {
    private static final String MSG = "world";
    private String msg = MSG;

    public String getMsg(){
        return msg;
    }

    public void setMsg(String msg){
        this.msg = msg;
    }
}
