package com.LeetCode;

/**
 * Created by biang on 2017/5/11.
 */
public class Easy_268_MissingNumber {
    public static void main(String args[]) {
        int[] a = new int[]{3, 2, 0, 4, 1};

        System.out.println(missingNumber(a));
    }

    public static int missingNumber(int[] nums) {
        int[] boxes = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            boxes[nums[i]] = 1;
        }
        for (int i = 0; i < boxes.length; i++) {
            if (boxes[i] == 0) return i;
        }
        return 0;
    }

    //XOR method:a^b^b =a
    public static int missingNumber2(int[] nums) {

        int xor = 0, i = 0;
        for (i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }

        return xor ^ i;
    }
}
