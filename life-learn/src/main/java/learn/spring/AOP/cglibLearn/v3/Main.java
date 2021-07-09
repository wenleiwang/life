package learn.spring.AOP.cglibLearn.v3;

import net.sf.cglib.proxy.CallbackHelper;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Method;

/**
 * @author WangWenLei
 * @DATE: 2021/4/16
 **/
public class Main {
    public String test(String input){
        return "hello world";
    }
    public String test1(String input){
        return "hello 6";
    }
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        CallbackHelper callbackHelper = new CallbackHelper(Main.class, new Class[0]) {
            @Override
            protected Object getCallback(Method method) {
//                if(method.getDeclaringClass() != Object.class &&  method.getReturnType() == String.class){
                if(method.getDeclaringClass() != Object.class &&  "test1".equals(method.getName())){
                    return new FixedValue() {
                        @Override
                        public Object loadObject() throws Exception {
                            return "只想对特定的方法进行拦截，对其他的方法直接放行";
                        }
                    };
                }else{
                    return NoOp.INSTANCE;
                }
            }
        };
        enhancer.setSuperclass(Main.class);
        enhancer.setCallbackFilter(callbackHelper);
        enhancer.setCallbacks(callbackHelper.getCallbacks());
        Main proxy = (Main) enhancer.create();
        System.out.println(proxy.test(null));
        System.out.println(proxy.test1(null));
        System.out.println(proxy.toString());
    }
}
