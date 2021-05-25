package com.wenwen.blog.service.learn.designpatterns.strategy.tank;

/**
 * 坦克炮弹策略
 * @author WangWenLei
 * @DATE: 2021/4/14
 **/
public class Main {
    public static void main(String[] args) {
        Tank tank = new Tank();
        tank.move();
        tank.fire();
        AriPenetratorStrategy bong = new AriPenetratorStrategy();
        bong.upShell(tank,"穿甲弹");
        tank.fire();
        tank.move();
        NapalmBombStrategy bong1 = new NapalmBombStrategy();
        bong1.upShell(tank,"燃烧弹");
        tank.fire();
    }
}
