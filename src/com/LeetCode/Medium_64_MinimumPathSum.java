package com.LeetCode;

/**
 * Created by biang on 2017/11/29.
 */
public class Medium_64_MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int[][] pathSum = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    pathSum[i][j]=grid[i][j];
                    continue;
                }
                int top = i > 0 ? pathSum[i - 1][j] : Integer.MAX_VALUE;
                int left = j > 0 ? pathSum[i][j - 1] : Integer.MAX_VALUE;
                pathSum[i][j] = Math.min(left, top) + grid[i][j];
            }
        }
        return pathSum[grid.length - 1][grid[0].length - 1];
    }

}
