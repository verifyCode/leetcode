package com.q198_house_robber;

/**
 * @author xjn
 * @since 2020-02-07
 * https://leetcode-cn.com/problems/house-robber/
 * 198. 打家劫舍
 */
public class Solution {

    private int[] memo;

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        memo = new int[nums.length];
        return rob(nums, 0);
    }

    private int rob(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }
        if (memo[index] > 0) {
            return memo[index];
        }
        int res = 0;
        for (int i = index; i < nums.length; i++) {
            res = Math.max(nums[i] + rob(nums, i + 2), res);
        }
        memo[index] = res;
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rob(new int[]{1, 2, 3, 1}));
        System.out.println(solution.rob(new int[]{2, 7, 9, 3, 1}));
    }
}
