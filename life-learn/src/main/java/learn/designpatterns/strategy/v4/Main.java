package learn.designpatterns.strategy.v4;

import java.util.Arrays;

/**
 * 策略模式：比较策略
 * @author WangWenLei
 * @DATE: 2021/4/14
 **/
public class Main {
    public static void main(String[] args) {
        // 现有个比较的数组
        Person[] people = {new Person("张三",20,140), new Person("李四",22,130), new Person("王五",18,150)};
        // 声明实现排序类
        Sort<Person> sort = new Sort<>();
        // 排序
        Person[] data2 = sort.compare(people,new PersonAgeStrategy());
//        Person[] data2 = sort.compare(people,new PersonWeightStrategy());
        // 输出
        System.out.println(Arrays.toString(data2));
    }
}
