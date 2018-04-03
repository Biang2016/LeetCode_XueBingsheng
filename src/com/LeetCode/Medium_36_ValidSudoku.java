package com.LeetCode;

/**
 * Created by biang on 2017/12/21.
 */
public class Medium_36_ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) return false;
        boolean[][][] isVisited = new boolean[3][9][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char ch = board[i][j];
                if (ch != '.' && ch >= '1' && ch <= '9') {
                    int num = ch - '1';
                    if (isVisited[0][i][num]) return false;
                    if (isVisited[1][j][num]) return false;
                    if (isVisited[2][i / 3 * 3 + j / 3][num]) return false;
                    isVisited[0][i][num] = true;
                    isVisited[1][j][num] = true;
                    isVisited[2][i / 3 * 3 + j / 3][num] = true;
                }
            }
        }
        return true;
    }

}
