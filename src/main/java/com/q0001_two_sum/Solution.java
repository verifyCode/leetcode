package com.q0001_two_sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xjn
 * @since 2020-02-15
 * https://leetcode-cn.com/problems/two-sum/
 * 1. 两数之和
 *
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        //k:value
        //v:index
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(ints));
    }
}
