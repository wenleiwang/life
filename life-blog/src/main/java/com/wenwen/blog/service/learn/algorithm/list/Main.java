package com.wenwen.blog.service.learn.algorithm.list;

/**
 * @author WangWenLei
 * @DATE: 2021/6/1
 **/
public class Main {
    public static void main(String[] args) {
        MyLinkList<Integer> myLinkList = new MyLinkList<>();
        Node<Integer> noHeadList = myLinkList.createNoHeadList(1);
        myLinkList.add(noHeadList,2);
        myLinkList.add(noHeadList,3);
        myLinkList.add(noHeadList,4);
        myLinkList.add(noHeadList,5);
        myLinkList.add(noHeadList,6);
        myLinkList.add(noHeadList,7);
        myLinkList.printLinkList(noHeadList);
        System.out.println("");
        myLinkList.addNode(noHeadList,7,19);
        myLinkList.delete(noHeadList);
        Node<Integer> integerNode = myLinkList.deleteNode(noHeadList, 2);
        myLinkList.printLinkList(integerNode);
    }
}
