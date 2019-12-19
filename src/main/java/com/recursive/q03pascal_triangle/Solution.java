package com.recursive.q03pascal_triangle;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入: 5
 * 输出:
 * [
 * [1], 0
 * [1,1], 1
 * [1,2,1], 2
 * [1,3,3,1], 3
 * [1,4,6,4,1] 4
 * ]
 * <p>
 * 第 i 行、第 j 列
 * f(i,j) = f(i - 1, j - 1) + f(i - 1,j);
 * <p>
 * list.get(i).get(j) =
 *
 * @author xjn
 * @since 2019-12-18
 * https://leetcode-cn.com/explore/orignial/card/recursion-i/257/recurrence-relation/1202/
 */
class Solution {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return new ArrayList<>();
        }
        int[][] array = new int[numRows][numRows];
        List<List<Integer>> numsList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> subList = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j - 1 < 0 || i - 1 < 0) {
                    array[i][j] = 1;
                } else {
                    array[i][j] = array[i - 1][j - 1] + array[i - 1][j];
                }
                subList.add(array[i][j]);
            }
            numsList.add(subList);
        }
        return numsList;
    }


    public static void main(String[] args) {
        Solution test = new Solution();
        int numRows = 5;
        List<List<Integer>> generate = test.generate(numRows);
        System.out.println(generate);
    }


}
