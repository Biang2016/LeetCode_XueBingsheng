package com.LeetCode;

/**
 * Created by biang on 2017/12/4.
 */
public class Easy_717_1bitand2bitCharacters {

    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        int i = 0;
        while (i < n - 1) {
            if (bits[i] == 1) i += 2;
            else i += 1;
        }
        return i == n - 1;
    }
}
