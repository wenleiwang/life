package learn.note.JDKCode.callback.dome1_4;

/**
 * @author WangWenLei
 * @DATE: 2021/11/26
 **/
public class ClassA {
    //
    public void a() {
        System.out.println("执行了a方法");
        ClassB b = new ClassB();
        b.b(new Interface() {
            @Override
            public String backs(String n) {
                System.out.println("A:我就是A的回调函数！我打印：" + n);
                return "A:我就是A的回调函数！我打印：" + n + "的返回。";
            }
        });
    }
}
