package com.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by biang on 2017/5/7.
 */
public class Medium_442_FindDuplicates {

    public static void main(String args[]) {
        int[] a = new int[]{10, 2, 5, 10, 9, 1, 1, 4, 3, 7};
        System.out.println(findDuplicates(a));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0) {
                nums[val] = -nums[val];
            } else ret.add(val+1);
        }
        return ret;
    }
}
