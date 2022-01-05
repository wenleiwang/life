package learn.JDKCode.callback.dome2;

/**
 * 业务调用类
 * @author WangWenLei
 * @DATE: 2021/11/26
 **/
public class Service {
    public void execute(Callback callback) {
        System.out.println("业务调用执行自己的方法");
        callback.callbackMethod("wang");
    }
}
