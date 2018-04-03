package com.LeetCode;

/**
 * Created by biang on 2018/1/17.
 */
public class Medium_142_LinkedListCycleII {

    public static void main(String args[]) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        a.next = b;
        b.next = a;
        System.out.println(detectCycle(a));
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        int counter = 0;
        while (true) {
            counter++;
            if (slow.next == null || fast.next == null || fast.next.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }

        fast = head;
        slow = head;
        for (int i = 0; i < counter; i++) {
            fast = fast.next;
        }

        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
