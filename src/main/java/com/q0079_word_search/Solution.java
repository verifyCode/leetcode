package com.q0079_word_search;

/**
 * @author xjn
 * @since 2020-02-02
 * https://leetcode-cn.com/problems/word-search/
 * 79. 单词搜索
 * 时间复杂度O(m * n * m * n)
 * 空间复杂度O(m * n)
 */
public class Solution {

    private int d[][] = {
            {-1, 0}, //0
            {0, 1}, //1
            {1, 0},//2
            {0, -1}};//3
    private int m, n;
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean isMatch = searchWord(board, word, 0, i, j);
                if (isMatch) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean searchWord(char[][] board, String word, int index, int startX, int startY) {
        //返回最后一个字符是否相等
        if (index == word.length() - 1) {
            return board[startX][startY] == word.charAt(index);
        }
        if (board[startX][startY] == word.charAt(index)) {
            visited[startX][startY] = true;
            //从startX,startY出发,向四个方向寻找
            for (int i = 0; i < 4; i++) {
                int newX = startX + d[i][0];
                int newY = startY + d[i][1];
                if (inArea(newX, newY) && !visited[newX][newY]) {
                    boolean isMath = searchWord(board, word, index + 1, newX, newY);
                    if (isMath) {
                        return true;
                    }
                }
            }
            visited[startX][startY] = false;
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(solution.exist(board, "ABCCED"));
        System.out.println(solution.exist(board, "SEE"));
        System.out.println(solution.exist(board, "ABCB"));
    }
}
