package com.wenwen.blog.service.learn.proxy.v3;

import java.lang.reflect.Proxy;

/**
 * 调用者
 * @author WangWenLei
 * @DATE: 2021/4/7
 **/
public class Main {
    public static void main(String[] args) {
        // 设置固化生成的代理文件
        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        // 酒
        Product liquor = new Liquor();
        // 花生米
        Product peanut = new Peanut();

        // 代理酒
        AnyProxy handler1 = new AnyProxy(liquor);
        // 代理花生米
        AnyProxy handler2 = new AnyProxy(peanut);

        // 与酒的代理关系
        Product product1 = (Product) Proxy.newProxyInstance(liquor.getClass().getClassLoader(), liquor.getClass().getInterfaces(),handler1);
        // 与花生米的代理关系
        Product product2 = (Product) Proxy.newProxyInstance(peanut.getClass().getClassLoader(), peanut.getClass().getInterfaces(),handler2);

        // 调用代理方法
        product1.product();
        product2.product();
    }
}
