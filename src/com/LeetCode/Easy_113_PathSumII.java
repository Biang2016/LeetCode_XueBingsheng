package com.LeetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by biang on 2017/5/15.
 */
public class Easy_113_PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        if (root.val == sum && root.left == null && root.right == null) {
            List<Integer> li = new LinkedList<>();
            li.add(root.val);
            res.add(li);
            return res;
        }
        int remain = sum - root.val;
        res.addAll(pathSum(root.left, remain));
        res.addAll(pathSum(root.right, remain));
        for (List<Integer> li : res) {
            li.add(0, root.val);
        }
        return res;
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
