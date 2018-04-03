package com.LeetCode;

import java.util.*;

/**
 * Created by biang on 2018/1/14.
 */
public class Medium_756_PyramidTransitionMatrix {
    public static void main(String args[]) {
        String bottom = "AABA";
        List<String> allowed = new ArrayList<String>();
        allowed.add("AAA");
        allowed.add("AAB");
        allowed.add("ABA");
        allowed.add("ABB");
        allowed.add("BAC");
        System.out.println(pyramidTransition(bottom, allowed));
    }

    public static boolean pyramidTransition(String bottom, List<String> allowed) {
        int nlayers = bottom.length();
        HashSet<Character>[] lastPoss = new HashSet[nlayers];
        for (int i = 0; i < lastPoss.length; i++) {
            lastPoss[i] = new HashSet<>();
            lastPoss[i].add(bottom.charAt(i));
        }

        while (nlayers > 1) {
            nlayers--;
            HashSet<Character>[] poss = new HashSet[nlayers];
            for (int i = 0; i < poss.length; i++) {
                poss[i] = new HashSet<>();
                for (int j = 0; j < allowed.size(); j++) {
                    if (!poss[i].contains(allowed.get(j).charAt(2)) && lastPoss[i].contains(allowed.get(j).charAt(0)) && lastPoss[i + 1].contains(allowed.get(j).charAt(1))) {
                        poss[i].add(allowed.get(j).charAt(2));
                    }
                }
            }

            for (int i = 0; i < poss.length; i++) {
                if (poss[i].size() == 0) return false;
            }

            lastPoss = poss;
        }

        return true;
    }




    //------大神解法---DFS算法----并采用位记录法来代替我的hashset数据结构
    int[][] T;
    Set<Long> seen;

    public boolean pyramidTransition2(String bottom, List<String> allowed) {
        T = new int[7][7];//记录所有的可行堆叠方案
        for (String a: allowed)
            T[a.charAt(0) - 'A'][a.charAt(1) - 'A'] |= 1 << (a.charAt(2) - 'A');

        seen = new HashSet();
        int N = bottom.length();
        int[][] A = new int[N][N];
        int t = 0;
        for (char c: bottom.toCharArray())
            A[N-1][t++] = c - 'A';
        return solve(A, 0, N-1, 0);
    }

    //A[i] - the ith row of the pyramid
    //R - integer representing the current row of the pyramid
    //N - length of current row we are calculating
    //i - index of how far in the current row we are calculating
    //Returns true iff pyramid can be built
    public boolean solve(int[][] A, long R, int N, int i) {
        if (N == 1 && i == 1) { // If successfully placed entire pyramid
            return true;
        } else if (i == N) {
            if (seen.contains(R)) return false; // If we've already tried this row, give up
            seen.add(R); // Add row to cache
            return solve(A, 0, N-1, 0); // Calculate next row
        } else {
            // w's jth bit is true iff block #j could be
            // a parent of A[N][i] and A[N][i+1]
            int w = T[A[N][i]][A[N][i+1]];
            // for each set bit in w...
            for (int b = 0; b < 7; ++b) if (((w >> b) & 1) != 0) {
                A[N-1][i] = b; //set parent to be equal to block #b
                //If rest of pyramid can be built, return true
                //R represents current row, now with ith bit set to b+1
                // in base 8.
                if (solve(A, R * 8 + (b+1), N, i+1)) return true;   //这里开始dfs
            }
            return false;
        }
    }
}
