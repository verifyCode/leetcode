package com.recursive.q04_pascal_triangle02;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/explore/orignial/card/recursion-i/257/recurrence-relation/1203/
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 输入: 3
 * 输出: [1,3,3,1]
 *
 * @author xjn
 * @since 2019-12-18
 */
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        int[][] array = new int[rowIndex + 1][rowIndex + 1];
        List<Integer> subList = new ArrayList<>();
        if (rowIndex == 0) {
            subList.add(1);
        }
        for (int i = 0; i <= rowIndex && rowIndex > 0; i++) {
            for (int j = 0; j <= i; j++) {
                if (i - 1 < 0 || j - 1 < 0) {
                    array[i][j] = 1;
                } else {
                    array[i][j] = array[i - 1][j - 1] + array[i - 1][j];
                }
                if (i == rowIndex) {
                    subList.add(array[i][j]);
                }
            }
        }
        return subList;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        List<Integer> row = test.getRow(1);
        System.out.println(row);
    }

}
