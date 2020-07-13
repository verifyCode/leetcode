package com.q0494_target_sum;

import javafx.util.Pair;

import java.util.HashMap;

/**
 * @author xjn
 * @since 2020-02-10
 * https://leetcode-cn.com/problems/target-sum/
 * 494. 目标和
 */
public class Solution {

    private HashMap<Pair<Integer, Integer>, Integer> map = new HashMap<>();
    public int findTargetSumWays(int[] nums, int S) {
        map.clear();
        return find(nums, S, 0);
    }

    //返回最终数组和为目标s的所有方法数量
    private int find(int[] nums, int s, int index) {
        Pair<Integer, Integer> pair = new Pair<>(index, s);
        if (map.containsKey(pair)) {
            return map.get(pair);
        }
        if (index >= nums.length && s != 0) {
            return 0;
        }

        if (s == 0 && index == nums.length) {
            return 1;
        }


        int a = 0;
        if (index + 1 <= nums.length) {
            a = a + find(nums, s - nums[index], index + 1);
            a = a + find(nums, s + nums[index], index + 1);
        }
        Pair<Integer, Integer> p = new Pair<>(index, s);
        map.put(pair, a);
        return a;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
}
