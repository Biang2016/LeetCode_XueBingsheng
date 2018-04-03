package com.LeetCode;

import java.util.*;

/**
 * Created by biang on 2017/12/4.
 */
public class Medium_144_BinaryTreePreorderTraversal {

    //递归解法
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        recurse(root, res);
        noRecurse(root, res);
        return res;
    }

    private void recurse(TreeNode root, LinkedList<Integer> res) {
        if (root != null) {
            res.add(root.val);
            recurse(root.left, res);
            recurse(root.right, res);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //非递归解法
    Stack<TreeNode> s = new Stack<>();

    private void noRecurse(TreeNode root, LinkedList<Integer> res) {
        if (root != null) {
            s.push(root);
            while (!s.isEmpty()) {
                TreeNode out = s.pop();
                res.add(out.val);
                if (out.right != null) s.push(out.right);
                if (out.left != null) s.push(out.left);
            }
        }
    }

}
