package com.LeetCode;

/**
 * Created by biang on 2017/12/16.
 */
public class Medium_304_RangeSumQuery2DImmutable {
    public static void main(String args[]) {
        int[][] ma = new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        Medium_304_RangeSumQuery2DImmutable aaa = new Medium_304_RangeSumQuery2DImmutable(ma);
        System.out.println(aaa.sumRegion(2, 1, 4, 3));
        System.out.println(aaa.sumRegion(1, 1, 2, 2));
        System.out.println(aaa.sumRegion(1, 2, 2, 4));
    }

    public Medium_304_RangeSumQuery2DImmutable(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        if (matrix[0] == null || matrix[0].length == 0) return;
        sumMatrix = new int[matrix.length][matrix[0].length];

        sumMatrix[0][0] = matrix[0][0];
        for (int i = 1; i < matrix.length; i++) {
            sumMatrix[i][0] = sumMatrix[i - 1][0] + matrix[i][0];
        }
        for (int j = 1; j < matrix[0].length; j++) {
            sumMatrix[0][j] = sumMatrix[0][j - 1] + matrix[0][j];
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                sumMatrix[i][j] = sumMatrix[i - 1][j] + sumMatrix[i][j - 1] - sumMatrix[i - 1][j - 1] + matrix[i][j];
            }
        }
    }

    int[][] sumMatrix;

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 < 0 || col1 < 0 || row2 < 0 || col2 < 0) return -1;
        if (row1 >= sumMatrix.length || row2 >= sumMatrix.length || col1 >= sumMatrix[0].length || col2 >= sumMatrix[0].length)
            return -1;
        if (row1 > row2 || col1 > col2) return -1;
        int res = 0;
        if (col1 == 0 && row1 == 0) return sumMatrix[row2][col2];
        if (col1 == 0 && row1 != 0) {
            res = sumMatrix[row2][col2] - sumMatrix[row1 - 1][col2];
        } else if (col1 != 0 && row1 == 0) {
            res = sumMatrix[row2][col2] - sumMatrix[row2][col1 - 1];
        } else {
            res = sumMatrix[row2][col2] - sumMatrix[row1 - 1][col2] - sumMatrix[row2][col1 - 1] + sumMatrix[row1 - 1][col1 - 1];
        }
        return res;
    }


}
