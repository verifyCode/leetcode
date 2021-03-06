package com.q0198_house_robber;

/**
 * @author xjn
 * @since 2020-02-09
 * https://leetcode-cn.com/problems/house-robber/
 * 198. 打家劫舍
 */
public class Solution3 {

    private int[] memo;

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        memo = new int[nums.length];
        return rob(nums, 0);
    }

    private int rob(int[] nums, int start) {
        if (start >= nums.length) {
            return 0;
        }
        if (memo[start] != 0) {
            return memo[start];
        }
        //不抢去下一家
        int a = rob(nums, start + 1);
        //抢完 去下下一家
        int b = nums[start] + rob(nums, start + 2);
        memo[start] = Math.max(a, b);
        return Math.max(a, b);
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.rob(new int[]{1, 2, 3, 1}));
        System.out.println(solution.rob(new int[]{2, 7, 9, 3, 1}));
    }
}
