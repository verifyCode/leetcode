package com.recursive.q07climbStairs;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/explore/orignial/card/recursion-i/258/memorization/1213/
 * okmokokookokoko
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 *
 * @author xjn
 * @since 2019-12-19
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */
public class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();

    public int climbStairs(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int ret;
        if (n == 1) {
            ret = 1;
        } else if (n == 2) {
            ret = 2;
        } else {
            ret = climbStairs(n - 1) + climbStairs(n - 2);
            map.put(n, ret);
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        System.out.println(test.climbStairs(44));
    }
}
