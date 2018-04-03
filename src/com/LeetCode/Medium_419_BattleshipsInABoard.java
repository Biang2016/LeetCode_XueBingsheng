package com.LeetCode;

/**
 * Created by biang on 2017/5/8.
 */
public class Medium_419_BattleshipsInABoard {
    public static void main(String args[]) {

        char[][] cl = {{'X', '.', '.', 'X'}, {'.', '.', '.', 'X'}, {'.', '.', '.', 'X'}};

        System.out.println(countBattleships(cl));
    }

    public static int My_countBattleships(char[][] board) {
        boolean[] isVer = new boolean[board[0].length];
        boolean lastHor = false;
        int count = 0;
        for (char[] cc : board) {
            for (int i = 0; i < cc.length; i++) {
                if (cc[i] == 'X') {
                    if (!lastHor && !isVer[i]) count++;
                    lastHor = true;
                    isVer[i] = true;
                } else {
                    lastHor = false;
                    isVer[i] = false;
                }
            }
            lastHor = false;
        }
        return count;
    }

    //不需要用布尔数组来记录，直接找左边和上面即可
    public static int countBattleships(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++)
                if (board[i][j] == 'X' && (i == 0 || board[i - 1][j] == '.') && (j == 0 || board[i][j - 1] == '.'))
                    count++;
        return count;
    }
}
