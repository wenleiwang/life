package com.wenwen.blog.service.learn.designpatterns.strategy.v4;

/**
 * 人员年龄比较策略
 * @author WangWenLei
 * @DATE: 2021/4/14
 **/
public class PersonAgeStrategy implements Comparable<Person>{

    @Override
    public int compareTo(Person[] data, int c0, int c1) {
        if(data[c0].age > data[c1].age){
            return 1;
        }else if (data[c0].age < data[c1].age){
            return -1;
        }else {
            return 0;
        }
    }
}
