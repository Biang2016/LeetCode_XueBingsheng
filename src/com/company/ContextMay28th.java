package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by biang on 2017/5/28.
 */
public class ContextMay28th {

    public int maxCount(int m, int n, int[][] ops) {
        int minOps1 = m;
        int minOps2 = n;
        for (int[] a : ops) {
            minOps1 = Math.min(minOps1, a[0]);
            minOps2 = Math.min(minOps2, a[1]);
        }
        return minOps1 * minOps2;
    }

    public static void main(String args[]) {
        String[] list1 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = new String[]{"KFC", "Shogun", "Burger King"};
        System.out.println(findRestaurant(list1, list2));
        int[] aaa = new int[]{5, 4, 0, 3, 1, 6, 2};

        System.out.println(arrayNesting(aaa));
    }


    public static String[] findRestaurant(String[] list1, String[] list2) {
        String[] res = new String[1000];
        int count = 0;
        int minSum = 2000;
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j])) {
                    int a = i + j;
                    if (minSum > a) {
                        count = 0;
                        minSum = a;
                        res[count++] = list1[i];
                    } else if (minSum == a) res[count++] = list1[i];
                }
            }
        }
        String[] resA = new String[count];
        for (int i = 0; i < count; i++) {
            resA[i] = res[i];
        }
        return resA;
    }


    public static int arrayNesting(int[] nums) {
        int res = 0;
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            int index = nums[i];
            while (index != i) {
                if (index == -1 || nums[index] == -1) break;
                int temp = nums[index];
                nums[index] = -1;
                index = temp;
                count++;
            }
            if (index == -1 || nums[index] == -1) continue;
            else {
                nums[index] = -1;
                res = Math.max(res, count);
                count = 1;
            }
        }
        return res;
    }
}
