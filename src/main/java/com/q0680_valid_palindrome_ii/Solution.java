package com.q0680_valid_palindrome_ii;

/**
 * @author xjn
 * @since 2020-02-08
 * https://leetcode-cn.com/problems/valid-palindrome-ii/
 * 680. 验证回文字符串 Ⅱ
 */
public class Solution {

    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        int count = 0;
        boolean rightFlag = false;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return check(s, left + 1, right) || check(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean check(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.validPalindrome("abc"));
        System.out.println(solution.validPalindrome("abca"));
        System.out.println(solution.validPalindrome("cbbcc"));
    }
}
