package com.LeetCode;

import java.util.HashSet;

/**
 * Created by biang on 2018/1/15.
 */
public class Medium_764_LargestPlusSign {
    //8:50

    public static void main(String args[]) {
        int N = 10;
        int[][] mines = new int[][]{{0, 0}, {0, 1}, {0, 2}, {0, 4}, {0, 5}, {0, 8}, {0, 9}, {1, 0}, {1, 1}, {1, 3}, {1, 5}, {1, 6}, {1, 7}, {1, 9}, {2, 0}, {2, 1}, {2, 2}, {2, 4}, {2, 5}, {2, 6}, {2, 7}, {2, 8}, {3, 0}, {3, 1}, {3, 2}, {3, 4}, {3, 5}, {3, 7}, {3, 8}, {4, 0}, {4, 1}, {4, 2}, {4, 4}, {4, 8}, {4, 9}, {5, 0}, {5, 1}, {5, 2}, {5, 3}, {5, 4}, {5, 6}, {5, 8}, {5, 9}, {6, 0}, {6, 1}, {6, 2}, {6, 3}, {6, 5}, {6, 7}, {6, 8}, {6, 9}, {7, 0}, {7, 1}, {7, 6}, {7, 7}, {7, 8}, {7, 9}, {8, 0}, {8, 1}, {8, 2}, {8, 5}, {8, 9}, {9, 1}, {9, 3}, {9, 4}, {9, 5}, {9, 6}, {9, 8}};
//        int N = 5;
//        int[][] mines = new int[][]{{4, 2}};
        System.out.println(orderOfLargestPlusSign(N, mines));
    }

    //问题：在方阵中找到最大的十字形，返回十字形的阶
    //DP算法，从左往右、从右往左、从上往下、从下往上分别记录一次当前最大连续长度，然后综合取小值
    public static int orderOfLargestPlusSign(int N, int[][] mines) {
        HashSet<Integer> minesHash = new HashSet<>();
        for (int[] mine : mines) {
            minesHash.add(mine[0] * 500 + mine[1]);
        }

        int[][] dp = new int[N][N];

        int cur_MaxOrder = 0;
        for (int i = 0; i < N; i++) {
            int cur_Len_pos = 0;
            for (int j = 0; j < N; j++) {
                if (minesHash.contains(i * 500 + j)) {
                    cur_Len_pos = 0;
                } else {
                    cur_Len_pos++;
                    dp[i][j] = cur_Len_pos;
                }
            }

            int cur_Len_neg = 0;
            for (int j = N - 1; j >= 0; j--) {
                if (minesHash.contains(i * 500 + j)) {
                    cur_Len_neg = 0;
                } else {
                    cur_Len_neg++;
                    dp[i][j] = Math.min(dp[i][j], cur_Len_neg);
                }
            }
        }

        for (int j = 0; j < N; j++) {
            int cur_Len_pos = 0;
            for (int i = 0; i < N; i++) {
                if (minesHash.contains(i * 500 + j)) {
                    cur_Len_pos = 0;
                } else {
                    cur_Len_pos++;
                    dp[i][j] = Math.min(dp[i][j], cur_Len_pos);
                }
            }

            int cur_Len_neg = 0;
            for (int i = N - 1; i >= 0; i--) {
                if (minesHash.contains(i * 500 + j)) {
                    cur_Len_neg = 0;
                } else {
                    cur_Len_neg++;
                    dp[i][j] = Math.min(dp[i][j], cur_Len_neg);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (cur_MaxOrder < dp[i][j]) cur_MaxOrder = dp[i][j];
            }
        }

        return cur_MaxOrder;
    }
}
