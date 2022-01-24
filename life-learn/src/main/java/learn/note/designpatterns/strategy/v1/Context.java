package learn.note.designpatterns.strategy.v1;

/**
 * @author WangWenLei
 * @DATE: 2021/4/9
 **/
public class Context {

    private final Strategy strategy;
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2){
        return strategy.doOperation(num1 , num2);
    }
}
