package com.LeetCode;

/**
 * Created by biang on 2018/1/17.
 */
public class Easy_141_LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && slow != null) {
            fast = fast.next;
            slow = slow.next;

            if (fast == null) return false;
            fast = fast.next;
            if (fast == slow) return true;
        }
        return false;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
