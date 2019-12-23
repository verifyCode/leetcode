package com.recursive.q07climbStairs;

/**
 * @author xjn
 * @since 2019-12-19
 * <p>
 */
public class Solution2 {

    public int climbStairs(int n) {
        int[] array = new int[n + 1];
        array[1] = 1;
        array[2] = 2;
        for (int i = 3; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }

    public static void main(String[] args) {
        Solution2 test = new Solution2();
        System.out.println(test.climbStairs(44));
    }
}
