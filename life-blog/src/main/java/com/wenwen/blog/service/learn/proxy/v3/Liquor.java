package com.wenwen.blog.service.learn.proxy.v3;

/**
 * 酒厂
 * @author WangWenLei
 * @DATE: 2021/4/7
 **/
public class Liquor implements Product {
    @Override
    public void product(){
        System.out.println("我们生产了酒。。。");
    }
}
