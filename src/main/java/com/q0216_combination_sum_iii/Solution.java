package com.q0216_combination_sum_iii;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xjn
 * @since 2020-02-02
 * https://leetcode-cn.com/problems/combination-sum-iii/
 * 216. 组合总和 III
 */
public class Solution {

    private List<List<Integer>> resList = new ArrayList<>();
    private boolean[] visited = new boolean[10];

    //1-9的9个数字中,选出k个数字,每个数字只能使用1次,和为n
    public List<List<Integer>> combinationSum3(int k, int n) {
        resList.clear();
        if (k <= 0 || n <= 0) {
            return resList;
        }
        combinationSum3(k, n, 1, new ArrayList<>());
        return resList;
    }

    private void combinationSum3(int k, int n, int start, List<Integer> list) {
        if (n < 0 || k < 0) {
            return;
        }
        if (list.size() == k && n == 0) {
            resList.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (!visited[i]) {
                list.add(i);
                visited[i] = true;
                combinationSum3(k, n - i, i, list);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }

    }

    public static void main(String[] args) {
        Solution test = new Solution();
        System.out.println(test.combinationSum3(3, 7));
        System.out.println(test.combinationSum3(3, 9));
    }
}
