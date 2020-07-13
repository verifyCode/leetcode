package com.q0343_integer_break;

/**
 * @author xjn
 * @since 2020-02-03
 * https://leetcode-cn.com/problems/integer-break/
 * 343. 整数拆分
 */
public class Solution2 {
    public int integerBreak(int n) {
        if (n == 1) {
            return 1;
        }
        //memo[i]表示将数字i分割(至少分割成两部分)后得到的最大乘积
        int[] memo = new int[n + 1];
        memo[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                //j + (i-j)  对 i-j在进行分割,则为memo[i - j];
                memo[i] = max(j * (i - j), j * memo[i - j], memo[i]);
            }
        }
        return memo[n];
    }

    private int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {
        Solution2 test = new Solution2();
        System.out.println(test.integerBreak(10));
    }
}
