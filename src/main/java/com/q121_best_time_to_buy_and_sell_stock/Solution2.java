package com.q121_best_time_to_buy_and_sell_stock;

/**
 * @author xjn
 * @since 2020-02-09
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * 121. 买卖股票的最佳时机
 */
public class Solution2 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            if (min > prices[i]) {
                min = prices[i];
            } else if (prices[i] - min > res) {
                res = prices[i] - min;
            }
        }
        return res;
    }

}
