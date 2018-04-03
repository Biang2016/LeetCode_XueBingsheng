package com.LeetCode;

import java.util.*;

/**
 * Created by biang on 2017/12/16.
 */
public class Medium_3_LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int maxLen = 0;
        int curLen = 0;
        boolean[] isExist = new boolean[256];
        Queue<Character> q = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            if (isExist[ch]) {
                char out;
                do {
                    out = q.poll();
                    isExist[out] = false;
                    curLen--;
                } while (out != ch);
            }
            isExist[ch] = true;
            q.add(ch);
            curLen++;
            maxLen = Math.max(maxLen, curLen);
        }
        return maxLen;
    }

    //without using data structure
    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) return 0;
        int maxLen = 0;
        int tail = 0;
        char[] chars = s.toCharArray();
        int[] index = new int[256];
        Arrays.fill(index, -1);
        for (int i = 0; i < chars.length; i++) {
            tail = Math.max(index[chars[i]] + 1, tail);
            maxLen = Math.max(i - tail + 1, maxLen);
            index[chars[i]] = i;
        }
        return maxLen;
    }

}
