package com.LeetCode;

/**
 * Created by biang on 2018/1/16.
 */
public class Easy_747_LargestNumberAtLeastTwiceofOthers {

    public int dominantIndex(int[] nums) {
        int max = 0;
        int secMax = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                secMax = max;
                max = nums[i];
                res = i;
            } else if (nums[i] > secMax) {
                secMax = nums[i];
            }
        }
        return max >= 2*secMax ? res : -1;
    }
}
