package com.q91_decode_ways;

/**
 * @author xjn
 * @since 2020-02-09
 * https://leetcode-cn.com/problems/decode-ways/
 * 91. 解码方法
 */
public class Solution2 {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        //dp[i]表示字符串0~i 可以解码的方式总数
        int[] dp = new int[n + 1];
        dp[n] = 1;
        if (s.charAt(n - 1) == '0') {
            dp[n - 1] = 0;
        } else {
            dp[n - 1] = 1;
        }

        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
            } else {
                int ten = Integer.parseInt(s.charAt(i) + "") * 10;
                int ge = Integer.parseInt(s.charAt(i + 1) + "");
                if (ten + ge <= 26) {
                    dp[i] = dp[i + 1] + dp[i + 2];
                } else {
                    dp[i] = dp[i + 1];
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        Solution2 test = new Solution2();
        System.out.println(test.numDecodings("12"));//2
        System.out.println(test.numDecodings("226"));//3
        System.out.println(test.numDecodings("12345"));//3
        System.out.println(test.numDecodings("00"));//0
        System.out.println(test.numDecodings("01"));//0
    }
}
