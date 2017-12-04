package com.company;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;

/**
 * Created by biang on 2017/5/15.
 */
public class Easy_437_PathSumIII {

    public static void main(String args[]) {
        long time = System.nanoTime();
        TreeNode node = new TreeNode(0);
        node.right = new TreeNode(0);
        node.right.right = new TreeNode(0);
        node.right.right.right = new TreeNode(0);
        node.right.right.right.right = new TreeNode(0);
        int a = My_pathSum(node, 0);
        System.out.println(a);
        System.out.println(System.nanoTime() - time);
    }

    //Time limit Exceeded
    public static int My_pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        int res = 0;
        res += pathSumFromRoot(root, sum);
        res += My_pathSum(root.left, sum);
        res += My_pathSum(root.right, sum);
        return res;
    }

    private static int pathSumFromRoot(TreeNode root, int sum) {
        int res = 0;
        if (root == null) return 0;
        if (root.val == sum) res++;
        int remain = sum - root.val;
        int l = pathSumFromRoot(root.left, remain);
        int r = pathSumFromRoot(root.right, remain);
        res += l + r;
        return res;
    }

    //17ms,Prefix sum method
    public int pathSum2(TreeNode root, int sum) {
        HashMap<Integer, Integer> preSum = new HashMap();
        preSum.put(0, 1);
        return helper(root, 0, sum, preSum);
    }

    public int helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
        if (root == null) {
            return 0;
        }

        currSum += root.val;
        int res = preSum.getOrDefault(currSum - target, 0);
        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);

        res += helper(root.left, currSum, target, preSum) + helper(root.right, currSum, target, preSum);
        preSum.put(currSum, preSum.get(currSum) - 1);
        return res;
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
