package com.q213_house_robber_ii;

/**
 * @author xjn
 * @since 2020-02-09
 * https://leetcode-cn.com/problems/house-robber-ii/
 * 213. 打家劫舍 II
 */
public class Solution {

    //1. 抢第一间房,不抢最后一间
    //2. 抢最后一间,不抢第一间
    //3. 最后一间和第一间都不抢
    private int[][] memo;

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        memo = new int[nums.length][nums.length];
        int a = rob2(nums, 0, nums.length - 2);
        int b = rob2(nums, 1, nums.length - 1);
        return Math.max(a, b);
    }

    private int rob(int[] nums, int start, int end) {
        if (start > end) {
            return 0;
        }
        if (memo[start][end] > 0) {
            return memo[start][end];
        }
        int res = 0;
        for (int i = start; i <= end; i++) {
            res = Math.max(nums[i] + rob(nums, i + 2, end), res);
        }
        if (memo[start][end] == 0) {
            memo[start][end] = res;
        }
        return res;
    }

    private int rob2(int[] nums, int start, int end) {
        if (start > end) {
            return 0;
        }
        //要么不偷
        int a = rob2(nums, start + 1, end);
        //要么偷
        int b = nums[start] + rob2(nums, start + 2, end);
        return Math.max(a, b);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rob(new int[]{2, 3, 2}));//3
        System.out.println(solution.rob(new int[]{1, 2, 3, 1}));//4
        System.out.println(solution.rob(new int[]{1, 3, 1, 3, 100}));//103
    }
}
