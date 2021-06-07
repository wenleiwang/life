package learn.proxy.v3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理商
 * @author WangWenLei
 * @DATE: 2021/4/7
 **/
public class AnyProxy implements InvocationHandler {
    private final Object object;
    public AnyProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理开始。");
        Object invoke = method.invoke(object,args);
        System.out.println("代理结束。");
        return invoke;
    }
}
