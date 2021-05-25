package com.wenwen.blog.service.learn.AOP.cglibLearn.v4;

import net.sf.cglib.beans.BeanGenerator;

/**
 * cglib提供的一个操作bean的工具，使用它能够在运行时动态的创建一个bean。
 * @author WangWenLei
 * @DATE: 2021/4/16
 **/
public class Main {
    public static void main(String[] args) {
        BeanGenerator beanGenerator = new BeanGenerator();
        beanGenerator.addProperty("value",String.class);
        Object o = beanGenerator.create();
        o.getClass();
    }
}
