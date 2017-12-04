package com.company;

/**
 * Created by biang on 2017/5/10.
 */
public class Medium_34_SearchForARange {
    public static void main(String args[]) {
        int[] aaa = new int[]{};
        int res[] = searchRange(aaa, 8);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if(nums.length==0)return res;
        int start = 0;
        int end = nums.length - 1;
        //找左边界
        while (start < end) {
            int middle = (end + start) / 2;
            if (nums[middle] < target) start = middle + 1;
            else end = middle;
        }
        if (nums[start] == target) res[0] = start;
        //找右边界
        end = nums.length - 1;
        while (start < end) {
            int middle = (end + start + 1) / 2;
            if (nums[middle] > target) end = middle - 1;
            else start = middle;
        }
        if (nums[end] == target) res[1] = end;

        return res;
    }

}