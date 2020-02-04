package com.q279_perfect_squares;


/**
 * @author xjn
 * @since 2020-02-03
 * https://leetcode-cn.com/problems/perfect-squares/
 * 279. 完全平方数
 */
public class Solution2 {

    private int[] memo;

    public int numSquares(int n) {
        memo = new int[n + 1];
        return numSquaresRecursive(n);
    }

    private int numSquaresRecursive(int n) {
        if (memo[n] != 0) {
            return memo[n];
        }
        int val = (int) Math.sqrt(n);
        if (val * val == n) {
            memo[n] = 1;
            return 1;
        }

        int res = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            int a = numSquaresRecursive(n - i * i) + 1;
            res = Math.min(a, res);
        }
        memo[n] = res;
        return res;
    }


    public static void main(String[] args) {
        Solution2 test = new Solution2();
        System.out.println(test.numSquares(12));
        System.out.println(test.numSquares(13));
        System.out.println(test.numSquares(6));
    }

}
