package com.company;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by biang on 2017/5/8.
 */
public class Medium_236_LowestCommonAncestorOfABinaryTree {
    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        TreeNode n = new TreeNode(2);
        root.left = n;
        TreeNode nn = My_lowestCommonAncestor(root, root, n);
        System.out.println(nn.val);
    }

    //17ms，用一条链表分别把途中经过的父对象记录下来，最后拿两条链表进行比较
    public static TreeNode My_lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> tnl1 = new ArrayList<>();
        List<TreeNode> tnl2 = new ArrayList<>();
        if (contains(root, p, tnl1) & contains(root, q, tnl2)) {
            for (int i = 1; i <= Math.min(tnl1.size(), tnl2.size()); i++) {
                if (tnl1.get(tnl1.size() - i) != tnl2.get(tnl2.size() - i)) {
                    return tnl1.get(tnl1.size() - i + 1);
                }
            }
            return tnl1.get(tnl1.size() - Math.min(tnl1.size(), tnl2.size()));
        }
        return null;
    }


    private static boolean contains(TreeNode root, TreeNode n, List<TreeNode> notes) {
        if (root == null) return false;
        if (root == n || contains(root.left, n, notes) || contains(root.right, n, notes)) {
            notes.add(root);
            return true;
        } else return false;
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        else if (right == null) return left;
        else return root;
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
