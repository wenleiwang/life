package com.wenwen.blog.service.learn.algorithm.list;

/**
 * 单链表
 * @author WangWenLei
 * @DATE: 2021/5/31
 **/
public class MyLinkList<T> {
    /**
     * 创建有头链表
      */
    public Node<T> createHaveHeadList(){
        return new Node<T>();
    }
    // 创建无头结点链表
    public Node<T> createNoHeadList(T val){
        Node<T> stringNode = new Node<>();
        stringNode.setVal(val);
        return stringNode;
    }

    /**
     * 修改一个节点
     * @param list 单链表
     * @param oldVal 旧值
     * @param newVal 新值
     * @return 头结点
     */
    public Node<T> updateNode(Node<T> list, T oldVal , T newVal){
        Node<T> head = list;
        while(head.getNext() != null){
            if(head.getVal() != null && head.getVal().equals(oldVal)){
                head.setVal(newVal);
                break;
            }
            head = head.getNext();
        }
        return list;
    }

    /**
     * 删除最后一个节点
     * @param list 单链表
     * @return 头结点
     */
    public Node<T> delete(Node<T> list){
        Node<T> head = list;
        while(head.getNext() != null){
            if(head.getNext().getNext() ==  null){
                head.setNext(null);
            }else{
                head = head.getNext();
            }
        }
        return list;
    }

    /**
     * 删除指定位置的节点
     * @param list 单链表
     * @return 头结点
     */
    public Node<T> deleteNode(Node<T> list,int cursor){
        Node<T> head = list;
        if(cursor == 1){
            if(list.getNext() != null){
                return head.getNext();
            }else{
                return new Node<T>();
            }
        }
        Node<T> afterNode = head;
        for(int i = 1 ; i < cursor ; i++){
            if(afterNode == null){
                throw new IndexOutOfBoundsException();
            }
            if(afterNode.getNext() != null){
                afterNode = head;
                head = head.getNext();
            }
        }
        afterNode.setNext(head.getNext() != null ? head.getNext() : null);
        return list;
    }

    /**
     * 末尾添加一个节点
     * @param list 单链表头结点
     * @param val 要添加数据
     */
    public void add(Node<T> list,T val){
        Node<T> head = list;
        Node<T> stringNode = new Node<>();
        stringNode.setVal(val);
        while(head.getNext() != null){
            head = head.getNext();
        }
        head.setNext(stringNode);
    }

    /**
     * 从指定位置插入节点
     * @param list 单链表
     * @param cursor 链表游标
     * @param val 结点值
     */
    public void addNode(Node<T> list,int cursor,T val){
        Node<T> head = list;
        Node<T> nowNode = head;
        // 在头插入
        if(cursor == 0){
            Node<T> node = new Node<>();
            node.setNext(list);
            node.setVal(val);
            return ;
        }
        // 在中间插入
        for(int i = 0 ; i < cursor ; i++){
            if(nowNode == null){
                throw new IndexOutOfBoundsException();
            }
            nowNode = head;
            head = head.getNext();
        }
        Node<T> node = new Node<>();
        node.setNext(head);
        node.setVal(val);
        nowNode.setNext(node);
    }

    public void printLinkList(Node<T> list){
        Node<T> head = list;
        Node<T> nowNode = null;
        do{
            nowNode = head;
            System.out.println(nowNode.getVal());
            head = head.getNext();
        }while (nowNode.getNext() != null);
    }
}
