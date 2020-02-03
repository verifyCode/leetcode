package com.q64_minimum_path_sum;

import java.util.List;

/**
 * @author xjn
 * @since 2020-02-03
 * https://leetcode-cn.com/problems/minimum-path-sum/
 * <p>
 * 64. 最小路径和
 */
public class Solution {

    private List<Integer> resList;
    private int[][] d = {{1, 0}, {0, 1}};
    private boolean[][] visited;
    private int m, n;

    public int minPathSum(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                    grid[i][j] = grid[i][j] + grid[i][j - 1];
                } else if (j == 0) {
                    grid[i][j] = grid[i][j] + grid[i - 1][j];
                } else {
                    int left = grid[i][j - 1];
                    int up = grid[i - 1][j];
                    grid[i][j] = grid[i][j] + Math.min(left, up);
                }
            }
        }
        return grid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }
}
