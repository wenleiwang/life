package learn.note.designpatterns.strategy.v1;

/**
 * @author WangWenLei
 * @DATE: 2021/4/8
 **/
public class OperationSubtract implements Strategy{


    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}
