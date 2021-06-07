package com.wenwen.blog.service.learn.algorithm.list;

/**
 * 节点
 * @author WangWenLei
 * @DATE: 2021/5/31
 **/
public class Node<T> {
    private Node<T> next;
    private T val;

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }
}
