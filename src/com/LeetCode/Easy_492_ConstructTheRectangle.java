package com.LeetCode;

/**
 * Created by biang on 2017/5/7.
 */
public class Easy_492_ConstructTheRectangle {

    public static void main(String args[]) {
        for (int num : constructRectangle(55))
            System.out.println(num);
    }

    public static int[] constructRectangle(int area) {
        Double sqrt = Math.sqrt(area);
        int[] output = new int[2];
        for (int i = sqrt.intValue(); i > 0; i--) {
            if (area % i == 0) {
                output[0] = area / i;
                output[1] = i;
                break;
            }
        }
        return output;
    }

    //Cleaner
    public static int[] constructRectangle1(int area) {
        int w = (int) Math.sqrt(area);
        while (area % w != 0) w--;
        return new int[]{area / w, w};
    }
}
