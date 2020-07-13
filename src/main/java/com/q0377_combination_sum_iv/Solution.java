package com.q0377_combination_sum_iv;


import java.util.HashMap;

/**
 * @author xjn
 * @since 2020-02-09
 * https://leetcode-cn.com/problems/combination-sum-iv/
 * 377. 组合总和 Ⅳ
 */
public class Solution {

    private HashMap<Integer, Integer> map = new HashMap<>();

    public int combinationSum4(int[] nums, int target) {
        map.clear();
        return search(nums, target);
    }

    private int search(int[] nums, int target) {
        if (map.containsKey(target)) {
            return map.get(target);
        }
        if (target == 0) {
            return 1;
        }
        int res = 0;
        for (int num : nums) {
            if (target - num >= 0) {
                res += search(nums, target - num);
            }
        }
        map.put(target, res);
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combinationSum4(new int[]{1, 2, 3}, 4));
    }
}
