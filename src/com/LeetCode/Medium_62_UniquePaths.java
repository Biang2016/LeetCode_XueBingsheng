package com.LeetCode;

/**
 * Created by biang on 2017/5/15.
 */
public class Medium_62_UniquePaths {

    public static void main(String args[]) {

        System.out.println(uniquePaths2(10, 10));
    }

    public static int uniquePaths(int m, int n) {
        int totalStep = m + n - 2;
        int smallOne = Math.min(m - 1, n - 1);
        long a = 1;
        long b = 1;
        for (int i = 1; i <= smallOne; i++) {
            a *= i;
            b *= totalStep - i + 1;
        }
        return (int) (b / a);
    }

    public static int uniquePaths2(int m, int n) {
        int[][] pos = new int[m][n];
        pos[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0) pos[i][j] += pos[i - 1][j];
                if (j > 0) pos[i][j] += pos[i][j - 1];
            }
        }
        return pos[m - 1][n - 1];
    }
}
