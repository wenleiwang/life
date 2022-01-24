package learn.note.algorithm.daily.splitlisttopart;

/**
 * 节点
 * @author WangWenLei
 * @DATE: 2021/9/23
 **/
public class ListNode {
    int val;
    ListNode next;
    ListNode (){}
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}
