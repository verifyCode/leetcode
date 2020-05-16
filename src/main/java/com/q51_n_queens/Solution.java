package com.q51_n_queens;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xjn
 * @since 2020-02-06
 * https://leetcode-cn.com/problems/n-queens/
 * 51. N皇后
 */
public class Solution {
    private List<List<String>> resList = new ArrayList<>();
    //列
    private boolean[] col;

    //两个对角线
    private boolean[] dai1;
    private boolean[] dai2;

    public List<List<String>> solveNQueens(int n) {
        resList.clear();
        if (n == 0) {
            return resList;
        }
        col = new boolean[n];
        dai1 = new boolean[2 * n - 1];
        dai2 = new boolean[2 * n - 1];
        putQueue(n, 0, new ArrayList<>());
        return resList;
    }

    //index:行
    private void putQueue(int n, int index, List<Integer> row) {
        if (index == n) {
            List<String> list = generateBoard(n, row);
            //一个list是一个结果集
            resList.add(list);
            return;
        }

        //尝试将第index行的皇后摆放在第i列
        for (int i = 0; i < n; i++) {
            //当前位置没有放过 && 当前位置的左对角线没放过 && 当前位置的右对角线没放过
            if (!col[i] && !dai1[index + i] && !dai2[index - i + n - 1]) {
                col[i] = true;
                dai1[index + i] = true;
                dai2[index - i + n - 1] = true;
                row.add(i);
                putQueue(n, index + 1, row);
                col[i] = false;
                dai1[index + i] = false;
                dai2[index - i + n - 1] = false;
                row.remove(row.size() - 1);
            }
        }
    }

    private List<String> generateBoard(int n, List<Integer> row) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (row.get(i) == j) {
                    builder.append("Q");
                } else {
                    builder.append(".");
                }
            }
            list.add(builder.toString());
        }
        return list;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solveNQueens(4));
    }
}
