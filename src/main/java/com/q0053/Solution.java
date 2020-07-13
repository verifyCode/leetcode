package com.q0053;

import java.util.stream.IntStream;

/**
 * @author xjn
 * @since 2020-05-31
 * https://leetcode-cn.com/problems/maximum-subarray/
 * 53. 最大子序和
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 */
public class Solution {

    public int maxSubArray(int[] nums) {
        //dp[i]:以nums[i]为结尾的最大子数组的和
        //1.相连 dp[i] = dp[i-1] + nums[i]
        //2. 不相连 dp[i] = nums[i]

        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = nums[i];
        }
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1] + nums[i]);
        }
        return IntStream.of(dp).boxed().max(Integer::compareTo).get();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(solution.maxSubArray(new int[]{-1, -2}));
    }
}
