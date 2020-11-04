package com.wenwen.life_blog.service.learn.AOP;


import org.springframework.aop.framework.ProxyFactory;

/**
 * @author WangWenLei
 * @DATE: 2020/9/30
 **/
public class learn {
    public static void main(String[] args) {
        ProxyFactory proxyFactory= new ProxyFactory();
//        proxyFactory.addAdvice(new LogInterceptor());
        proxyFactory.addAdvice(new TimeInterceptor());
        proxyFactory.addAdvice(new AOPAfterReturningAdvice());
        proxyFactory.addAdvice(new AOPMethodBeforeAdvice());

        proxyFactory.setTarget(new Dog());
        proxyFactory.setInterfaces(Dog.class.getInterfaces());

        Object proxy = proxyFactory.getProxy();

        if (proxy instanceof Dog) {
            ((Dog)proxy).bark();
        }
    }
}
