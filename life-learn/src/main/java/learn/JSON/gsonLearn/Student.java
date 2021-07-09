package learn.JSON.gsonLearn;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

/**
 * @author WangWenLei
 * @DATE: 2021/6/21
 **/
public class Student implements Test2 {
    @SerializedName(value = "name",alternate = {"NAME","name1"})
    private String name;
    @SerializedName("AGE")
    private int age;
    @SerializedName("SEX")
    private char sex;
    @SerializedName("HEIGHT")
    private float height;
    @SerializedName("MONEY")
    private BigDecimal money;

    public Student(String name, int age, char sex, float height, BigDecimal money) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.height = height;
        this.money = money;
    }

    public Student() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", height=" + height +
                ", money=" + money +
                '}';
    }
}
