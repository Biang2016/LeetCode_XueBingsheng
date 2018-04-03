package com.LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by biang on 2017/12/4.
 */
public class Medium_145_BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        recurse(root, res);
        noRecurse(root, res);
        return res;
    }

    private void recurse(TreeNode root, LinkedList<Integer> res) {
        if (root != null) {
            recurse(root.left, res);
            recurse(root.right, res);
            res.add(root.val);
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
            TreeNode point = root;
            TreeNode lastVisit = null;
            while (point != null) {
                s.push(point);
                point = point.left;
            }
            do {
                point = s.pop();
                if (point.right == null || lastVisit == point.right) {
                    res.add(point.val);
                    lastVisit = point;
                } else {
                    s.push(point);
                    point = point.right;
                    while (point != null) {
                        s.push(point);
                        point = point.left;
                    }
                }
            } while (!s.isEmpty());
        }
    }
}
