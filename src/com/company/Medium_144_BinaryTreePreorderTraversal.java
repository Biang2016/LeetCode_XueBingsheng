package com.company;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by biang on 2017/12/4.
 */
public class Medium_144_BinaryTreePreorderTraversal {

    //递归解法
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        recurse(root, res);
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


}
