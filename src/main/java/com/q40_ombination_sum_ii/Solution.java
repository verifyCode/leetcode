package com.q40_ombination_sum_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author xjn
 * @since 2020-02-02
 * https://leetcode-cn.com/problems/combination-sum-ii/
 * 40. 组合总和 II
 */
public class Solution {
    private List<List<Integer>> resList = new ArrayList<>();
    private boolean[] visited;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        resList.clear();
        if (candidates == null || candidates.length == 0) {
            return resList;
        }
        visited = new boolean[candidates.length];
        Arrays.sort(candidates);
        combinationSum2(candidates, target, 0, new ArrayList<>());
        return resList;

    }

    private void combinationSum2(int[] candidates, int target, int start, List<Integer> list) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            resList.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (!visited[i]) {
                if (i > 0 && candidates[i] == candidates[i - 1] && !visited[i - 1]) {
                    continue;
                }
                list.add(candidates[i]);
                visited[i] = true;
                combinationSum2(candidates, target - candidates[i], i + 1, list);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        test.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
    }
}
