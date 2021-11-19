package learn.JDKCode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 定义动态代理调用处理器
 * @author WangWenLei
 * @DATE: 2021/2/7
 **/
public class ProxyInvocationHandler implements InvocationHandler {
    private Object target;

    public ProxyInvocationHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("进入代理调用处理器");
        Object result = method.invoke(target,args);
        System.out.println("代理调用处理器调用结束");
        return result;
    }
}
