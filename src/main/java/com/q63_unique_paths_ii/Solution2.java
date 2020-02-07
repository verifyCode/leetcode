package com.q63_unique_paths_ii;

/**
 * @author xjn
 * @since 2020-02-
 * https://leetcode-cn.com/problems/unique-paths-ii/
 * 63. 不同路径 II
 */
public class Solution2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i == 0 && j == 0){
                    continue;
                }


            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int a[][] = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println(solution.uniquePathsWithObstacles(a));

    }
}
