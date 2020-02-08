package com.q322_coin_change;

/**
 * @author xjn
 * @since 2020-02-08
 * https://leetcode-cn.com/problems/coin-change/
 * 322. 零钱兑换
 */
public class Solution {

    public int coinChange(int[] coins, int amount) {
        return coinChange(coins, amount, coins.length - 1);
    }

    private int coinChange(int[] coins, int amount, int index) {
        if (index < 0) {
            return 0;
        }
        if (amount == 0) {
            return 1;
        }
        return 1;

    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.coinChange(new int[]{1, 2, 5}, 11));
    }


}
