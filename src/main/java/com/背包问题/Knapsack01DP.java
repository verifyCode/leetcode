package com.背包问题;

/**
 * @author xjn
 * @since 2020-02-07
 * DP
 */

public class Knapsack01DP {

    public int knapsack01(int[] w, int[] v, int C) {
        int n = w.length;
        int[][] dp = new int[n][C + 1];
        for (int j = 0; j <= C; j++) {
            dp[0][j] = (j >= w[0] ? v[0] : 0);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= C; j++) {
                //dp[i][j]   [0,i]的位置切容积为j的背包的最大值
                dp[i][j] = dp[i - 1][j];
                //容量要大于w[j] 即考虑的第i个物品,确实能放进背包中
                if (j >= w[i]) {
                    dp[i][j] = Math.max(dp[i][j], v[i] + dp[i - 1][j - w[i]]);
                }
            }
        }
        return dp[n - 1][C];
    }
}
