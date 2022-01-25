package learn.note.JDKCode.observer;

import java.util.Observable;

/**
 * @author WangWenLei
 * @DATE: 2022/1/25
 **/
public class Person extends Observable {
    public String name;
    public Person(String name) {
        this.name = name;
    }

    public void giveFish(String fishName) {
        setChanged();
        notifyObservers(fishName);
    }
}
