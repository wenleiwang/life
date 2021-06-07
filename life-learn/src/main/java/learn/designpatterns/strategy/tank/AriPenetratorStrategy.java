package learn.designpatterns.strategy.tank;

/**
 * @author WangWenLei
 * @DATE: 2021/4/14
 **/
public class AriPenetratorStrategy implements ShellStrategy<Tank> {
    @Override
    public void upShell(Tank tank, String shell) {
        System.out.println("填装了==>" + shell);
        tank.bong = shell;
    }
}
