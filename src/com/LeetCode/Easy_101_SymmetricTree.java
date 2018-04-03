package com.LeetCode;

import java.util.Stack;
import java.util.logging.Level;

/**
 * Created by biang on 2018/1/17.
 */
public class Easy_101_SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        if (a.val != b.val) return false;
        if (isMirror(a.left, b.right) && isMirror(a.right, b.left)) return true;
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

    public boolean isSymmetric_iterate(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack_l = new Stack<>();
        Stack<TreeNode> stack_r = new Stack<>();
        TreeNode cur_l = root;
        TreeNode cur_r = root;

        while (true) {
            if (cur_l.left == null && cur_r.right == null) break;
            if (cur_l.left == null || cur_r.right == null) return false;
            cur_l = cur_l.left;
            cur_r = cur_r.right;
            if (cur_l.val != cur_r.val) return false;
            stack_l.push(cur_l);
            stack_r.push(cur_r);
        }

        while (true) {
            if (stack_l.isEmpty() ^ stack_r.isEmpty()) return false;
            if (stack_l.isEmpty() && stack_r.isEmpty()) return true;
            cur_l = stack_l.pop();
            cur_r = stack_r.pop();

            if (cur_l.right == null && cur_r.left == null) continue;
            if (cur_l.right == null || cur_r.left == null) return false;
            cur_l = cur_l.right;
            cur_r = cur_r.left;
            if (cur_l.val != cur_r.val) return false;
            stack_l.push(cur_l);
            stack_r.push(cur_r);

            while (true) {
                if (cur_l.left == null && cur_r.right == null) break;
                if (cur_l.left == null || cur_r.right == null) return false;
                cur_l = cur_l.left;
                cur_r = cur_r.right;
                if (cur_l.val != cur_r.val) return false;
                stack_l.push(cur_l);
                stack_r.push(cur_r);
            }
        }
    }
}
