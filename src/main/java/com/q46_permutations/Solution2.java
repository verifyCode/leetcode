package com.q46_permutations;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author xjn
 * @since 2020-01-31
 * https://leetcode-cn.com/problems/permutations/
 * 46. 全排列
 */
public class Solution2 {

    private List<List<Integer>> resList = new ArrayList<>();
    private Set<Integer> used = new TreeSet<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return resList;
        }
        resList.clear();
        used.clear();
        ArrayList<Integer> list = new ArrayList<>();
        findPermute(nums, 0, list);
        return resList;
    }

    private void findPermute(int[] nums, int index, ArrayList<Integer> list) {
        if (index == nums.length) {
            resList.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
//            if (!used.contains(nums[i])) {
//                used.add(nums[i]);
            list.add(nums[i]);
            findPermute(nums, index + 1, list);
            list.remove(list.size() - 1);
//                used.remove(nums[i]);                                                             mmm
//            }
        }
    }

    public static void main(String[] args) {
        Solution2 test = new Solution2();
        System.out.println(test.permute(new int[]{1, 2, 3}));
    }
}

