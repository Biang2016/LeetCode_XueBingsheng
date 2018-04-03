package com.LeetCode;

/**
 * Created by biang on 2018/1/17.
 */
public class Easy_58_LengthofLastWord {
    public int lengthOfLastWord(String s) {
        String[] sub = s.split(" ");
        int count = 0;
        for (int i = sub.length - 1; i >= 0; i--) {
            count = 0;
            for (int j = sub[i].length() - 1; j >= 0; j--) {
                if (!((sub[i].charAt(j) >= 'a' && sub[i].charAt(j) <= 'z') || (sub[i].charAt(j) >= 'A' && sub[i].charAt(j) <= 'Z'))) {
                    count = 0;
                } else count++;
            }
            if (count > 0) break;
        }
        return count;
    }
}
