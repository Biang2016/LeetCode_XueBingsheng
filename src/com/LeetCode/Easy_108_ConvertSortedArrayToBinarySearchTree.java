package com.LeetCode;

/**
 * Created by biang on 2017/5/11.
 */
public class Easy_108_ConvertSortedArrayToBinarySearchTree {

    public static void main(String args[]) {
        int[] a = new int[]{3, 5, 8};
        TreeNode n = sortedArrayToBST(a);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public static TreeNode sortedArrayToBST(int[] nums, int begin, int end) {
        if (begin > end) return null;
        int medium = (begin + end + 1) / 2;
        TreeNode node = new TreeNode(nums[medium]);
        if (medium > begin) node.left = sortedArrayToBST(nums, begin, medium - 1);
        if (medium < end) node.right = sortedArrayToBST(nums, medium + 1, end);
        return node;
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
