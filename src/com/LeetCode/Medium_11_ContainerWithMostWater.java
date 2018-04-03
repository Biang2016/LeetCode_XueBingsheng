package com.LeetCode;

/**
 * Created by biang on 2017/12/28.
 */
public class Medium_11_ContainerWithMostWater {

    public int maxArea(int[] height) {
        int pl = 0;
        int pr = height.length - 1;
        int maxArea = 0;
        while (pl < pr) {
            if (height[pl] < height[pr]) {
                maxArea = Math.max(maxArea, (pr - pl) * height[pl]);
                pl++;
            } else {
                maxArea = Math.max(maxArea, (pr - pl) * height[pr]);
                pr--;
            }
        }
        return maxArea;
    }

}
