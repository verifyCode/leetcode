package com.q07_reverse_integer;

/**
 * @author xjn
 * @since 2020-02-15
 * https://leetcode-cn.com/problems/reverse-integer/
 * 7. 整数反转
 * <p>
 * 时间复杂度 O(len(x))
 * 空间复杂度 O(1)
 */
public class Solution {
    public int reverse(int x) {
        long sum = 0;
        while (x != 0) {
            sum = sum * 10 + x % 10;
            x = x / 10;
            if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) {
                return 0;
            }
        }
        return (int) sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(123));
        System.out.println(solution.reverse(-123));
        System.out.println(solution.reverse(-120));
    }
}
