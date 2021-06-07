package learn.designpatterns.strategy.v4;

/**
 * 人的属性
 * @author WangWenLei
 * @DATE: 2021/4/14
 **/
public class Person {
    public String name;
    public int age;
    public int weight;

    public Person(String name, int age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }

}
