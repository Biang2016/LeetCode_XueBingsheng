package com.LeetCode;

import java.util.Stack;

/**
 * Created by biang on 2018/1/16.
 */
public class Medium_739_DailyTemperatures {
    public static void main(String args[]) {
        System.out.println(dailyTemperatures(new int[]{89, 62, 70, 58, 47, 47, 46, 76, 100, 70}));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<dayT> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int counter = 0;
            while (!stack.isEmpty() && stack.peek().temperature < temperatures[i]) {
                counter++;
                counter += stack.peek().count;
                res[stack.pop().index] = counter;
            }
            if (!stack.isEmpty()) stack.peek().count += counter;
            stack.push(new dayT(temperatures[i], i));
        }

        while (!stack.isEmpty()) {
            res[stack.pop().index] = 0;
        }

        return res;
    }


    static class dayT {
        int temperature;
        int index;
        int count = 0;

        public dayT(int temperature, int index) {
            this.temperature = temperature;
            this.index = index;
        }
    }

    public int[] dailyTemperatures2(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ret = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {    //把下标压入栈中即可唯一确定此值，根本无需建立类
                int idx = stack.pop();
                ret[idx] = i - idx;    //直接用下标减一下就可以得到天数了，何必记录count值！！！
            }
            stack.push(i);
        }
        return ret;
    }
}
