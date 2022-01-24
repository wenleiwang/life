package learn.note.JDKCode.proxy.write;

import java.lang.reflect.Method;

/**
 * @author WangWenLei
 * @DATE: 2021/7/7
 **/
public interface GpInvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args)throws Throwable;
}
