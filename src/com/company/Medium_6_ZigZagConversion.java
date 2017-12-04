package com.company;

/**
 * Created by biang on 2017/7/18.
 */
public class Medium_6_ZigZagConversion {
    public static void main(String args[]) {
        convert("A", 2);
    }

    //100ms
    public static String convert(String s, int numRows) {
        if (s == null || s.length() <= numRows || numRows == 1) {
            return s;
        }
        String[] out = new String[numRows];
        for (int i = 0; i < out.length; i++) out[i] = "";
        boolean flag = true;
        int index = 0;
        int point = 0;
        while (point < s.length()) {
            if (index == 0) flag = true;
            if (index == numRows - 1) flag = false;
            out[index] += s.charAt(point);
            point++;
            if (flag) index++;
            else index--;
        }
        String res = "";
        for (String str : out) {
            res += str;
        }
        return res;
    }

    //41ms
    public String convert1(String s, int nRows) {
        if (s == null || s.length() <= nRows || nRows == 1) {
            return s;
        }
        int n = s.length();
        char[] chars = new char[n];
        int step = 2 * (nRows - 1);
        int count = 0;
        for (int i = 0; i < nRows; i++){
            int interval = step - 2 * i;
            for (int j = i; j < n; j += step){
                chars[count++] = s.charAt(j);
                if (interval < step && interval > 0  && j + interval < n && count < n){
                    chars[count++] = s.charAt(j + interval);
                }
            }
        }
        return new String(chars);
    }

}
