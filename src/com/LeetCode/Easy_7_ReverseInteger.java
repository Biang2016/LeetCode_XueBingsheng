package com.LeetCode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by biang on 2017/12/28.
 */
public class Easy_7_ReverseInteger {
    public static void main(String args[]) {
        System.out.println(reverse2(-123));
    }

    public static int reverse(int x) {
        boolean sign = x >= 0;
        x = Math.abs(x);
        ArrayList<Integer> integers = new ArrayList<>();
        while (x > 0) {
            integers.add(x % 10);
            x /= 10;
        }
        long res = 0;
        while (!integers.isEmpty()) {
            res *= 10;
            res += integers.remove(0);
        }

        res = sign ? res : -res;
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;

        return (int) res;
    }

    public static int reverse2(int x) {
        int output = 0;

        while (true) {
            if (x == 0) {
                return x;
            }

            output = output * 10 + x % 10;

            if ((x /= 10) == 0) {
                return output;
            }

            if (output > 214748364 || output < -214748364) {
                return 0;
            }
        }
    }

}
