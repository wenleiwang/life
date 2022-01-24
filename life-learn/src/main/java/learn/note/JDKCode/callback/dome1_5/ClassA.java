package learn.note.JDKCode.callback.dome1_5;

/**
 * @author WangWenLei
 * @DATE: 2021/11/26
 **/
public class ClassA {
    public void a() {
        System.out.println("执行了a方法");
        ClassB b = new ClassB();
        String b1 = b.b(new Interface() {
            @Override
            public String backs(String n) {
                System.out.println("A:我就是A的回调函数！我打印：" + n);
                return "A:我就是A的回调函数！我打印：" + n + "的返回。";
            }
        });
        System.out.println("A:执行完得到的结果:" + b1);
//        String b2 = b.b(item -> {
//                System.out.println("A:我就是A的回调函数！我打印：" + item);
//                return "A:我就是A的回调函数！我打印：" + item + "的返回。";
//        }
//        //aa
//        ,1);
    }
}
