package com.q322_coin_change;

/**
 * @author xjn
 * @since 2020-02-08
 * https://leetcode-cn.com/problems/coin-change/
 * 322. 零钱兑换
 */
public class Solution {

    private int[] memo;
    private int maxAmount;

    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        memo = new int[amount + 1];
        maxAmount = amount + 1;
        int a = coinChangeR(coins, amount);
        return a == maxAmount ? -1 : a;
    }

    //amount从coins池子里换硬币的最小数量
    private int coinChangeR(int[] coins, int amount) {
//        if (memo[amount] != 0) {
//            return memo[amount];
//        }
        if (amount == 0) {
            return 0;
        }
        int res = maxAmount;
        //回溯
        for (int i = 0; i < coins.length; i++) {
            if (amount - coins[i] >= 0) {
                int a = coinChangeR(coins, amount - coins[i]) + 1;
                res = Math.min(res, a);
            }
        }
//        memo[amount] = res;
        return res;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        //5->2->1
        //
        System.out.println(solution.coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(solution.coinChange(new int[]{2}, 3));
        System.out.println(solution.coinChange(new int[]{1}, 0));
        System.out.println(solution.coinChange(new int[]{0}, 0));
    }


}
