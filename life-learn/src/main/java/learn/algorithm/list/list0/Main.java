package learn.algorithm.list.list0;

/**
 * 单链表的实现
 * 1. 创建
 * 2. 插入
 * 3. 删除
 * 4. 遍历
 * 5. 修改
 * 的使用
 * @Author Wang WenLei
 * @Date 2021/11/21 11:57
 * @Version 1.0
 **/
public class Main {
    public static void main(String[] args) {
        MyLinkList<Integer> linkList = new MyLinkList<>();
        linkList.insert(1);
        linkList.insert(2);
        linkList.insert(4);
        linkList.insert(3,3);
        Integer integer = linkList.get(4);
        System.out.println(integer);
    }
}
