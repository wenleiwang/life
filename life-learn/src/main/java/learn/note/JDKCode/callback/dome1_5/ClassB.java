package learn.note.JDKCode.callback.dome1_5;

/**
 * @author WangWenLei
 * @DATE: 2021/11/26
 **/
public class ClassB {
    public String b(Interface in) {
        System.out.println("我执行了b");
        System.out.println("B:我开始调用A的回调-->");
        String backs = in.backs("《我是B传的参数》");
        System.out.println("B:我收到了回调的结果:"+backs + "<--我完成调用A的回调");
        return "《我是B的返回》";
    }
}
