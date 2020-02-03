package com.q343_integer_break;

import java.util.HashMap;

/**
 * @author xjn
 * @since 2020-02-03
 * https://leetcode-cn.com/problems/integer-break/
 * 343. 整数拆分
 */
public class Solution {

    HashMap<Integer, Integer> map = new HashMap<>();

    public int integerBreak(int n) {
        return breakInteger(n);
    }

    //将n进行分割(至少分割两部分),可以获得的最大乘积
    private int breakInteger(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n == 1) {
            return 1;
        }
        int res = -1;
        for (int i = 1; i <= n - 1; i++) {
            res = max(breakInteger(n - i) * i, res, i * (n - i));
        }
        map.put(n, res);
        return res;
    }

    private int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.integerBreak(2));
        System.out.println(solution.integerBreak(10));
    }
}
