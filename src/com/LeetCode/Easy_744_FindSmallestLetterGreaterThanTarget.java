package com.LeetCode;

/**
 * Created by biang on 2018/1/16.
 */
public class Easy_744_FindSmallestLetterGreaterThanTarget {

    public char nextGreatestLetter(char[] letters, char target) {
        int lo = 0;
        int hi = letters.length - 1;
        int mi = 0;

        boolean isLager = false;
        while (lo <= hi) {
            mi = (lo + hi) / 2;
            if (target >= letters[mi]) {
                lo = mi + 1;
                isLager = true;
            } else if (target < letters[mi]) {
                hi = mi - 1;
                isLager = false;
            }
        }

        if (isLager) {
            if (mi == letters.length - 1) {
                return letters[0];
            } else return letters[mi + 1];
        } else {
            return letters[mi];
        }

    }
}
