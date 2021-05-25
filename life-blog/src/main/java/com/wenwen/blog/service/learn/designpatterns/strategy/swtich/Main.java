package com.wenwen.blog.service.learn.designpatterns.strategy.swtich;

/**
 * switch改造
 * @author WangWenLei
 * @DATE: 2021/4/14
 **/
public class Main {
    public static void main(String[] args) {
        String name = "lisi";
        for(Name item : Name.values()){
            if(item.getName().equals(name)){
                try {
                    Class<?> doWork =  Class.forName(item.getPackageName());
                    Switch aSwitch = (Switch) doWork.newInstance();
                    aSwitch.doSomething();
                } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
