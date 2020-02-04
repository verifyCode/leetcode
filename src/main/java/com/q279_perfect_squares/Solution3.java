package com.q279_perfect_squares;

import java.util.Arrays;

/**
 * @author xjn
 * @since 2020-02-03
 * https://leetcode-cn.com/problems/perfect-squares/
 * 279. 完全平方数
 */
public class Solution3 {
    public int numSquares(int n) {
        if (n == 1) {
            return 1;
        }
        int[] memo = new int[n + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                System.out.println("i:" + i + " j:" + j);
                memo[i] = Math.min(memo[i], 1 + memo[i - j * j]);
            }
        }
        return memo[n];
    }

    public static void main(String[] args) {
        Solution3 test = new Solution3();
//        System.out.println(test.numSquares(12));
//        System.out.println(test.numSquares(13));
        System.out.println(test.numSquares(6));
    }
}
