package learn.note.algorithm.daily.splitlisttopart;

import java.util.Scanner;

/**
 * @author WangWenLei
 * @DATE: 2021/9/23
 **/
public class Solution {
    public static ListNode[] splitListToParts(ListNode head, int k){
        ListNode item = head;
        int i = 0;
        while(item != null){
            i ++;
            item = item.next;
        }
        if(k <= 0){
            return new ListNode[0];
        }
        int l = i / k;
        int r = i % k;
        ListNode [] data = new ListNode[k];
        int j = 0;
        i = 0;
        ListNode sigle = head;
        ListNode listNode = null,listHead = null;
        int kaojink = 0;
        while(sigle != null){
            j ++ ;
            i ++ ;
            if(j == 1){
                listNode = sigle;
                listHead = sigle;
            }
            if(j >= l){
                data[kaojink] = listHead;
            }else{
                listNode = listNode.next;
            }
            sigle = sigle.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head = null;

        Scanner sc = new Scanner(System.in);
        // 构建一个单链表
        while(sc.hasNextInt()){
            if(head == null){
                head = new ListNode(sc.nextInt());
            }else{
                ListNode oldHead = head;
                head = new ListNode(sc.nextInt());
                head.next = oldHead;
            }
        }
        ListNode item = head;
        while (item != null){
            System.out.print(item.val);
            item = item.next;
        }
    }
}
