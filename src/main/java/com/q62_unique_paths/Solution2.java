package com.q62_unique_paths;

/**
 * @author xjn
 * @since 2020-02-07
 * https://leetcode-cn.com/problems/unique-paths/
 * 62. 不同路径
 */
public class Solution2 {


    //m:列
    //n:行
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
