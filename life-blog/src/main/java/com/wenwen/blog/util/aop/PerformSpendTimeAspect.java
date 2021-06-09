package com.wenwen.blog.util.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 声明一个切面：统计每个方法执行的时间
 * @author WangWenLei
 * @DATE: 2021/4/7
 **/
@Aspect
@Component
@Slf4j
public class PerformSpendTimeAspect {
    @Before("execution(* com.wenwen.blog.controller..*.*(..))")
    public void startMethod(){
        log.info("开始调用方法！");
    }
    @After("execution(* com.wenwen.blog.controller..*.*(..))")
    public void endMethod(){
        log.info("结束调用方法！");
    }
    /**
     * 切面表达式：
     * execution 代表所要执行的表达式主体
     * 第一处 * 代表方法返回类型 *代表所有类型
     * 第二处 包名代表aop监控的类所在的包
     * 第三处 .. 代表该包以及其子包下的所有类方法
     * 第四处 * 代表类名，*代表所有类
     * 第五处 *(..) *代表类中的方法名，(..)表示方法中的任何参数
     *
     * @param joinPoint
     * @return
     */
    @Around("execution(* com.wenwen.blog.controller..*.*(..))")
    public Object performMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        final long start = System.currentTimeMillis();
        // 执行目标 service
        Object result = joinPoint.proceed();
        final long end = System.currentTimeMillis();
        log.info("执行耗时" + (end - start));
        return result;
    }

}
