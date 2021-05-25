package com.wenwen.blog.service.learn.designpatterns.strategy.tank;

/**
 * 炮弹策略
 * @author WangWenLei
 */
public interface ShellStrategy<T> {
    /**
     * 填装炮弹
     * @param shell 炮弹名
     */
    public void upShell(T tank,String shell);
}
