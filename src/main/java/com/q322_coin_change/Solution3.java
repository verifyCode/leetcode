package com.q322_coin_change;

import java.util.Arrays;

/**
 * @author xjn
 * @since 2020-02-09
 * https://leetcode-cn.com/problems/coin-change/
 * 322. 零钱兑换
 * 时间复杂度O(n^2)
 * 空间复杂度O(n)
 */
public class Solution3 {
    //dp[i] 在区间coin[0~n]中兑换i元钱最少需要多少硬币
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int coin : coins) {
            dp[coin] = 1;
        }

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        System.out.println(solution.coinChange(new int[]{1, 2, 5}, 11));//3
        System.out.println(solution.coinChange(new int[]{2}, 3));//-1
        System.out.println(solution.coinChange(new int[]{474, 83, 404, 3}, 264));//8
    }
}
