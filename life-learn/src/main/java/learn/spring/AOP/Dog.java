package learn.spring.AOP;

/**
 * @author WangWenLei
 * @DATE: 2020/9/30
 **/
public class Dog implements Animal{
    @Override
    public void bark() {
        System.out.println("wang wang wang ...");
    }
}
