package com.LeetCode;

/**
 * Created by biang on 2017/5/7.
 */
public class Easy_104_MaxDepthOfBinaryTree {

    public static void main(String args[]) {
        TreeNode node = new TreeNode(0);
        node.left = new TreeNode(1);
        node.right = new TreeNode(1);
        node.right.right = new TreeNode(2);
        System.out.println(maxDepth(node));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        else return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    private static class TreeNode {

        int val;

        TreeNode left;

        TreeNode right;


        TreeNode(int x) {
            val = x;
        }

    }
}
