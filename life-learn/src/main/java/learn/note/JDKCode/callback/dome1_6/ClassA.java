package learn.note.JDKCode.callback.dome1_6;

/**
 * @Author Wang WenLei
 * @Date 2021/11/27 20:50
 * @Version 1.0
 **/
public class ClassA {
    public void a() {
        System.out.println("执行了a方法");
        Interface in = (n -> {
            System.out.println("A：我是直接使用回调接口，我接收的参数是：" + n);
            return "我是回调的返回数据";
        });

        String backs = in.backs("我A，我是《in》的使用者");
        System.out.println("backes:" + backs);
    }
}
