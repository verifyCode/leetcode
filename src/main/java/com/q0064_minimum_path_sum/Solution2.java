package com.q0064_minimum_path_sum;

/**
 * @author xjn
 * @since 2020-02-03
 * https://leetcode-cn.com/problems/minimum-path-sum/
 * 64. 最小路径和
 */
public class Solution2 {

    private int m, n;
    private int[][] ans;

    public int minPathSum(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        ans = new int[m][n];
        return minPathSum(grid, m - 1, n - 1);
    }

    private int minPathSum(int[][] grid, int x, int y) {
        if (x < 0 || y < 0) {
            return Integer.MAX_VALUE;
        }
        if (x == 0 && y == 0) {
            return grid[x][y];
        }
        if (ans[x][y] > 0) {
            return ans[x][y];
        }
        if (inArea(x, y)) {
            int up = minPathSum(grid, x - 1, y);
            int left = minPathSum(grid, x, y - 1);
            ans[x][y] = Math.min(up, left) + grid[x][y];
        }
        return ans[x][y];
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }


    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }
}

