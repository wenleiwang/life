package learn.note.designpatterns.strategy.v3;

/**
 * 人的属性
 * @author WangWenLei
 * @DATE: 2021/4/14
 **/
public class Person implements Comparable<Person> {
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

    @Override
    public int compareTo(Person o) {
        if(this.age > o.age) {
            return 1;
        } else if (this.age < o.age) {
            return -1;
        } else{
            return 0;
        }
    }
}
