package com.背包问题;

/**
 * @author xjn
 * @since 2020-02-07
 * 0-1背包问题
 * F[i][j]:表示前i个物品,总体积是j的情况下,总价值是多少
 * result = max {F[n][0~V]}
 * 1. 不选第i个物品: F[i][j] = F[i-1][j]
 * 2. 选第i个物品: F[i][j] = F[i-1][j-v[i]]
 */
public class Knapsack01 {

    private int[][] memo;

    public int knapsack01(int[] w, int[] v, int C) {
        int m = w.length;
        memo = new int[m][C + 1];
        return bestValue(w, v, m, C);
    }

    //用[0...index]的物品,填充容积为cb背包的最大值
    private int bestValue(int[] w, int[] v, int index, int c) {
        if (index < 0 || c < 0) {
            return 0;
        }
        if (memo[index][c] > 0) {
            return memo[index][c];
        }
        int res = bestValue(w, v, index - 1, c);
        if (c >= w[index]) {
            int a = v[index] + bestValue(w, v, index - 1, c - w[index]);
            res = Math.max(res, a);
        }
        memo[index][c] = res;
        return res;
    }
}
