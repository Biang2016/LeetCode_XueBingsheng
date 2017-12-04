package com.company;

/**
 * Created by biang on 2017/7/18.
 */
public class Medium_2_AddTwoNumbers {
    public static void main(String args[]) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(5);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        addTwoNumbers(l1, l2);
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode out = new ListNode(0);
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode point = out;
        while (p1 != null || p2 != null) {
            int a = 0;
            int b = 0;
            if (p1 != null) {
                a = p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                b = p2.val;
                p2 = p2.next;
            }
            int sum = a + b;
            if (point.next == null) point.next = new ListNode(0);
            point = point.next;
            point.val += sum;
            if (point.val >= 10) {
                point.next = new ListNode(1);
                point.val %= 10;
            }
        }
        return out.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
