package com.company;

/**
 * Created by biang on 2017/5/17.
 */
public class Medium_86_PartitionList {
    public static void main(String args[]) {

        ListNode a = new ListNode(2);
        ListNode b = new ListNode(1);
        a.next = b;
        System.out.print(partition(a, 2).val);
    }


    public static ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(x - 1);
        smallHead.next = head;
        ListNode cursor = smallHead;
        ListNode[] record = new ListNode[3];
        int count = 0;
        while (cursor != null) {
            if (cursor.next == null || (cursor.next.val < x ^ cursor.val < x)) {
                record[count] = cursor;
                count++;
                if (count >= 3) {
                    ListNode temp = record[2].next;
                    record[2].next = record[0].next;
                    record[0].next = record[1].next;
                    record[1].next = temp;
                    record[0] = record[2];
                    cursor = record[1];
                    count = 1;
                }
            }
            cursor = cursor.next;
        }
        return smallHead.next;
    }


    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
