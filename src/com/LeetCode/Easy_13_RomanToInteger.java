package com.LeetCode;

/**
 * Created by biang on 2017/5/8.
 */
public class Easy_13_RomanToInteger {
    public static void main(String args[]) {
        System.out.println(My_romanToInt("I"));
        System.out.println(My_romanToInt("II"));
        System.out.println(My_romanToInt("IV"));
        System.out.println(My_romanToInt("XLVIII"));
        System.out.println(My_romanToInt("MCMLXXXIV"));
    }

    //90ms,新建数组等操作都是多余
    public static int My_romanToInt(String s) {
        int lastValue = 0;
        int[] values = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int value = getValue(s.charAt(i));
            if (lastValue != 0 && value > lastValue)
                values[i - 1] = -values[i - 1];
            values[i] = value;
            lastValue = values[i];
        }
        int res = 0;
        for (int i = 0; i < values.length; i++) {
            res += values[i];
        }
        return res;
    }


    private static int getValue(char romanChar) {
        switch (romanChar) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }

    //74ms
    public int romanToInt(String s) {
        int graph[] = new int[400];
        graph['I'] = 1;
        graph['V'] = 5;
        graph['X'] = 10;
        graph['L'] = 50;
        graph['C'] = 100;
        graph['D'] = 500;
        graph['M'] = 1000;
        char[] num = s.toCharArray();
        // 遍历这个数，用sum来总计和
        int sum = graph[num[0]];
        for (int i = 0; i < num.length - 1; i++) {
            // 如果，i比i+1大的话，直接相加
            if (graph[num[i]] >= graph[num[i + 1]]) {
                sum += graph[num[i + 1]];
            }
            // 如果i比i+1小的话，则将总和sum减去i这个地方数的两倍，同时加上i+1
            // 就相当于后边的数比左边的数大，则用右边的数减左边的数
            else {
                sum = sum + graph[num[i + 1]] - 2 * graph[num[i]];
            }
        }
        return sum;
    }

}