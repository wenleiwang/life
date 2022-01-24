package learn.note.designpatterns.strategy.v1;

/**
 * 实现接口实现类
 * @author WangWenLei
 * @DATE: 2021/4/8
 **/
public class OperationAdd implements Strategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}
