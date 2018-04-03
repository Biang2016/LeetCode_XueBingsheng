package com.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by biang on 2017/5/7.
 */
public class Easy_448_FindDisappearedNumbers {

    public static void main(String args[]) {
        int[] a = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDisappearedNumbers(a));
        System.out.println(findDisappearedNumbers1(a));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int[] temp = new int[nums.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = i + 1;
        }
        for (int num : nums) {
            temp[num - 1] = 0;
        }
        List<Integer> output = new ArrayList<>();
        for (int t : temp) if (t != 0) output.add(t);
        return output;
    }

    //Less space
    public static List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();

        for(int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                ret.add(i+1);
            }
        }
        return ret;
    }
}
