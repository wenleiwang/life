package learn.note.JDKCode.Interface;

/**
 * @Author Wang WenLei
 * @Date 2021/11/25 21:59
 * @Version 1.0
 **/
public class UseInterface1 implements InterfaceTest {
    private String name1 = "UseInterface1";
    @Override
    public void printName() {
        System.out.println(name1);
    }
}
