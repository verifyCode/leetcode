package com.q08;

/**
 * @author xjn
 * @since 2020-05-23
 */
public class Solution {
    public int myAtoi(String str) {
        int n = 0;
        int sum = 0;
        int i = 0;
        while (n < str.length()) {
            int cur = str.charAt(n) - '0';
            sum = sum * 10 + cur;
            n++;
        }
        return sum;
    }


    public int pow10(int n) {
        if (n == 0) {
            return 1;
        }
        int res = pow10(n / 2);
        if (n % 2 == 0) {
            return res * res;
        } else {
            return res * res * 10;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myAtoi("123"));
    }
}
