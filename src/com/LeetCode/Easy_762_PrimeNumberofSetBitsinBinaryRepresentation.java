package com.LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by biang on 2018/1/16.
 */
public class Easy_762_PrimeNumberofSetBitsinBinaryRepresentation {


    public int countPrimeSetBits(int L, int R) {
        int res = 0;
        for (int i = L; i <= R; i++) {
            int count = 0;
            int num = i;
            while (num > 0) {
                if ((num & 1) == 1) count++;
                num = num >> 1;
            }
            if (isPrime(count)) res++;
        }
        return res;
    }

    public boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2)
            if (n % i == 0) return false;
        return true;
    }

    //干净利落的写法
    public int countPrimeSetBits2(int l, int r) {
        Set<Integer> primes = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29 ));   //这里值得学习
        int cnt = 0;
        for (int i = l; i <= r; i++) {
            int bits = 0;
            for (int n = i; n > 0; n >>= 1)   //这里值得学习
                bits += n & 1;   //这里值得学习
            cnt += primes.contains(bits) ? 1 : 0;  //这里值得学习
        }
        return cnt;
    }
}
