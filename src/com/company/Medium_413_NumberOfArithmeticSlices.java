package com.company;

/**
 * Created by biang on 2017/5/7.
 */
public class Medium_413_NumberOfArithmeticSlices {
    public static void main(String args[]) {
        int[] a = new int[]{1, 2, 3, 4};
        System.out.println(numberOfArithmeticSlices(a));
    }

    public static int numberOfArithmeticSlices(int[] A) {
        int curr = 0, sum = 0;
        for (int i = 2; i < A.length; i++)
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                curr += 1;
                sum += curr;
            } else {
                curr = 0;
            }
        return sum;
    }
}
