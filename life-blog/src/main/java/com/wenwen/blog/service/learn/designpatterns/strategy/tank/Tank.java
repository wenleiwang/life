package com.wenwen.blog.service.learn.designpatterns.strategy.tank;

import org.apache.commons.lang3.StringUtils;

/**
 * 坦克实体类
 * @author WangWenLei
 * @DATE: 2021/4/14
 **/
public class Tank {
    public String name;
    public int moveSpeed = 50;
    public String bong;

    public void fire(){
        if(StringUtils.isBlank(this.bong)){
            System.out.println("没有炮弹，请填装炮弹!");
        }else{
            System.out.println("我发射了" + this.bong);
        }
    }

    public void move(){
        System.out.println("我移动了" + this.moveSpeed + "米，ca la ca la！");
    }
}
