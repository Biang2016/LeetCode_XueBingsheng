package com.LeetCode;

/**
 * Created by biang on 2017/12/8.
 */
public class Medium_264_UglyNumberII {
public static void main(String args[]){
    nthUglyNumber(6);
}
    public static int nthUglyNumber(int n) {
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        int[] un = new int[1690];
        un[0] = 1;
        for (int i = 1; i < n; i++) {
            un[i]=Math.min(un[p2]*2,Math.min(un[p3]*3,un[p5]*5));
            if(un[i]==un[p2]*2)p2++;
            if(un[i]==un[p3]*3)p3++;
            if(un[i]==un[p5]*5)p5++;
        }
        return un[n - 1];
    }
}
