package com.wenwen.life_blog.service.learn.springbootw;

/**
 * Hello entity
 * @author WangWenLei
 * @DATE: 2020/10/30
 **/
public class Hello {
    private String msg;

    public String sayHello(){
        return "hello " + msg;
    }

    public void setMsg(String msg){
        this.msg = msg;
    }
}
