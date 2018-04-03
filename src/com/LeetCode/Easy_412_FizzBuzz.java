package com.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by biang on 2017/5/6.
 */
public class Easy_412_FizzBuzz {

    public static void main(String args[]) {
        System.out.println(My_fizzBuzz(1));
    }

    public static List<String> My_fizzBuzz(int n) {
        List<String> output = new ArrayList<>();
        for (int i = 1, flag3 = 0, flag5 = 0; i <= n; i++) {
            flag3++;
            flag5++;
            String str = "";
            if (flag3 == 3 && flag5 == 5) {
                flag3 = 0;
                flag5 = 0;
                str += "FizzBuzz";
            } else if (flag3 == 3) {
                flag3 = 0;
                str += "Fizz";
            } else if (flag5 == 5) {
                flag5 = 0;
                str += "Buzz";
            } else str += String.valueOf(i);
            output.add(str);
        }
        return output;
    }

    public static List<String> My_fizzBuzz1(int n) {
        List<String> output = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String str = "";
            if (i % 3 == 0 && i % 5 == 0) {
                str += "FizzBuzz";
            } else if (i % 3 == 0) {
                str += "Fizz";
            } else if (i % 5 == 0) {
                str += "Buzz";
            } else str += String.valueOf(i);
            output.add(str);
        }
        return output;
    }


}
