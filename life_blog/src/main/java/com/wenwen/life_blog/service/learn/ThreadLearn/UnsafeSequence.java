package com.wenwen.life_blog.service.learn.ThreadLearn;

/**
 * @author WangWenLei
 * @DATE: 2020/10/13
 **/
public class UnsafeSequence {
    private int value = 1;

    public int getNext(){
        return value++;
    }
    public int getValue(){
        return value;
    }

}
