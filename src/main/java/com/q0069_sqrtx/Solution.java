package com.q0069_sqrtx;

/**
 * @author xjn
 * @since 2020-02-08
 * https://leetcode-cn.com/problems/sqrtx/
 * 69. x 的平方根
 */
public class Solution {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int l = 1;
        int r = x;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int sqrt = x / mid;
            if (sqrt == mid) {
                return mid;
            } else if (sqrt < mid) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    public static void main(String[] args) {

        Solution test = new Solution();
        System.out.println(test.mySqrt(8));
        System.out.println(test.mySqrt(10));
        System.out.println(test.mySqrt(12));

    }
}
