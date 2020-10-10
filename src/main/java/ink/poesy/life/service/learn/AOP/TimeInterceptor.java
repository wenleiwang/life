package ink.poesy.life.service.learn.AOP;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author WangWenLei
 * @DATE: 2020/9/30
 **/
public class TimeInterceptor  implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        long l = System.currentTimeMillis();
        System.out.println("开始计时！");
        Object proceed = methodInvocation.proceed();
        System.out.println("计时结束！" + (System.currentTimeMillis() - l) / 1000);
        return proceed;
    }
}
