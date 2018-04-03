package com.LeetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by biang on 2018/1/21.
 */
public class Custom_FindAllSquares {
    public static void main(String args[]) {
        int[][] Grid = new int[][]{
                {2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2},
                {2, 2, 2, 3, 3},
                {0, 2, 2, 3, 3},
                {0, 0, 2, 3, 3}
        };
        List<Integer[]> eee = FindAllSquares(Grid, 4);
    }

    //在一个矩阵中找到数字相同的最大的矩形（边长2及以上）
    //且排除掉等于-1的数字
    public static List<Integer[]> FindAllSquares(int[][] grid, int colorNum) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return null;
        List<Integer[]> res = new LinkedList<>();

        int[][][] dp = new int[grid.length + 1][grid[0].length + 1][colorNum];

        int[] max = new int[colorNum];
        for (int i = 1; i <= grid.length; i++) {
            for (int j = 1; j <= grid[0].length; j++) {
                for (int c = 0; c < colorNum; c++) {
                    if (grid[i - 1][j - 1] == c) {
                        dp[i][j][c] = Math.min(Math.min(dp[i - 1][j - 1][c], dp[i][j - 1][c]), dp[i - 1][j][c]) + 1;
                        max[c] = Math.max(max[c], dp[i][j][c]);
                    }
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j][2] + "    ");
            }
            System.out.println();
        }

        for (int c = 0; c < colorNum; c++) {
            if (max[c] > 1) {
                int count = 0;
                int countMax_Row = 0;
                int[] rightBottom_Row = new int[2];
                for (int i = 0; i < dp.length; i++) {
                    for (int j = 0; j < dp[0].length; j++) {
                        if (dp[i][j][c] == max[c]) {
                            count++;
                            if (count > countMax_Row) {
                                countMax_Row = count;
                                rightBottom_Row[0] = i - 1;
                                rightBottom_Row[1] = j - 1;
                            }
                        } else {
                            count = 0;
                        }
                    }
                    count = 0;
                }

                int countMax_Col = 0;
                int[] rightBottom_Col = new int[2];
                for (int j = 0; j < dp[0].length; j++) {
                    for (int i = 0; i < dp.length; i++) {
                        if (dp[i][j][c] == max[c]) {
                            count++;
                            if (count > countMax_Col) {
                                countMax_Col = count;
                                rightBottom_Col[0] = i - 1;
                                rightBottom_Col[1] = j - 1;
                            }
                        } else {
                            count = 0;
                        }
                    }
                    count = 0;
                }

                if (countMax_Row > countMax_Col) {
                    res.add(new Integer[]{c, rightBottom_Row[0] - max[c] + 1, rightBottom_Row[1] - (countMax_Row + max[c] - 1) + 1,
                            max[c], countMax_Row + max[c] - 1});
                } else {
                    res.add(new Integer[]{c, rightBottom_Col[0] - (countMax_Col + max[c] - 1) + 1, rightBottom_Col[1] -
                            max[c] + 1, countMax_Col + max[c] - 1, max[c]});
                }
            }
        }

        if (res.size() != 0) {
            int[][] resultGrid = new int[grid.length][grid[0].length];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    resultGrid[i][j] = grid[i][j];
                }
            }
            for (Integer[] box : res) {
                for (int i = box[1]; i <= box[1] + box[3] - 1; i++) {
                    for (int j = box[2]; j <= box[2] + box[4] - 1; j++) {
                        resultGrid[i][j] = -1;
                    }
                }
            }
            List<Integer[]> newRes = FindAllSquares(resultGrid, colorNum);
            for (Integer[] box : newRes) {
                res.add(box);
            }
        }

        return res;
    }
}
