package com.LeetCode;

/**
 * Created by biang on 2017/5/7.
 */
public class Easy_463_IslandPerimeter {
    public static void main(String args[]) {

        int[][] a = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        System.out.println(islandPerimeter(a));
        System.out.println(islandPerimeter1(a));
    }

    //143ms
    public static int islandPerimeter(int[][] grid) {
        int output = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    output += 4;
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) output--;
                    if (i > 0 && grid[i - 1][j] == 1) output--;
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) output--;
                    if (j > 0 && grid[i][j - 1] == 1) output--;
                }
            }
        }
        return output;
    }

    //140ms
    public static int islandPerimeter1(int[][] grid) {
        int islands = 0, neighbours = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    islands++; // count islands
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) neighbours++; // count down neighbours
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) neighbours++; // count right neighbours
                }
            }
        }
        return islands * 4 - neighbours * 2;
    }
}

