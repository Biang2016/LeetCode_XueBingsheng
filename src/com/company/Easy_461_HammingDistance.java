package com.company;

/**
 * Created by biang on 2017/5/6.
 */
public class Easy_461_HammingDistance {
    public static void main(String args[]) {
        System.out.print(hammingDistance2(1, 4));
    }

    public static int My_hammingDistance(int x, int y) {
        String sx = Integer.toBinaryString(x);
        String sy = Integer.toBinaryString(y);
        if (sx.length() < sy.length()) {
            String temp = sx;
            sx = sy;
            sy = temp;
        }
        int count = 0;
        int l1 = sx.length();
        int l2 = sy.length();
        for (int i = 1; i < l2 + 1; i++) {
            if (sx.charAt(l1 - i) != sy.charAt(l2 - i))
                count++;
        }
        for (int j = l1 - l2 - 1; j >= 0; j--) {
            if (sx.charAt(j) == '1') count++;
        }
        return count;
    }

    public static int hammingDistance1(int x, int y) {
        return Integer.bitCount(x ^ y);
    }


    public static int hammingDistance2(int x, int y) {
        int xor = x ^ y, count = 0;//异或运算符，如果x和y位不一样则转为1，一样转为0
        for (int i = 0; i < 32; i++) count += (xor >> i) & 1;//位运算符，遍历xor的最后位，如果和1相同就返回1，与1不同就返回0
        return count;
    }
}
