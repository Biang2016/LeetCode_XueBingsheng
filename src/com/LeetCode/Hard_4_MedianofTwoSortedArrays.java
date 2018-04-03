package com.LeetCode;

import sun.tools.jconsole.inspector.IconManager;

/**
 * Created by biang on 2017/12/8.
 */
public class Hard_4_MedianofTwoSortedArrays {

    //Solution --→  http://blog.csdn.net/hk2291976/article/details/51107778
    //    让数组恒为奇数
    //
    //    有没有办法让两个数组长度相加一定为奇数或偶数呢？
    //
    //    其实有的，虚拟加入‘#’(这个trick在manacher算法中也有应用)，让数组长度恒为奇数（2n+1恒为奇数）。
    //    Ps.注意是虚拟加，其实根本没这一步，因为通过下面的转换，我们可以保证虚拟加后每个元素跟原来的元素一一对应
    //    每个位置可以通过/2得到原来元素的位置。
    //
    //    之前	      len	    之后  	                len
    //    [1 4 7 9]	   4	    [# 1 # 4 # 7 # 9 #]	    9
    //    [2 3 5]	   3	    [# 2 # 3 # 5 #]	        7
    //
    //    奇妙的是不管哪种情况：
    //
    //    Li = (Ci-1)/2
    //    Ri = Ci/2
    //    剩下的事情就好办了，把2个数组看做一个虚拟的数组A，目前有2m+2n+2个元素，割在m+n+1处，所以我们只需找到m+n+1位置的元素和m+n+2位置的元素就行了。
    //    左边：A[m+n+1] = Max(L1+L2)
    //    右边：A[m+n+2] = Min(R1+R2)


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) return findMedianSortedArrays(nums2, nums1);

        int lo = 0, hi = m * 2;
        while (lo <= hi) {
            int mid1 = (lo + hi) / 2;
            int mid2 = m + n - mid1;

            double L1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[(mid1 - 1) / 2];
            double L2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[(mid2 - 1) / 2];
            double R1 = (mid1 == m * 2) ? Integer.MAX_VALUE : nums1[(mid1) / 2];
            double R2 = (mid2 == n * 2) ? Integer.MAX_VALUE : nums2[(mid2) / 2];

            if (L1 > R2) hi = mid1 - 1;
            else if (L2 > R1) lo = mid1 + 1;
            else return (Math.max(L1, L2) + Math.min(R1, R2)) / 2;
        }
        return -1;
    }


}


