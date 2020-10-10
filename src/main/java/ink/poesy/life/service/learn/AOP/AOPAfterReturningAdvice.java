package ink.poesy.life.service.learn.AOP;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @author WangWenLei
 * @DATE: 2020/9/30
 **/
public class AOPAfterReturningAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("After returning...");
    }
}
