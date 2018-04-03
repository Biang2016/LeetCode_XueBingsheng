package com.LeetCode;

/**
 * Created by biang on 2018/1/17.
 */
public class Easy_136_SingleNumber {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
