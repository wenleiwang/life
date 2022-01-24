package learn.note.JDKCode.callback.dome1;

/**
 * @author WangWenLei
 * @DATE: 2021/11/26
 **/
public class ClassB {
    public void b() {
        System.out.println("我执行了b");
        System.out.println("B:我开始调用A的回调-->");
        ClassA a = new ClassA();
        a.backs();
        System.out.println("B: <--我完成调用A的回调");
    }
}
