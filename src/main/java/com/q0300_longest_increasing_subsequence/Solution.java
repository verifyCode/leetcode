package com.q0300_longest_increasing_subsequence;

import java.util.Arrays;

/**
 * @author xjn
 * @since 2020-02-10
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * 300. 最长上升子序列
 */
public class Solution {

    private int[][] memo;

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        memo = new int[nums.length + 1][nums.length];
        for (int[] a : memo) {
            Arrays.fill(a, -1);
        }
        return findLIS(nums, -1, 0);
    }

    //返回最长上升子序列的长度
    private int findLIS(int[] nums, int prevPos, int curPos) {
        if (curPos == nums.length) {
            return 0;
        }
        if (memo[prevPos + 1][curPos] >= 0) {
            return memo[prevPos + 1][curPos];
        }
        //遇到nums[i] 选择跳过
        int a = findLIS(nums, prevPos, curPos + 1);

        //遇到nums[i] 不跳过 +1
        int b = 0;
        if (prevPos < 0 || nums[curPos] > nums[prevPos]) {
            b = findLIS(nums, curPos, curPos + 1) + 1;
        }
        memo[prevPos + 1][curPos] = Math.max(a, b);
        return Math.max(a, b);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));//4
        System.out.println(solution.lengthOfLIS(new int[]{4, 10, 4, 3, 8, 9}));//3
    }
}
