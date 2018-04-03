package com.LeetCode;

/**
 * Created by biang on 2017/11/29.
 */
public class Medium_698_PartitiontoKEqualSumSubsets {

//    //DP solution
//    public boolean canPartitionKSubsets(int[] nums, int k) {
//        if (k <= 0) return false;
//        int sum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            sum += nums[i];
//        }
//        if (sum % k != 0) return false;
//        int oneSum = sum / k;
//
//        Arrays.sort(nums);
//
//        int[][] dp = new int[oneSum + 1][k+1];
//
//        for (int i = 1; i < oneSum + 1; i++) {
//            for (int j = 1; j < k+1; j++) {
//
//            }
//        }
//    }
}
