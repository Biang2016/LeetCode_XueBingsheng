package com.LeetCode;

/**
 * Created by biang on 2018/1/16.
 */
public class Easy_83_RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode nxt = head.next;
        if (nxt.val == head.val) {
            head.next = nxt.next;
            deleteDuplicates(head);
        } else
            deleteDuplicates(head.next);
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    //3行代码
    public ListNode deleteDuplicates2(ListNode head) {
        if(head == null || head.next == null)return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }
}
