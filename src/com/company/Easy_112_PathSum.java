package com.company;

/**
 * Created by biang on 2017/5/15.
 */
public class Easy_112_PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.val == sum && root.left == null && root.right == null) return true;
        int remain = sum - root.val;
        boolean left = false;
        boolean right = false;
        if (root.left != null) left = hasPathSum(root.left, remain);
        if (root.right != null) right = hasPathSum(root.right, remain);
        return left || right;
    }


    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
