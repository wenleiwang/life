package learn.note.JDKCode.proxy;

/**
 * @author WangWenLei
 * @DATE: 2021/2/7
 **/
public class SubjectImpl implements Subject{
    @Override
    public String sayHello() {
        System.out.println("Hello World");
        return "success";
    }
}
