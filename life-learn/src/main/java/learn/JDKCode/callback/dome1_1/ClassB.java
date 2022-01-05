package learn.JDKCode.callback.dome1_1;

/**
 * @author WangWenLei
 * @DATE: 2021/11/26
 **/
public class ClassB {
    public void b(ClassA a) {
        System.out.println("我执行了b");
        System.out.println("B:我开始调用A的回调-->");
        a.backs();
        System.out.println("B: <--我完成调用A的回调");
    }
}
