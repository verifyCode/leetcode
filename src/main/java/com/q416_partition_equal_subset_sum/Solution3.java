package com.q416_partition_equal_subset_sum;

/**
 * @author xjn
 * @since 2020-06-20
 */
public class Solution3 {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) {
            return false;
        }
        boolean[][] dp = new boolean[nums.length][sum / 2 + 1];
        dp[0][0] = true;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= sum / 2; j++) {
                dp[i][j] = dp[i - 1][j];
                if (nums[i] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[nums.length - 1][sum / 2];
    }
}
