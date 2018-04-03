package com.LeetCode;

/**
 * Created by biang on 2017/5/17.
 */
public class Easy_367_ValidPerfectSquare {
    public static void main(String args[]) {
        System.out.println(My_isPerfectSquare(100));
    }

    public static boolean My_isPerfectSquare(int num) {
        int a = Integer.highestOneBit(num);
        int aa = (Integer.numberOfTrailingZeros(a) - 1) / 2;
        int b2 = a >> aa;
        int b1 = b2 >> 1;
        for (int i = a >> (aa+1); i <= a >> aa; i++) {
            if (i * i == num) return true;
        }
        return false;
    }

    //牛顿迭代法
    public boolean isPerfectSquare1(int num) {
        long x = num;
        while (x * x > num) {
            x = (x + num / x) >> 1;
        }
        return x * x == num;
    }

    //O(sqrt(N))
    public boolean isPerfectSquare2(int num) {
        int low = 1, high = num;
        while (low <= high) {
            long mid = (low + high) >>> 1;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                low = (int) mid + 1;
            } else {
                high = (int) mid - 1;
            }
        }
        return false;
    }

    //O(log(N))
    public boolean isPerfectSquare3(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }
}
