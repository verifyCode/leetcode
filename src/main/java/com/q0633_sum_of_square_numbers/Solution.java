package com.q0633_sum_of_square_numbers;

/**
 * @author xjn
 * @since 2020-02-08
 * https://leetcode-cn.com/problems/sum-of-square-numbers/
 * 633. 平方数之和
 */
public class Solution {
    public boolean judgeSquareSum(int c) {
        int n = (int) Math.sqrt(c) + 1;
        int left = 0;
        int right = n;
        while (left <= right) {
            int sum = left * left + right * right;
            if (sum < c) {
                left++;
            } else if (sum > c) {
                right--;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.judgeSquareSum(2));
        System.out.println(solution.judgeSquareSum(3));
        System.out.println(solution.judgeSquareSum(5));
    }
}
