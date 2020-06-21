package com.q130_surrounded_regions;

import java.util.Arrays;

/**
 * @author xjn
 * @since 2020-02-02
 * https://leetcode-cn.com/problems/surrounded-regions/
 * 130. 被围绕的区域
 */
public class Solution {
    private int d[][] = {
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
    };
    private int m, n;
    private boolean[][] visited;

    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < n; i++) {
            dfs(board, 0, i);
            dfs(board, m - 1, i);
        }
        for (int j = 0; j < m; j++) {
            dfs(board, j, 0);
            dfs(board, j, n - 1);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'G') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    //将X--->G
    private void dfs(char[][] board, int x, int y) {
        if (!inArea(x, y)) {
            return;
        }
        if (board[x][y] != 'O') {
            return;
        }
        board[x][y] = 'G';
        for (int i = 0; i < 4; i++) {
            int newX = x + d[i][0];
            int newY = y + d[i][1];
            dfs(board, newX, newY);
        }
    }


    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        char[][] board1 = new char[][]{
                {'O', 'O', 'O'},
                {'O', 'O', 'O'},
                {'O', 'O', 'O'}
        };
        solution.solve(board1);
        for (int i = 0; i < board1.length; i++) {
            System.out.println(Arrays.toString(board1[i]));
        }
    }
}
