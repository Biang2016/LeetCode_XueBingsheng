package com.LeetCode;

/**
 * Created by biang on 2018/1/16.
 */
public class Easy_746_MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 0) return 0;
        if (cost.length == 1) return cost[0];
        if (cost.length == 2) return Math.min(cost[0], cost[1]);

        int prepre = 0;
        int pre = Math.min(cost[0], cost[1]);
        for (int i = 2; i < cost.length; i++) {
            int curCost = Math.min(prepre + cost[i - 1], pre + cost[i]);
            prepre = pre;
            pre = curCost;
        }
        return pre;
    }
}
