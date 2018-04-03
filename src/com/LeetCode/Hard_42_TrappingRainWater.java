package com.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by biang on 2017/12/28.
 */
public class Hard_42_TrappingRainWater {
    public static void main(String args[]) {
        System.out.println(trap(new int[]{4,2,0,3,2,5}));
    }

    public static int trap(int[] height) {
        if (height == null || height.length <= 1) return 0;
        int sumWater = 0;

        int count;
        do {
            count = 0;
            for (int i = 1; i < height.length - 1; i++) {
                if (height[i] < height[i - 1]) {
                    if (height[i] == height[i + 1]) {
                        int j = i;
                        while (j < height.length - 2 && height[j] == height[j + 1]) j++;
                        if (height[j] < height[j + 1]) {
                            count++;
                            if (height[i - 1] > height[j + 1]) {
                                sumWater += (height[j + 1] - height[i]) * (j - i + 1);
                                for (int k = i; k <= j; k++)
                                    height[k] = height[j + 1];
                            } else {
                                sumWater += (height[i - 1] - height[i]) * (j - i + 1);
                                for (int k = i; k <= j; k++)
                                    height[k] = height[i - 1];
                            }
                        }
                        i = j;
                    } else if (height[i] < height[i + 1]) {
                        count++;
                        if (height[i - 1] > height[i + 1]) {
                            sumWater += height[i + 1] - height[i];
                            height[i] = height[i + 1];
                        } else {
                            sumWater += height[i - 1] - height[i];
                            height[i] = height[i - 1];
                        }
                    }
                }
            }
        } while (count != 0);

        return sumWater;
    }


    public int trap(int A[], int n) {
        int left=0; int right=n-1;
        int res=0;
        int maxleft=0, maxright=0;
        while(left<=right){
            if(A[left]<=A[right]){
                if(A[left]>=maxleft) maxleft=A[left];
                else res+=maxleft-A[left];
                left++;
            }
            else{
                if(A[right]>=maxright) maxright= A[right];
                else res+=maxright-A[right];
                right--;
            }
        }
        return res;
    }
}
