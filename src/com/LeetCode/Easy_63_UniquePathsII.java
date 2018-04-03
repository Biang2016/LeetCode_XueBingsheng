package com.LeetCode;

/**
 * Created by biang on 2017/5/16.
 */
public class Easy_63_UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] pos = new int[m][n];
        if (obstacleGrid[0][0] != 1) pos[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] != 1) {
                    if (i > 0) pos[i][j] += pos[i - 1][j];
                    if (j > 0) pos[i][j] += pos[i][j - 1];
                }
            }
        }
        return pos[m - 1][n - 1];
    }


}
