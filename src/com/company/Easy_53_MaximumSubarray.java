package com.company;

import javax.swing.text.rtf.RTFEditorKit;

/**
 * Created by biang on 2017/11/23.
 */
public class Easy_53_MaximumSubarray {


    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int thisSum = 0;
        for (int i = 0; i < nums.length; i++) {
            thisSum += nums[i];
            if (thisSum > maxSum) maxSum = thisSum;
            if (thisSum < 0) thisSum = 0;
        }
        return maxSum;
    }
}
