package com.company;

import java.lang.reflect.Array;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by biang on 2017/5/19.
 */
public class Medium_372_SuperPow {
    public static void main(String args[]) {
        int[] a = new int[]{9, 6, 7, 6, 8, 3, 8, 9, 5, 6, 8, 2, 8, 7, 1, 8, 1, 9, 7, 0, 1, 5, 6, 8, 4, 0, 1, 8, 4, 2, 5, 9, 8, 4, 5, 9, 8, 5, 8, 5, 2, 8, 9, 0, 6, 2, 0, 9, 1, 8, 9, 4, 5, 7, 5, 1, 8, 6, 1, 4, 8, 6, 3, 9, 1, 1, 0, 1, 6, 8, 8, 0, 8, 7, 1, 4, 9, 3, 4, 2, 3, 5, 7, 8, 3, 2, 1, 3, 0, 3, 7, 0, 1, 3, 9, 4, 6, 1, 5, 4, 1, 5, 5, 0, 4, 8, 4, 5, 1, 0, 8, 5, 6, 7, 5, 1, 1, 9, 4, 1, 2, 3, 1, 3, 8, 3, 8, 6, 4, 5, 1, 8, 3, 6, 8, 7, 6, 2, 3, 7, 5, 3, 4, 1, 0, 0, 2, 3, 9, 8, 4, 3, 1, 7, 8, 2, 2, 8, 8, 9, 6, 9, 7, 9, 7, 5, 8, 3, 9, 3, 3, 4, 6, 9, 7, 8, 1, 1, 1, 2, 9, 7, 5, 3, 5, 6, 5, 9, 4, 3, 8, 0, 3, 7, 1, 2, 4, 0, 8, 6, 3, 3, 2, 2, 2, 0, 0, 4, 1, 4, 6, 3, 1, 4, 6, 8, 0, 1, 0, 4, 4, 0, 7, 9, 8, 0, 4, 2, 0, 2, 0, 6, 5, 3, 8, 7, 3, 0, 3, 6, 6, 2, 9, 8, 6, 7, 8, 6, 8, 8, 2, 5, 9, 1, 6, 7, 2, 0, 1, 4, 2, 4, 2, 7, 7, 2, 7, 2, 5, 2, 0, 1, 4, 0, 1, 2, 9, 0, 0, 8, 8, 3, 5, 9, 6, 1, 8, 0, 2, 2, 7, 4, 6, 9, 4, 3, 4, 3, 5, 9, 7, 5, 2, 2, 7, 4, 4, 7, 4, 5, 7, 4, 0, 2, 4, 8, 5, 2, 1, 7, 4, 8, 4, 0, 9, 0, 5, 5, 5, 2, 4, 2, 0, 7, 6, 9, 1, 1, 8, 7, 8, 5, 1, 0, 9, 5, 0, 7, 0, 1, 4, 6, 1, 0, 7, 3, 0, 4, 8, 5, 7, 3, 8, 9, 2, 4, 8, 5, 7, 7, 2, 7, 4, 5, 9, 6, 3, 2, 3, 3, 5, 7, 9, 7, 8, 8, 2, 0, 3, 0, 6, 2, 5, 6, 1, 7, 2, 1, 4, 0, 8, 6, 9, 5, 4, 1, 1, 7, 3, 4, 0, 8, 3, 1, 7, 3, 0, 9, 6, 5, 0, 4, 9, 5, 0, 0, 5, 2, 1, 9, 4, 2, 8, 4, 7, 2, 5, 0, 9, 0, 6, 1, 8, 1, 4, 6, 5, 4, 5, 3, 1, 7, 7, 0, 5, 7, 2, 0, 1, 6, 1, 6, 8, 1, 2, 7, 3, 9, 7, 4, 9, 3, 7, 9, 4, 2, 7, 1, 8, 5, 4, 2, 2, 1, 2, 7, 0, 7, 9, 2, 3, 3, 0, 3, 4, 2, 0, 8, 3, 7, 4, 2, 0, 2, 3, 6, 6, 1, 8, 4, 6, 4, 8, 8, 6, 1, 8, 8, 0, 9, 2, 3, 2, 2, 6, 7, 6, 6, 5, 9, 5, 1, 1, 5, 5, 7, 3, 1, 8, 1, 8, 4, 6, 6, 4, 4, 9, 2, 4, 9, 2, 7, 4, 4, 9, 0, 1, 6, 8, 8, 5, 3, 2, 9, 0, 7, 6, 4, 1, 4, 5, 1, 0, 3, 7, 4, 9, 9, 7, 4, 0, 1, 1, 5, 5, 0, 5, 9, 8, 6, 9, 4, 9, 1, 5, 2, 1, 3, 6, 2, 9, 3, 3, 9, 7, 2, 3, 6, 1, 2, 2, 2, 3, 3, 9, 1, 6, 6, 2, 4, 2, 1, 0, 4, 5, 7, 6, 6, 0, 2, 0, 9, 5, 3, 8, 4, 7, 4, 3, 1, 6, 5, 5, 2, 9, 4, 5, 7, 0, 9, 1, 5, 2, 4, 9, 7, 1, 5, 5, 2, 9, 5, 3, 4, 0, 4, 1, 8, 8, 4, 1, 6, 1, 6, 0, 2, 0, 7, 9, 2, 6, 1, 7, 9, 7, 6, 8, 8, 3, 4, 2, 2, 1, 6, 9, 2, 2, 0, 2, 0, 6, 3, 8, 7, 1, 1, 0, 1, 8, 9, 5, 5, 2, 3, 6, 9, 1, 4, 0, 5, 0, 2, 9, 2, 0, 0, 6, 2, 2, 0, 4, 8, 3, 5, 8, 4, 6, 0, 7, 6, 1, 4, 1, 6, 7, 9, 5, 1, 6, 7, 8, 6, 0, 9, 8, 2, 0, 6, 5, 2, 6, 1, 3, 1, 6, 1, 7, 4, 1, 4, 1, 4, 1, 4, 0, 0, 4, 8, 1, 0, 5, 1, 6, 7, 1, 7, 0, 1, 3, 7, 3, 2, 0, 6, 3, 9, 9, 1, 3, 2, 7, 4, 7, 8, 9, 7, 9, 3, 7, 2, 5, 3, 4, 3, 2, 5, 0, 4, 6, 6, 3, 1, 8, 4, 0, 3, 3, 9, 4, 6, 2, 2, 3, 1, 2, 2, 8, 1, 7, 6, 6, 2, 1, 0, 5, 3, 5, 8, 8, 3, 4, 1, 6, 4, 7, 6, 7, 0, 6, 4, 9, 0, 8, 2, 1, 0, 6, 9, 4, 3, 7, 0, 5, 0, 2, 0, 4, 9, 8, 4, 2, 4, 7, 0, 0, 5, 7, 0, 7, 3, 4, 8, 5, 2, 0, 6, 2, 6, 7, 8, 9, 5, 8, 6, 7, 0, 9, 1, 9, 7, 7, 3, 4, 5, 4, 4, 2, 3, 6, 9, 8, 0, 8, 3, 2, 0, 9, 7, 9, 6, 5, 0, 3, 6, 7, 1, 8, 6, 4, 0, 5, 4, 5, 1, 9, 1, 8, 3, 4, 4, 4, 2, 5, 2, 5, 9, 5, 6, 8, 6, 3, 6, 6, 8, 4, 5, 1, 2, 1, 8, 4, 9, 2, 0, 2, 3, 3, 0, 6, 8, 7, 0, 2, 4, 5, 8, 3, 0, 6, 4, 8, 1, 2, 4, 0, 6, 0, 3, 0, 3, 1};
//        int[] a = new int[]{2, 0, 0};
        long time1 = System.nanoTime();
        System.out.println(superPow(2147483647, a));
        long time2 = System.nanoTime();
        System.out.println((time2 - time1) / 1000000 + "ms");
    }

