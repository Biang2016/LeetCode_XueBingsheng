package com.company;

/**
 * Created by biang on 2017/5/7.
 */
public class Easy_485_FindMaxConsecutiveOnes {
    public static void main(String args[]) {
        int[] a = new int[]{1, 1, 0, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnes(a));
        System.out.println(findMaxConsecutiveOnes1(a));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int nowMax = 0;
        int now = 0;
        for (int num : nums)
            if (num == 0) now = 0;
            else if (++now > nowMax) nowMax = now;
        return nowMax;
    }

    public static int findMaxConsecutiveOnes1(int[] nums) {
        int maxHere = 0, max = 0;
        for (int n : nums)
            max = Math.max(max, maxHere = n == 0 ? 0 : maxHere + 1);
        return max;
    }
}
