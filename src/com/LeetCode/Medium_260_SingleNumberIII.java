package com.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by biang on 2018/1/17.
 */
public class Medium_260_SingleNumberIII {
    public static void main(String args[]) {
        System.out.println(singleNumber(new int[]{1193730082, 587035181, -814709193, 1676831308, -511259610, 284593787, -2058511940, 1970250135, -814709193, -1435587299, 1308886332, -1435587299, 1676831308, 1403943960, -421534159, -528369977, -2058511940, 1636287980, -1874234027, 197290672, 1976318504, -511259610, 1308886332, 336663447, 1636287980, 197290672, 1970250135, 1976318504, 959128864, 284593787, -528369977, -1874234027, 587035181, -421534159, -786223891, 933046536, 959112204, 336663447, 933046536, 959112204, 1193730082, -786223891}));
    }


    /*
    If you were stuck by this problem, it’s easy to find a solution in the discussion. However, usually, the solution lacks some explanations.
    I’m sharing my understanding here:
    The two numbers that appear only once must differ at some bit, this is how we can distinguish between them. Otherwise, they will be one of the duplicate numbers.
    One important point is that by XORing all the numbers, we actually get the XOR of the two target numbers (because XORing two duplicate numbers always results in 0). Consider the XOR result of the two target numbers; if some bit of the XOR result is 1, it means that the two target numbers differ at that location.
    Let’s say the at the ith bit, the two desired numbers differ from each other. which means one number has bit i equaling: 0, the other number has bit i equaling 1.
    Thus, all the numbers can be partitioned into two groups according to their bits at location i.
    the first group consists of all numbers whose bits at i is 0.
    the second group consists of all numbers whose bits at i is 1.
    Notice that, if a duplicate number has bit i as 0, then, two copies of it will belong to the first group. Similarly, if a duplicate number has bit i as 1, then, two copies of it will belong to the second group.
    by XoRing all numbers in the first group, we can get the first number.
    by XoRing all numbers in the second group, we can get the second number.
    */

    public static int[] singleNumber(int[] nums) {
        int indicator = 0;
        for (int i = 0; i < nums.length; i++) {
            indicator ^= nums[i];
        }
        int diffIndex = 0;
        while ((indicator & 1) != 1) {
            diffIndex++;
            indicator >>= 1;
        }

        List<Integer> group1 = new ArrayList<>();
        List<Integer> group2 = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (((nums[i] >> diffIndex) & 1) == 1) group1.add(nums[i]);
            else group2.add(nums[i]);
        }

        int[] res = new int[2];
        for (int i = 0; i < group1.size(); i++) {
            res[0] ^= group1.get(i);
        }
        for (int i = 0; i < group2.size(); i++) {
            res[1] ^= group2.get(i);
        }

        return res;
    }
}
