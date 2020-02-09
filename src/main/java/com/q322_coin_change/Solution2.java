package com.q322_coin_change;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

/**
 * @author xjn
 * @since 2020-02-09
 * https://leetcode-cn.com/problems/coin-change/
 * 322. 零钱兑换
 *
 * BFS
 */
public class Solution2 {

    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        TreeSet<Integer> visited = new TreeSet<>();
        Pair<Integer, Integer> pair = new Pair<>(amount, 0);
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(pair);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair<Integer, Integer> remove = queue.remove();
                Integer amountFromQueue = remove.getKey();
                Integer s = remove.getValue();
                if (amountFromQueue != null) {
                    if (amountFromQueue == 0) {
                        return s;
                    }
                    for (int coin : coins) {
                        int a = amountFromQueue - coin;
                        if (a > 0 && !visited.contains(a)) {
                            Pair<Integer, Integer> p = new Pair<>(a, s + 1);
                            queue.add(p);
                            visited.add(a);
                        }
                        if (a == 0) {
                            return s + 1;
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
//        System.out.println(solution.coinChange(new int[]{1, 2, 5}, 11));//3
//        System.out.println(solution.coinChange(new int[]{2}, 3));//-1
        System.out.println(solution.coinChange(new int[]{474, 83, 404, 3}, 264));//8
    }
}
