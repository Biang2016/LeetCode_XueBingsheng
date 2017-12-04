package com.company;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by biang on 2017/12/4.
 */
public class Medium_94_BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        recurse(root, res);
        return res;
    }

    private void recurse(TreeNode root, LinkedList<Integer> res) {
        if (root != null) {
            recurse(root.left, res);
            res.add(root.val);
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
}
