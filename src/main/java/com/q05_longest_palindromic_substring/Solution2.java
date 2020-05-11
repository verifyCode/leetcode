package com.q05_longest_palindromic_substring;

/**
 * @author xjn
 * @since 2020-05-11
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class Solution2 {

    /**
     * dp[i][j]: s[i,j]为回文字符串
     * <p>
     * 1. dp[i][j] = (s[i] == s[j]) && dp[i + 1][j - 1]
     * (j - 1) - (i + 1) + 1 < 2 ---> j - i < 3
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        int maxLength = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }

                if (dp[i][j]) {
                    if (maxLength < j - i + 1) {
                        maxLength = j - i + 1;
                        start = i;
                    }
                }
            }
        }
        System.out.println(start);
        System.out.println(maxLength);
        return s.substring(start, start + maxLength);
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.longestPalindrome("babad"));
    }
}
