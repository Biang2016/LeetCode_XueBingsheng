package com.LeetCode;

/**
 * Created by biang on 2017/7/18.
 */
public class Medium_162_FindPeakElement {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        if (nums[0] > nums[1]) return 0;
        if (nums[nums.length - 1] > nums[nums.length - 2]) return nums.length - 1;
        int point = nums.length / 2;
        int divide = point;
        while (true) {
            divide = Math.max(divide / 2, 1);
            if (nums[point] < nums[point - 1]) {
                point = point - divide;
            } else if (nums[point] < nums[point + 1]) {
                point = point + divide;
            } else return point;
        }
    }
}
