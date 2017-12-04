package com.company;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by biang on 2017/11/23.
 */
public class Easy_169_MajorityElement {
    public static void main(String args[]) {
        System.out.println(majorityElement_1(new int[]{6, 5, 5}));
    }

    //Bad performance
    public static int majorityElement_1(int[] nums) {
        int majority = 0;
        int maxCount = 0;
        Hashtable<Integer, Integer> h = new Hashtable<>();
        for (int i = 0; i < nums.length; i++) {
            int currentValue;
            if (h.containsKey(nums[i])) {
                h.put(nums[i], h.get(nums[i]) + 1);
                currentValue = h.get(nums[i]);
            } else {
                h.put(nums[i], 1);
                currentValue = 1;
            }
            if (maxCount < currentValue) {
                majority = nums[i];
                maxCount = currentValue;
            }
        }
        return majority;
    }

    //Moore Vote Algorithm
    public static int majorityElement_2(int[] nums) {
        int candidate = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (candidate == nums[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    candidate = nums[i];
                    count++;
                }
            }
        }
        return candidate;
    }
}
