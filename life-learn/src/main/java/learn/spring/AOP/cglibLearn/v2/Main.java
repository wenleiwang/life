package learn.spring.AOP.cglibLearn.v2;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 代理
 * @author WangWenLei
 * @DATE: 2021/4/16
 **/
public class Main {
    public void test(){
        System.out.println("hello cglib!");
    }
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(learn.spring.AOP.cglibLearn.v1.Main.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                System.out.println("在方法前运行");
                Object result = proxy.invokeSuper(obj, args);
                System.out.println("在方法后运行");
                return result;
            }
        });

        learn.spring.AOP.cglibLearn.v1.Main main1 = (learn.spring.AOP.cglibLearn.v1.Main) enhancer.create();
        main1.test();
    }
}
