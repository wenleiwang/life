package learn.note.JDKCode.callback.dome1_3;

/**
 * @author WangWenLei
 * @DATE: 2021/11/26
 **/
public class ClassB {
    public void b(Interface in) {
        System.out.println("我执行了b");
        System.out.println("B:我开始调用A的回调-->");
        in.backs("《我是B传的参数》");
        System.out.println("B: <--我完成调用A的回调");
    }
}
