package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.CountDownLatch;

/**
 * Created by biang on 2017/5/7.
 */
public class Easy_496_NextGreaterElement {
    public static void main(String args[]) {
        int[] nums1 = {3, 6, 1, 5, 9};
        int[] nums2 = {2, 8, 5, 4, 3, 6, 7, 1, 9};
        int[] nums3 = {2, 4};
        int[] nums4 = {1, 2, 3, 4};
        for (int num : nextGreaterElement1(nums1, nums2))
            System.out.println(num);
        for (int num : nextGreaterElement(nums3, nums4))
            System.out.println(num);
    }

    //Slow
    public static int[] nextGreaterElement(int[] findNums, int[] nums) {
        int[] output = new int[findNums.length];
        for (int i = 0; i < findNums.length; i++) {
            boolean flag = false;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == findNums[i]) {
                    flag = true;
                }
                if (flag && nums[j] > findNums[i]) {
                    output[i] = nums[j];
                    break;
                }
            }
            if (output[i] == 0) output[i]--;
        }
        return output;
    }

    //Fast
    public static int[] nextGreaterElement1(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int[] output = new int[findNums.length];
        for (int num : nums) {
            while (!stack.isEmpty() && num > stack.peek())
                map.put(stack.pop(), num);
            stack.push(num);
        }
        for (int i = 0; i < findNums.length; i++)
            output[i] = map.getOrDefault(findNums[i], -1);
        return output;
    }
}
