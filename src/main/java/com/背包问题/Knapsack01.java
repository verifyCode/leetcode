package com.背包问题;

/**
 * @author xjn
 * @since 2020-02-07
 * 0-1背包问题
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
