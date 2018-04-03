package com.LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by biang on 2017/12/4.
 */
public class Medium_94X_BinaryTreeLayerOrderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        noRecurse(root, res);
        return res;
    }

    Queue<TreeNode> q = new LinkedList<>();

    private void noRecurse(TreeNode root, LinkedList<Integer> res) {
        if (root != null) {
            q.add(root);
            while (!q.isEmpty()) {
                TreeNode out = q.poll();
                res.add(out.val);
                if (out.left != null) q.add(out.left);
                if (out.right != null) q.add(out.right);
            }
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
