package com.LeetCode;

/**
 * Created by biang on 2017/12/8.
 */
public class Easy_88_MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return;

        int nums1_p = m - 1;
        int nums2_p = n - 1;
        for (int i = m + n - 1; i >= 0; i--) {
            if (nums1_p < 0) {
                for (int j = i; j >= 0; j--) {
                    nums1[j] = nums2[nums2_p];
                    nums2_p--;
                }
                break;
            }
            if (nums2_p < 0) {
                break;
            }
            if (nums1[nums1_p] >= nums2[nums2_p]) {
                nums1[i] = nums1[nums1_p];
                nums1_p--;
            } else {
                nums1[i] = nums2[nums2_p];
                nums2_p--;
            }
        }
    }
}
