package com.q0062_unique_paths;

/**
 * @author xjn
 * @since 2020-02-07
 * https://leetcode-cn.com/problems/unique-paths/
 * 62. 不同路径
 * 时间复杂度O(n * m)
 * 空间复杂度O(n * m)
 */
public class Solution2 {


    //m:列
    //n:行

    /**
     * dp[i][j]:从起点走到位置(i,j)处需要的步骤
     * dp[i][j] = dp[i][j-1] + dp[i-1][j]
     * dp[0][0~j] = 1
     * dp[0~i][0] = 1
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0) {
                    dp[0][j] = 1;
                } else if (j == 0) {
                    dp[i][j] = 1;
                } else {
                    int left = dp[i][j - 1];
                    int up = dp[i - 1][j];
                    dp[i][j] = left + up;
                }
            }
        }
        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        Solution2 test = new Solution2();
        System.out.println(test.uniquePaths(3, 2));
    }
}
