package learn.JDKCode.Interface;

/**
 * @Author Wang WenLei
 * @Date 2021/11/25 22:00
 * @Version 1.0
 **/
public class UseInterface2 implements InterfaceTest {
    private String name2 = "UseInterface2";

    @Override
    public void printName() {
        System.out.println(name2);
    }
}
