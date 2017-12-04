package com.company;

import com.sun.source.tree.BinaryTree;
import com.sun.source.tree.Tree;
import com.sun.tools.hat.internal.util.ArraySorter;

import java.util.Arrays;
import java.util.logging.Level;

/**
 * Created by biang on 2017/11/28.
 */
public class Easy_455_AssignCookies {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int pointG = g.length - 1;
        int pointS = s.length - 1;
        int count = 0;
        while (pointS >= 0 && pointG >= 0) {
            if (s[pointS] >= g[pointG]) {
                count++;
                pointS--;
            }
            pointG--;
        }
        return count;
    }

}
