package learn.algorithm.list.list0;

import learn.algorithm.list.Node;
import org.springframework.util.CollectionUtils;

/**
 * 1. 创建
 * 2. 插入
 * 3. 删除
 * 4. 遍历
 * 5. 修改
 * @Author Wang WenLei
 * @Date 2021/11/21 12:01
 * @Version 1.0
 **/
public class MyLinkList<T> {
    private Node<T> head;
    private int len;

    public  MyLinkList(){
        this.head = new Node<T>(null,null);
        this.len = 0;
    }

    /**
     * 清空列表
     */
    public void clear() {
        this.head.setNext(null);
        this.len = 0;
    }

    /**
     * 判断是否为空
     * @return 空位true
     */
    public boolean isEmpty() {
        return this.len == 0;
    }

    public T get(int i) {
        if (i <= 0) {
            return null;
        }
        Node<T> node = this.head;
        for (int index = 0 ; index < i ; index++) {
            node = node.getNext();
        }
        return node.getVal();
    }

    public void insert(T val){
        Node<T> item = this.head;
        while (item.getNext() != null) {
            item = item.getNext();
        }
        Node<T> node = new Node<>(null,val);
        item.setNext(node);
        this.len ++;
    }

    public void insert(T val, int i) {
        // 找到前一个节点
        Node<T> pre = head;
        for (int index = 0 ; index < i - 1 ;index ++) {
            pre = pre.getNext();
        }
        // 找到i节点
        Node<T> cur = pre.getNext();
        Node<T> node = new Node<>(null,val);
        // 插入节点
        pre.setNext(node);
        node.setNext(cur);
        this.len ++;
    }

    public T removeNode(T val){
        // 前一个节点
        Node<T> pro = head;
        // 当前节点
        Node<T> item = null;

        // 下一个节点
        Node<T> next = null;
        while (pro.getNext().getNext() != null){
            if (val.equals(pro.getNext().getVal())) {
                pro.setNext(pro.getNext());
                break;
            }
        }
        item = pro.getNext();
        next = item.getNext();

        // 把前一个节点的指针指向后一个节点
        pro.setNext(next);
        this.len --;
        return item.getVal();
    }

    public int indexOf(T t) {
        Node<T> node = this.head;
        for (int i = 0 ; node.getNext() != null ; i++){
            node = node.getNext();
            if (t.equals(node.getVal())) {
                return i;
            }
        }

        return -1;
    }

    public void reverse() {
        if (!this.isEmpty()) {

        }
    }

    public Node<T> reverse(Node<T> cur) {
        if (cur.getNext() == null) {
            head.setNext(cur);
            return cur;
        }
        return null;
    }
}
