package com.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by biang on 2017/12/16.
 */
public class Medium_542_01Matrix {

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return null;
        int row = matrix.length;
        int column = matrix[0].length;

        boolean[][] isVisited = new boolean[row][column];
        Queue<int[]> q = new LinkedList<>();
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 0) {
                    q.add(new int[]{i, j});
                    isVisited[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] zero = q.poll();
            for (int[] di : dir) {
                int r = zero[0] + di[0];
                int c = zero[1] + di[1];
                if (r < 0 || c < 0 || r >= row || c >= column) continue;
                if (!isVisited[r][c]) {
                    isVisited[r][c] = true;
                    q.add(new int[]{r, c});
                    matrix[r][c] = matrix[zero[0]][zero[1]] + 1;
                }
            }
        }
        return matrix;
    }


}
