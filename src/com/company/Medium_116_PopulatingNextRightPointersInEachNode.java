package com.company;

/**
 * Created by biang on 2017/7/18.
 */
public class Medium_116_PopulatingNextRightPointersInEachNode {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        if (root.next != null)
            if (root.right != null)
                root.right.next = root.next.left;
        if (root.left != null) {
            root.left.next = root.right;
            if (root.left.right != null)
                root.left.right.next = root.right.left;
        }
        connect(root.left);
        connect(root.right);
    }

    class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }
}



