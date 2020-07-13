package com.q0231_power_of_two;

/**
 * @author xjn
 * @since 2020-02-08
 * https://leetcode-cn.com/problems/power-of-two/
 * 231. 2的幂
 */
public class Solution {

    public boolean isPowerOfTwo(int n) {
        if (n < 0) {
            return false;
        }
        return Integer.bitCount(n) == 1;
    }

    public boolean isPowerOfTwo2(int n) {
        if (n < 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }

}
