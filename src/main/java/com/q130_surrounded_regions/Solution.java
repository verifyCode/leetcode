package com.q130_surrounded_regions;

/**
 * @author xjn
 * @since 2020-02-02
 * https://leetcode-cn.com/problems/surrounded-regions/
 * 130. 被围绕的区域
 */
public class Solution {
    private int d[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int m, n;
    private boolean[][] visited;

    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        m = board.length;
        n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {

                }
            }
        }
    }

    private boolean solve(char[][] board, int x, int y) {
        if (!inArea(x, y)) {
            return false;
        }
        if (board[x][y] == 'X') {
            return false;
        }
        if (board[x][y] == 'O') {
            return true;
        }
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + d[i][0];
            int newY = y + d[i][1];
        }
        return false;
    }


    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }


    public static void main(String[] args) {

    }
}
