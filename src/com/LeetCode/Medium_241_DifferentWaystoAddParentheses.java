package com.LeetCode;

import java.util.List;

/**
 * Created by biang on 2017/11/23.
 */
public class Medium_241_DifferentWaystoAddParentheses {
    public static void main(String args[]) {
        diffWaysToCompute("2-1-3");
    }

    public static List<Integer> diffWaysToCompute(String input) {
        String[] S_nums = input.split("\\+|-|\\*");
        int[] nums = new int[S_nums.length];
        for (int i = 0; i < S_nums.length; i++) {
            nums[i] = Integer.parseInt(S_nums[i]);
        }

        char[] operators = new char[nums.length - 1];
        int ii = 0;
        for (char c : input.toCharArray()) {
            if (c == '+' || c == '-' || c == '*') operators[ii] = c;
            ii++;
        }




        return null;
    }

}
