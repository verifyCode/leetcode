package com.q0063_unique_paths_ii;

/**
 * @author xjn
 * @since 2020-02-07
 * https://leetcode-cn.com/problems/unique-paths-ii/
 * 63. 不同路径 II
 */
public class Solution {

    private int m, n;
    private int[][] map;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;
        map = new int[m + 1][n + 1];
        return dfs(obstacleGrid, 0, 0);
    }

    private int dfs(int[][] obstacleGrid, int x, int y) {
        if (map[x][y] > 0) {
            return map[x][y];
        }
        if (!inArea(x, y)) {
            return 0;
        }
        if (obstacleGrid[x][y] == 1) {
            return 0;
        }
        if (x == m - 1 && y == n - 1) {
            return 1;
        }
        int a = dfs(obstacleGrid, x + 1, y);
        int b = dfs(obstacleGrid, x, y + 1);
        map[x][y] = a + b;
        return a + b;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int a[][] = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println(solution.uniquePathsWithObstacles(a));
    }

}
