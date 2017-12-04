package com.company;

/**
 * Created by biang on 2017/11/28.
 */
public class Easy_70_ClimbingStairs {


    public int climbStairs(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int pre = 1;
        int cur = 2;
        for (int i = 0; i < n - 2; i++) {
            int temp = cur;
            cur = pre + cur;
            pre = temp;
        }
        return cur;
    }
}
