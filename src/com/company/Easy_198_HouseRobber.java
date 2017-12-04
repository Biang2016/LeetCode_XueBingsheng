package com.company;

/**
 * Created by biang on 2017/11/28.
 */
public class Easy_198_HouseRobber {


    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        A = new int[n];
        A[0] = nums[0];
        A[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            A[i] = Math.max(nums[i] + A[i - 2], A[i - 1]);
        }
        return A[n - 1];
    }

    int[] A;
}
