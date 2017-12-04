package com.company;


/**
 * Created by biang on 2017/5/6.
 */
public class Easy_476_FindComplement {
    public static void main(String args[]) {
        System.out.print(My_findComplement(5));
    }

    public static int My_findComplement(int num) {
        int length = 32 - Integer.numberOfLeadingZeros(num);
        int complement = ~num;
        int a = complement >> length;
        int b = a << length;
        return complement - b;
    }

    public static int findComplement1(int num) {
        return ~num & ((Integer.highestOneBit(num) << 1) - 1);//highestOneBit方法返回的值为最高位数字为1，其余为0的二进制码
    }
}
