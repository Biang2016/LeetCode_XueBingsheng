package com.LeetCode;

/**
 * Created by biang on 2017/11/28.
 */
public class Easy_303_RangeSumQuery_Immutable {
    public static void main(String args[]) {
        int[] nums = new int[]{-4, -5};
        Easy_303_RangeSumQuery_Immutable obj = new Easy_303_RangeSumQuery_Immutable(nums);
        System.out.println(obj.sumRange(0, 0));
        System.out.println(obj.sumRange(1, 1));
        System.out.println(obj.sumRange(0, 1));
        System.out.println(obj.sumRange(1, 1));
        System.out.println(obj.sumRange(0, 0));
    }

    public Easy_303_RangeSumQuery_Immutable(int[] nums) {
        if (nums.length == 0) {
            isEmpty = true;
            return;
        }
        A = new int[nums.length];
        A[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            A[i] = A[i - 1] + nums[i];
        }
    }

    int[] A;
    boolean isEmpty = false;

    public int sumRange(int i, int j) {
        if (isEmpty) return 0;
        if (i == 0) return A[j];
        return A[j] - A[i - 1];
    }
}
