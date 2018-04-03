package com.LeetCode;

/**
 * Created by biang on 2018/1/16.
 */
public class Easy_100_SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right)) return true;
        return false;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}