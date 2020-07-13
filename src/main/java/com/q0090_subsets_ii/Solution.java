package com.q0090_subsets_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xjn
 * @since 2020-02-02
 * https://leetcode-cn.com/problems/subsets-ii/
 * <p>
 * 90. 子集 II
 */
public class Solution {

    private List<List<Integer>> resList = new ArrayList<>();
    private boolean visited[];

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        resList.clear();
        if (nums == null || nums.length == 0) {
            return resList;
        }
        visited = new boolean[nums.length];
        Arrays.sort(nums);
        subsetsWithDup(nums, 0, new ArrayList<>());
        return resList;
    }

    private void subsetsWithDup(int nums[], int start, List<Integer> list) {
        resList.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            if (!visited[i]) {
                if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                    continue;
                }
                list.add(nums[i]);
                visited[i] = true;
                subsetsWithDup(nums, i + 1, list);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        test.subsetsWithDup(new int[]{1, 2, 2});
    }
}