    //984ms
    public static int My_superPow(int a, int[] b) {
        if (a % DIV == 1) return 1;
        if (a % DIV == 0) return 0;
        if (a > DIV) a = a % DIV;

        Stack<Integer> modStack = new Stack<>();
        Stack<Integer> exponentStack = new Stack<>();

        int test = a;
        while (zeroStop != -1) {
            int count = 1;
            int mutiplier = test;
            while (test < DIV) {
                test *= mutiplier;
                count++;
            }
            int bModCount = Mod(b, count);
            if (bModCount != 0) {
                modStack.push(mutiplier);
                exponentStack.push(bModCount);
            }
            test %= DIV;
        }
        int res = 1;
        while (!modStack.isEmpty() && !exponentStack.isEmpty()) {
            res = res * (int) Math.pow(modStack.pop(), exponentStack.pop()) % DIV;
        }
        zeroStop = 0;
        return res;
    }

    static int zeroStop = 0;

    public static int Mod(int[] b, int count) {
        int mod = 0;
        boolean allZero = true;
        for (int iterator = zeroStop; iterator < b.length; iterator++) {
            mod = mod * 10 + b[iterator];
            b[iterator] = mod / count;
            mod = mod % count;
            if (allZero && b[iterator] != 0) {
                allZero = false;
                zeroStop = iterator;
            }
        }
        if (allZero) zeroStop = -1;
        return mod;
    }


    static int DIV = 1337;

    public static int superPow(int a, int[] b) {
        if (a == 0 || a == DIV || b == null || b.length == 0) return 0;
        if (a == 1) return 1;
        if (a > DIV) return superPow(a % DIV, b);
        List<Integer> index = findLoop(a);
        int loopsize = index.size();
        int rem = modBy(b, loopsize);
        rem = rem == 0 ? loopsize : rem;
        return index.get(rem - 1);
    }

    static List<Integer> findLoop(int a) {
        List<Integer> index = new ArrayList<>();
        boolean[] set = new boolean[DIV];
        int rem = a % DIV;
        while (!set[rem]) {
            set[rem] = true;
            index.add(rem);
            rem = (rem * a) % DIV;
        }
        return index;
    }

    static int modBy(int[] b, int m) {
        int rem = 0;
        for (int i = 0; i < b.length; i++) {
            rem = (rem * 10 + b[i]) % m;
        }
        return rem;
    }


}
