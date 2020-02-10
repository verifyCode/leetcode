package com.q300_longest_increasing_subsequence;

import java.util.Arrays;

/**
 * @author xjn
 * @since 2020-02-10
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * 300. 最长上升子序列
 */
public class Solution {

    private int[] memo;

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);
        return getMaxLength(nums, nums.length);
    }

    //返回最长上升子序列的长度
    private int findLIS(int[] nums, int prev, int curPos) {
        if (curPos == nums.length) {
            return 0;
        }
        int select = 0;
        if (nums[curPos] > prev) {
            select = 1 + findLIS(nums, nums[curPos], curPos + 1);
        }
        int noSelect = findLIS(nums, prev, curPos + 1);
        return Math.max(select, noSelect);
    }

    private int getMaxLength(int[] nums, int index) {
        if (memo[index] != -1) {
            return memo[index];
        }
        int res = 1;
        for (int i = 0; i <= index - 1; i++) {
            if (nums[index] > nums[i]) {
                int a = 1 + getMaxLength(nums, i);
                res = Math.max(a, res);
            }
        }
        memo[index] = res;
        return res;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }
}
