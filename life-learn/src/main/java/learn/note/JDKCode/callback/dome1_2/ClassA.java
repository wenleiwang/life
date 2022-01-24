package learn.note.JDKCode.callback.dome1_2;

/**
 * @author WangWenLei
 * @DATE: 2021/11/26
 **/
public class ClassA {
    public void a() {
        System.out.println("执行了a方法");
        ClassB b = new ClassB();
        b.b(new Interface() {
            @Override
            public void backs() {
                System.out.println("A:我就是A的回调函数！");
            }
        });
    }
}
