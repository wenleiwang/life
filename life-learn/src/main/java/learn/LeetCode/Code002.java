package learn.LeetCode;

import learn.LeetCode.Util.ListNode;
import learn.algorithm.list.Node;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author WangWenLei
 * @DATE: 2021/6/9
 **/
public class Code002 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode node = head;
        while(l1 != null || l2 != null){
            if(l1 != null && l2 != null){
                if(node.next != null){
                    if((l1.val + l2.val + node.next.val) / 10 > 0){
                        node.next = new ListNode(((l1.val + l2.val + node.next.val) % 10),new ListNode((l1.val + l2.val + node.next.val) / 10));
                    }else{
                        node.next = new ListNode((l1.val + l2.val + node.next.val) % 10);
                    }
                }else{
                    if((l1.val + l2.val) / 10 > 0){
                        node.next = new ListNode((l1.val + l2.val) % 10,new ListNode((l1.val + l2.val) / 10));
                    }else{
                        node.next = new ListNode((l1.val + l2.val) % 10);
                    }
                }

                l1 = l1.next;
                l2 = l2.next;
            }else if(l1 == null){
                if(node.next != null){
                    if(( l2.val + node.next.val) / 10 > 0){
                        node.next = new ListNode(((l2.val + node.next.val) % 10),new ListNode((l2.val + node.next.val) / 10));
                    }else{
                        node.next = new ListNode((l2.val + node.next.val) % 10);
                    }
                }else{
                    if((l2.val) / 10 > 0){
                        node.next = new ListNode((l2.val) % 10,new ListNode((l2.val) / 10));
                    }else{
                        node.next = new ListNode((l2.val) % 10);
                    }
                }
                l2 = l2.next;
            }else{
                if(node.next != null){
                    if(( l1.val + node.next.val) / 10 > 0){
                        node.next = new ListNode(((l1.val + node.next.val) % 10),new ListNode((l1.val + node.next.val) / 10));
                    }else{
                        node.next = new ListNode((l1.val + node.next.val) % 10);
                    }
                }else{
                    if((l1.val) / 10 > 0){
                        node.next = new ListNode((l1.val) % 10,new ListNode((l1.val) / 10));
                    }else{
                        node.next = new ListNode((l1.val) % 10);
                    }
                }
                l1 = l1.next;
            }
            node = node.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9,new ListNode(9,new ListNode(1)));
        ListNode l2 = new ListNode(1);
        ListNode listNode = addTwoNumbers(l1, l2);
        ListNode head = listNode;
        ListNode nowNode = null;
        do{
            nowNode = head;
            System.out.println(nowNode.val);
            head = head.next;
        }while (nowNode.next != null);
    }
}
