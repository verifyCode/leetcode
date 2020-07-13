package com.q0062_unique_paths;

/**
 * @author xjn
 * @since 2020-02-07
 * https://leetcode-cn.com/problems/unique-paths/
 * 62. 不同路径
 */
public class Solution {

    private int m, n;
    private int[][] map;

    //m:列
    //n:行
    public int uniquePaths(int m, int n) {
        this.m = m;
        this.n = n;
        map = new int[n + 1][m + 1];
        return uniquePaths(m, n, 0, 0);
    }

    //m:列
    //n:行
    //x:列
    //y:行
    public int uniquePaths(int m, int n, int x, int y) {
        if (map[y][x] > 0) {
            return map[y][x];
        }
        if (!inArea(x, y)) {
            return 0;
        }
        if (x == m - 1 && y == n - 1) {
            return 1;
        }
        int a = uniquePaths(m, n, x, y + 1);
        int b = uniquePaths(m, n, x + 1, y);
        map[y][x] = a + b;
        return a + b;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.uniquePaths(3, 2));
    }
}
