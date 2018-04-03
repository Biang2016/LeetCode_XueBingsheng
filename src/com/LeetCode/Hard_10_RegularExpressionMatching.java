package com.LeetCode;

/**
 * Created by biang on 2017/12/21.
 */
public class Hard_10_RegularExpressionMatching {
    public static void main(String args[]) {
        String s = "aaa";
        String p = ".*";
        System.out.println(isMatch(s, p));
    }

    public static boolean isMatch(String s, String p) {
        //Wrong cases
        if (p == null || s == null) return false;
        if (p.length() == 0) {
            if (s.length() == 0) return true;
            else return false;
        }
        if (p.length() == 0) return false;
        char[] p_chars = p.toCharArray();
        char[] s_chars = s.toCharArray();
        if (p_chars[0] == '*') return false;
        for (int i = 0; i < p_chars.length - 1; i++) {
            if (p_chars[i] == '*')
                if (p_chars[i + 1] == ('*'))
                    return false;
        }

        //General cases
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                } else if (j >= 1 && p.charAt(j) == '*') {
                    if (s.charAt(i) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                        dp[i + 1][j + 1] |= dp[i + 1][j];
                        dp[i + 1][j + 1] |= dp[i + 1][j - 1];
                        dp[i + 1][j + 1] |= dp[i][j + 1];
                        dp[i + 1][j + 1] |= dp[i][j];
                        dp[i + 1][j + 1] |= dp[i][j - 1];
                    } else {
                        dp[i + 1][j + 1] |= dp[i + 1][j - 1];
                    }
                }
            }
        }


        return dp[s.length()][p.length()];
    }
}
