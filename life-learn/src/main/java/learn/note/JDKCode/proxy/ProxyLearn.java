package learn.note.JDKCode.proxy;

import java.lang.reflect.Proxy;

/**
 * JDK动态代理学习
 * @author WangWenLei
 * @DATE: 2021/2/7
 **/
public class ProxyLearn {
    public static void main(String[] args) {

        Subject subject = new SubjectImpl();
        Subject proxy = (Subject) Proxy.newProxyInstance(
                subject.getClass().getClassLoader(),
                subject.getClass().getInterfaces(),
                new ProxyInvocationHandler(subject)
        );

        proxy.sayHello();
    }
}
