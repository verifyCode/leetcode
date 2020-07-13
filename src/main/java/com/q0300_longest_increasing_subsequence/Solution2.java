package com.q0300_longest_increasing_subsequence;

import java.util.Arrays;

/**
 * @author xjn
 * @since 2020-02-14
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * 300. 最长上升子序列
 */
public class Solution2 {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    res = Math.max(dp[i], res);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));//4
        System.out.println(solution.lengthOfLIS(new int[]{4, 10, 4, 3, 8, 9}));//3
    }
}
