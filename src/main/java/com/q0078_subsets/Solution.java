package com.q0078_subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xjn
 * @since 2020-02-01
 * https://leetcode-cn.com/problems/subsets/
 * 78. 子集
 */
public class Solution {
    private List<List<Integer>> resList = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return resList;
        }
        subsets(nums, 0, new ArrayList<>());
        return resList;
    }

    private void subsets(int[] nums, int start, List<Integer> list) {
        resList.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            subsets(nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }


    public static void main(String[] args) {
        Solution test = new Solution();
        System.out.println(test.subsets(new int[]{1, 2, 3}));
    }
}
