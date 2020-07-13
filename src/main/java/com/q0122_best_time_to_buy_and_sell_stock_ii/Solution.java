package com.q0122_best_time_to_buy_and_sell_stock_ii;

/**
 * @author xjn
 * @since 2020-02-09
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * 122. 买卖股票的最佳时机 II
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        if (prices.length == 1) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            int temp = prices[i] - prices[i - 1];
            if (temp > 0) {
                res += temp;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{7, 1, 5, 3, 4, 6}));//7
    }
}
