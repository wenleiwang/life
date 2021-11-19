package learn.springlearn.AOP;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author WangWenLei
 * @DATE: 2020/9/30
 **/
public class AOPMethodBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("Before...");
    }
}
