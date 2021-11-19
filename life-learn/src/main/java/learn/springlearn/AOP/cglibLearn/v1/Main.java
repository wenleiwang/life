package learn.springlearn.AOP.cglibLearn.v1;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;

/**
 * 在mian函数中，我们通过一个Enhancer和一个MethodInterceptor来实现对方法的拦截
 * Enhancer创建一个被代理对象的子类并且拦截所有的方法调用（包括从Object中继承的toString和hashCode方法）。Enhancer不能够拦截final方法，例如Object.getClass()方法
 * @author WangWenLei
 * @DATE: 2021/4/16
 **/
public class Main {

    public String test(){
        return "hello cglib!";
    }
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Main.class);
        enhancer.setCallback(new FixedValue() {
            @Override
            public Object loadObject() throws Exception {
                return "拦截所有的方法调用（包括从Object中继承的toString和hashCode方法）。Enhancer不能够拦截final方法，例如Object.getClass()方法";
            }
        });

        Main  main1 = (Main) enhancer.create();
        System.out.println(main1.test());
        System.out.println(main1.toString());
    }
}
