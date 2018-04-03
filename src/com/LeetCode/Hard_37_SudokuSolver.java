package com.LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by biang on 2017/12/21.
 */
public class Hard_37_SudokuSolver {
    public static void main(String args[]) {
        char[][] board = new char[][]{{'.', '.', '9', '7', '4', '8', '.', '.', '.'}, {'7', '.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '2', '.', '1', '.', '9', '.', '.', '.'}, {'.', '.', '7', '.', '.', '.', '2', '4', '.'}, {'.', '6', '4', '.', '1', '.', '5', '9', '.'}, {'.', '9', '8', '.', '.', '.', '3', '.', '.'}, {'.', '.', '.', '8', '.', '3', '.', '2', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.', '6'}, {'.', '.', '.', '2', '7', '5', '9', '.', '.'}};
        Hard_37_SudokuSolver a = new Hard_37_SudokuSolver();
        a.solveSudoku(board);
        int aa = 0;
    }

    char[][] board;
    boolean[][][] notNum = new boolean[9][9][9];
    int[][] notNum_count = new int[9][9];
    LinkedList<Integer[]> numCanBeFilled = new LinkedList<>();//完全确定的格子

    //尝试的数字
    Stack<Integer[]> backList = new Stack<>();
    //尝试的副作用
    Stack<Integer[]> sideEffect_List = new Stack<>();

    boolean isBadGuess = false;
    boolean isComplete = true;

    public Hard_37_SudokuSolver() {

    }

    public Hard_37_SudokuSolver(Stack<Integer[]> bl) {
        this.backList = bl;
    }

    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) return;
        this.board = board;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char ch = board[i][j];
                if (ch != '.' && ch >= '1' && ch <= '9') {
                    int num = ch - '1';
                    newNumberFill(i, j, num);
                }
            }
        }

        while (!sideEffect_List.isEmpty()) sideEffect_List.pop();
        //将目前为止完全确定答案的格子填入数字
        checkEasyFilling();//如果发生冲突使isComplete为false
        //如果这样就发生冲突的话，说明本数独无法完成
        if (!isComplete) {
            //如果所有的子猜测都不成功，说明本猜测是错误的，清除所有副作用
            while (!sideEffect_List.isEmpty()) {
                Integer[] back = sideEffect_List.pop();
                board[back[0]][back[1]] = '.';
            }
            return;
        }

        //判断是否完成
        int completeCount = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') isComplete = false;
                else completeCount++;
            }
        }
        System.out.println(completeCount);

        if (!isComplete) {
            Guess();
            if (!isComplete) {
                //如果所有的子猜测都不成功，说明本猜测是错误的，清除所有副作用
                while (!sideEffect_List.isEmpty()) {
                    Integer[] back = sideEffect_List.pop();
                    board[back[0]][back[1]] = '.';
                }
            }
        }
    }

    private void Guess() {
        //找到条件分支最少的格子
        int maxPsb = 0;
        Integer[] maxPsb_Index = new Integer[2];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (maxPsb < notNum_count[i][j]) {
                    maxPsb = notNum_count[i][j];
                    maxPsb_Index[0] = i;
                    maxPsb_Index[1] = j;

                }
            }
        }

        for (int k = 0; k < 9; k++) {
            if (!notNum[maxPsb_Index[0]][maxPsb_Index[1]][k]) {
                //填入猜测数字
                board[maxPsb_Index[0]][maxPsb_Index[1]] = (char) (k + '1');
                //记载在回溯栈中
                backList.push(maxPsb_Index);
                //创建子类去尝试
                Hard_37_SudokuSolver childGuess = new Hard_37_SudokuSolver(backList);
                childGuess.solveSudoku(board);
                if (childGuess.isComplete) {
                    isComplete = true;
                    return;
                } else {
                    //不成功则回滚一次
                    Integer[] back = backList.pop();
                    board[back[0]][back[1]] = '.';
                }
            }
        }
    }


    //将目前为止完全确定答案的格子填入数字
    private void checkEasyFilling() {
        while (!numCanBeFilled.isEmpty()) {
            Integer[] newNum = numCanBeFilled.remove(0);
            int num = -1;
            for (int k = 0; k < 9; k++) {
                if (!notNum[newNum[0]][newNum[1]][k]) {
                    num = k;
                }
            }
            if (num == -1) {
                isComplete = false;
                return;
            }
            newNumberFill(newNum[0], newNum[1], num);
        }
    }


    //向某个格子填入确定答案
    private void newNumberFill(int i, int j, int num) {
        board[i][j] = (char) (num + '1');
        sideEffect_List.push(new Integer[]{i, j});
        notNum_count[i][j] = -1;//有初始数字的格子，标记为-1

        //计算该行其它格子不可能填入的数（有初始数字的格子除外）
        for (int jj = 0; jj < board[0].length; jj++) {
            if (notNum_count[i][jj] == -1) continue;
            record(num, i, jj);
        }

        //计算该列其它格子不可能填入的数（有初始数字的格子除外）
        for (int ii = 0; ii < board.length; ii++) {
            if (notNum_count[ii][j] == -1) continue;
            record(num, ii, j);
        }

        //计算该九宫格其它格子不可能填入的数（有初始数字的格子除外）
        int begin_R = i / 3 * 3;
        int begin_C = j / 3 * 3;
        for (int ii = begin_R; ii < begin_R + 3; ii++) {
            for (int jj = begin_C; jj < begin_C + 3; jj++) {
                if (notNum_count[ii][jj] == -1) continue;
                record(num, ii, jj);
            }
        }
    }

    private void record(int num, int i, int j) {
        if (!notNum[i][j][num]) {
            notNum[i][j][num] = true;
            notNum_count[i][j]++;
            if (notNum_count[i][j] == 9) isBadGuess = true;
            if (notNum_count[i][j] == 8) {
                numCanBeFilled.add(new Integer[]{i, j});
            }
        }
    }

}
