package com.company;

import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by biang on 2017/5/16.
 */
public class Medium_79_WordSearch {
    public static void main(String args[]) {
        char[][] b = new char[3][4];
        b[0] = new char[]{'a', 'b', 'c', 'e'};
        b[1] = new char[]{'s', 'f', 'e', 's'};
        b[2] = new char[]{'a', 'd', 'e', 'e'};
        System.out.println(exist(b, "abceseeefs"));
    }


    //将word转成charArray可以节省每次的读取时间
    //每个路径true了之后及时return，避免不需要的计算
    //8ms
    public static boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        path = word.toCharArray();
        char begin = word.charAt(0);
        boolean flag = false;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (board[i][j] == begin) {
                    flag |= help(board, 0, i, j);
                    if (flag) return flag;
                }
        return false;
    }

    private static boolean help(char[][] board, int wordPos, int m, int n) {
        if (wordPos == path.length || path[wordPos] != board[m][n]) return false;
        if (wordPos == path.length - 1 && path[wordPos] == board[m][n]) return true;
        board[m][n] += 256;
        boolean flag = false;
        wordPos++;
        if (m > 0) if (flag |= help(board, wordPos, m - 1, n)) return flag;
        if (m < rows - 1) if (flag |= help(board, wordPos, m + 1, n)) return flag;
        if (n > 0) if (flag |= help(board, wordPos, m, n - 1)) return flag;
        if (n < cols - 1) if (flag |= help(board, wordPos, m, n + 1)) return flag;
        board[m][n] -= 256;
        return false;
    }


    static char[][] map;
    static char[] path;
    static int rows;
    static int cols;

    //6ms
    public boolean exist1(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0) return false;
        if (word.length() == 0) return true;

        rows = board.length;
        cols = board[0].length;
        map = board;
        path = word.toCharArray();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (map[i][j] == path[0] && find(i, j, 0)) return true;
            }
        }

        return false;
    }

    private boolean find(int i, int j, int index) {
        if (index == path.length - 1) return true;

        map[i][j] ^= 256;//用bit蒙版掩盖该字符，即+=256

        if (i - 1 >= 0 && map[i - 1][j] == path[index + 1]) {
            if (find(i - 1, j, index + 1)) return true;
        }
        if (i + 1 < rows && map[i + 1][j] == path[index + 1]) {
            if (find(i + 1, j, index + 1)) return true;
        }
        if (j - 1 >= 0 && map[i][j - 1] == path[index + 1]) {
            if (find(i, j - 1, index + 1)) return true;
        }
        if (j + 1 < cols && map[i][j + 1] == path[index + 1]) {
            if (find(i, j + 1, index + 1)) return true;
        }

        map[i][j] ^= 256;//将该位置字符恢复为原值

        return false;

    }

}
