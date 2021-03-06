package com.LeetCode;

/**
 * Created by biang on 2017/11/28.
 */
public class Easy_122_BestTimetoBuyandSellStock2 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i-1];
        }
        return profit;
    }


}
