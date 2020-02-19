package com.q198_house_robber;

/**
 * @author xjn
 * @since 2020-02-07
 * https://leetcode-cn.com/problems/house-robber/
 * 198. 打家劫舍
 */
public class Solution2 {
    //状态:考虑偷取[x...n-1]范围里的房子
    //f(i):考虑偷取[i...n-1]范围里的房子
    //f(0) = max{v(0)+f(2),v(1) + f(3),v(2)+f(4) ... v(n-3)+f(n-1),v(n-2),v(n-1)}
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        dp[n - 1] = nums[n - 1];
        //n-2~0
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i] = Math.max(dp[i], nums[j] + (j + 2 < n ? dp[j + 2] : 0));
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        Solution2 test = new Solution2();
        System.out.println(test.rob(new int[]{1, 2, 3, 1}));
        System.out.println(test.rob(new int[]{2, 7, 9, 3, 1}));
    }
}
