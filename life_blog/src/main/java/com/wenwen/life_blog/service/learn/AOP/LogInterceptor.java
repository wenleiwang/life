package com.wenwen.life_blog.service.learn.AOP;

import org.aopalliance.intercept.MethodInvocation;

/**
 * @author WangWenLei
 * @DATE: 2020/9/30
 **/
public class LogInterceptor {
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("开始执行！");
        Object proceed = methodInvocation.proceed();
        System.out.println("执行完毕！");
        return proceed;
    }
}
