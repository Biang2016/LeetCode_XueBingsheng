package com.LeetCode;

/**
 * Created by biang on 2017/12/8.
 */
public class Hard_313_SuperUglyNumber {

    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n <= 0) return -1;
        if (primes == null) return -1;

        int[] p = new int[primes.length];
        int[] nums = new int[n];
        nums[0] = 1;
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                if (min > nums[p[j]] * primes[j]) {
                    min = nums[p[j]] * primes[j];
                }
            }
            nums[i] = min;
            for (int j = 0; j < primes.length; j++) {
                if (min == nums[p[j]] * primes[j]) p[j]++;
            }
        }
        return nums[n - 1];
    }

}
