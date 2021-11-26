package learn.JDKCode.ThreadLearn.ThreadLocal;

/**
 * @Author Wang WenLei
 * @Date 2021/11/24 21:41
 * @Version 1.0
 **/
public class Student {
    private String name = "wCode";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
