package com.LeetCode;

/**
 * Created by biang on 2017/5/7.
 */
public class Easy_344_ReverseString {
    public static void main(String args[]) {
        System.out.println(reverseString1("hello"));
    }

    //通不过时间测试
    public static String reverseString(String s) {
        String output = "";
        for (int i = 1; i <= s.length(); i++) {
            output += s.charAt(s.length() - i);//charAt将消耗n的时间
        }
        return output;
    }

    public static String reverseString1(String s) {
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length / 2; i++) {
            char temp = charArray[i];
            charArray[i] = charArray[charArray.length - i - 1];
            charArray[charArray.length - i - 1] = temp;
        }
        return String.copyValueOf(charArray);
    }
}
