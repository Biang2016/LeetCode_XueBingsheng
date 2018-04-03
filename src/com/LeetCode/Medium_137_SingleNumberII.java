package com.LeetCode;

/**
 * Created by biang on 2018/1/17.
 */
public class Medium_137_SingleNumberII {

    //超级解法
    public int singleNumber(int[] A) {
        int ones = 0, twos = 0;
        for(int i = 0; i < A.length; i++){
            ones = (ones ^ A[i]) & ~twos;
            twos = (twos ^ A[i]) & ~ones;
        }
        return ones;
    }
}
