package com.q05_longest_palindromic_substring;

/**
 * @author xjn
 * @since 2019-12-23
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * <p>
 * 马拉车算法:https://www.jianshu.com/p/392172762e55
 *
 * 时间复杂度O(n^2)
 * 空间复杂度O(n^2)
 */
public class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return null;
        }
        if(s.length() < 2){
            return s;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        int size = 1;
        int start = 0;
        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }

                if (dp[i][j] && j - i + 1 > size) {
                    size = j - i + 1;
                    start = i;
                }
            }
        }
        if (size == 1) {
            return s.charAt(0) + "";
        }
        return s.substring(start, start + size);
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        System.out.println(test.longestPalindrome("babad"));
        System.out.println(test.longestPalindrome("cbbd"));
    }
}
