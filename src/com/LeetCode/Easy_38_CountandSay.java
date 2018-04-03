package com.LeetCode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by biang on 2018/1/16.
 */
public class Easy_38_CountandSay {
    public static void main(String args[]) {
        System.out.println(countAndSay(4));
    }

    public static String countAndSay(int n) {
        String res = "1";
        for (int i = 2; i <= n; i++) {
            res = say(res);
        }
        return res;
    }

    public static String say(String s) {
        if (s.length() == 0) return "";

        StringBuilder sb = new StringBuilder();
        int count = 0;
        int nowIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(nowIndex) == s.charAt(i)) {
                count++;
            } else {
                sb.append(Integer.toString(count) + s.charAt(nowIndex));
                nowIndex = i;
                count = 1;
            }
        }
        sb.append(Integer.toString(count) + s.charAt(nowIndex));
        return sb.toString();
    }
}
