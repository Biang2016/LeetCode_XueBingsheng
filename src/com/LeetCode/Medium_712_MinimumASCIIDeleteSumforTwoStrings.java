package com.LeetCode;

/**
 * Created by biang on 2017/11/29.
 */
public class Medium_712_MinimumASCIIDeleteSumforTwoStrings {
    public static void main(String args[]) {
        String s1 = "sea";
        String s2 = "eat";
        System.out.println(minimumDeleteSum(s1, s2));
    }

    public static int minimumDeleteSum(String s1, String s2) {
        int[][] cost = new int[s1.length() + 1][s2.length() + 1];

        for (int j = 1; j <= s2.length(); j++) {
            cost[0][j] = cost[0][j - 1] + s2.charAt(j-1);
        }

        for (int i = 1; i <= s1.length(); i++) {
            cost[i][0] = cost[i - 1][0] + s1.charAt(i-1);
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) cost[i][j] = cost[i - 1][j - 1];
                else {
                    cost[i][j] = Math.min(cost[i - 1][j] + s1.charAt(i-1), cost[i][j - 1] + s2.charAt(j-1));
                }
            }
        }

        return cost[s1.length()][s2.length()];
    }
}
