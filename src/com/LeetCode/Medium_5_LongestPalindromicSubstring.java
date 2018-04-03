package com.LeetCode;

import java.util.Arrays;

/**
 * Created by biang on 2017/12/16.
 */
public class Medium_5_LongestPalindromicSubstring {
    public static void main(String args[]) {
        System.out.println(longestPalindrome("ababababa"));
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;
        int[] A = new int[s.length()];
        char[] chars = s.toCharArray();
        Arrays.fill(A, 1);
        int maxA = 1;
        int maxAIndex = 0;

        for (int i = 1; i < chars.length; i++) {
            int lowBound = chars.length;
            int offset = 1;
            do {
                lowBound = Math.min(lowBound, i - offset - A[i - offset] + 1);
                offset++;
                if (i - offset == lowBound) break;
            } while (i - offset >= lowBound);
            if (lowBound > 0) {
                if (chars[i] == chars[lowBound - 1]) A[i] = i - lowBound + 2;
            }
            for (int j = lowBound; j < i; j++) {
                if (chars[j] == chars[i]) {
                    if (isPalindrome(s.substring(j + 1, i))) {
                        A[i] = Math.max(A[i], i - j + 1);
                        break;
                    }
                }

            }

            if (A[i] > maxA) {
                maxA = A[i];
                maxAIndex = i;
            }
        }

        return s.substring(maxAIndex - maxA + 1, maxAIndex + 1);
    }

    public static boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) return true;
        char[] chars = s.toCharArray();
        boolean res = true;
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - i - 1]) res = false;
        }
        return res;
    }



    //采用双向延伸的方式，复杂度O(n^2)
    //others' better solution
    private int lo, maxLen;
    public String longestPalindrome2(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len-1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i+1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }

    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }
}
