package com.q0009_palindrome_number;

/**
 * @author xjn
 * @since 2020-02-15
 * https://leetcode-cn.com/problems/palindrome-number/
 * 9. 回文数
 * 时间复杂度 O(log10^n)
 * 空间复杂度O(1)
 */
public class Solution {

    public boolean isPalindrome(int x) {
        if (x < 0 || x != 0 && x % 10 == 0) {
            return false;
        }
        int sum = 0;
        int source = x;
        while (x != 0) {
            sum = sum * 10 + x % 10;
            x = x / 10;
        }
        return sum == source;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(121));
        System.out.println(solution.isPalindrome(-121));
        System.out.println(solution.isPalindrome(10));
        System.out.println(solution.isPalindrome(0));

    }
}
