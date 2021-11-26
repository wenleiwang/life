package learn.JDKCode.callback.dome1;

/**
 * @author WangWenLei
 * @DATE: 2021/11/26
 **/
public class ClassA {
    public void a() {
        System.out.println("执行了a方法");
        ClassB b = new ClassB();
        b.backs();
    }
}
