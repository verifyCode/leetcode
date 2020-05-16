package com.q39_combination_sum;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xjn
 * @since 2020-02-02
 * https://leetcode-cn.com/problems/combination-sum/
 * 39. 组合总和
 * 时间复杂度O(n^n)
 * 空间复杂度 O(target)
 */
public class Solution {

    private List<List<Integer>> resList = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        resList.clear();
        combinationSum(candidates, target, 0, new ArrayList<>(), 0);
        return resList;
    }

    private void combinationSum(int[] candidates, int target, int start, List<Integer> list, int depth) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            resList.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            System.out.println(generateString(depth) + ":candidates[" + i + "]" + " =" + candidates[i] + " list:" + list);
            combinationSum(candidates, target - candidates[i], i, list, depth + 1);
            list.remove(list.size() - 1);
        }
    }

    private String generateString(int depth) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            builder.append("-");
        }
        return builder.toString();
    }


    public static void main(String[] args) {
        Solution test = new Solution();
        System.out.println(test.combinationSum(new int[]{2, 3, 6, 7}, 7));
        //3,4,4
//        System.out.println(test.combinationSum(new int[]{8, 7, 4, 3}, 11));
    }

}
