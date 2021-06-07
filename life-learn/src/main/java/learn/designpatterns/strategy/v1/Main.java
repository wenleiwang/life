package learn.designpatterns.strategy.v1;

/**
 * @author WangWenLei
 * @DATE: 2021/4/8
 **/
public class Main {
    public static void main(String[] args) {
        Context context = new Context(new OperationAdd());
        System.out.println(context.executeStrategy(10,5));
    }
}
