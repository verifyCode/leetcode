package com.q47_permutations_ii;

import java.util.*;

/**
 * @author xjn
 * @since 2020-01-30
 * https://leetcode-cn.com/problems/permutations-ii/
 * 47. 全排列 II
 * 时间复杂度
 */
public class Solution {


    private Set<Integer> used = new TreeSet<>();
    private List<List<Integer>> resList = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return resList;
        }
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        permuteUnique(nums, 0, list);
        return resList;
    }

    private void permuteUnique(int[] nums, int index, List<Integer> list) {
        if (index == nums.length) {
            resList.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used.contains(i)) {
                if (i > 0 && nums[i] == nums[i - 1] && !used.contains(i - 1)) {
                    continue;
                }
                used.add(i);
                list.add(nums[i]);
                permuteUnique(nums, index + 1, list);
                used.remove(i);
                list.remove(list.size() - 1);
            }
        }

    }


    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.permuteUnique(new int[]{3, 3, 0, 3}));
        System.out.println(solution.permuteUnique(new int[]{1, 1, 2}));
    }
}
