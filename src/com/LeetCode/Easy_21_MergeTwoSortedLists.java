package com.LeetCode;

/**
 * Created by biang on 2017/12/8.
 */
public class Easy_21_MergeTwoSortedLists {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //-------------------非递归解法------------------
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode l1_last = null;
        ListNode l1_p = l1;
        ListNode l2_p = l2;
        ListNode head = l1.val < l2.val ? l1 : l2;

        while (l1_p != null && l2_p != null) {
            if (l1_p.val >= l2_p.val) {
                if (l1_last != null) {
                    l1_last.next = l2_p;
                    l1_last = l1_last.next;
                }
                ListNode l2_next = l2_p.next;
                l2_p.next = l1_p;
                l1_last = l2_p;
                l2_p = l2_next;
            } else {
                l1_last = l1_p;
                l1_p = l1_p.next;
            }
        }

        if (l1_p == null) {
            l1_last.next = l2_p;
        }
        return head;
    }

    //---------------递归解法-----------------

    public static ListNode mergeTwoLists2(ListNode l1,ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val<l2.val){
            l1.next=mergeTwoLists2(l1.next,l2);
            return l1;
        }else{
            l2.next=mergeTwoLists2(l1,l2.next);
            return l2;
        }
    }

}
