package com.q08;

/**
 * @author xjn
 * @since 2020-05-23
 */
public class Solution {
    public int myAtoi(String str) {
        int n = 0;
        int sum = 0;
        while (n < str.length()) {
            int cur = str.charAt(n) - '0';
            sum = sum * 10 + cur;
            n++;
        }
        return sum;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myAtoi("123"));
    }
}
