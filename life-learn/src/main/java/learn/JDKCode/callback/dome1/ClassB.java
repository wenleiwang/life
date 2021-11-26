package learn.JDKCode.callback.dome1;

/**
 * @author WangWenLei
 * @DATE: 2021/11/26
 **/
public class ClassB {
    public void b() {
        ClassA a = new ClassA();
        a.a();
    }
    public void backs(){
        System.out.println("我就是回调函数！");
    }
}
