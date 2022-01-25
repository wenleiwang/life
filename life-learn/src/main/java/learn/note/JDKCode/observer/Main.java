package learn.note.JDKCode.observer;

/**
 * @author WangWenLei
 * @DATE: 2022/1/25
 **/
public class Main {
    public static void main(String[] args) {
        Person person = new Person("wenwne");
        for (int i = 1 ; i <= 10 ; i++) {
            person.addObserver(new Cat("cat" + i));
        }
        // 放鱼
        person.giveFish("草鱼");
    }
}
