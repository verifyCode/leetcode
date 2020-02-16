package com.q309_best_time_to_buy_and_sell_stock_with_cooldown;

/**
 * @author xjn
 * @since 2020-02-09
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * 309. 最佳买卖股票时机含冷冻期
 * rest[i]:在第i天,最后一个操作是的时候所能获得的最大收益
 * sold[i]:在第i天,最后一个操作是卖的时候所能获得的最大收益
 * hold[i]:在第i天,最后一个操作是持有的时候所能获得的最大收益
 */
public class Solution {
    //dp[i][0] = max{dp[i-1][0],dp[i-1][1] + p[i]};
    //dp[i][1] = max{dp[i-1][1],dp[i-2][0] - price[i]}
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        int dp_pre = 0;
        for (int i = 0; i < prices.length; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, dp_pre - prices[i]);
            dp_pre = temp;
        }
        return dp_i_0;
    }

    public static void main(String[] args) {

    }
}
