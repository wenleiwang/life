package learn.note.JDKCode.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @author WangWenLei
 * @DATE: 2022/1/25
 **/
public class Cat implements Observer {
    public String name;
    public Cat(String name) {
        this.name = name;
    }
    @Override
    public void update(Observable o, Object arg) {
        String preffix = o.toString();
        if (o instanceof Person) {
            preffix = ((Person) o).name;
        }
        System.out.println(preffix + "主人放 " + arg + "~了," + name + "去吃鱼吧");
    }
}
