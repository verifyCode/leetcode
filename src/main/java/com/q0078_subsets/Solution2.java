package com.q0078_subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xjn
 * @since 2020-02-02
 * https://leetcode-cn.com/problems/subsets/
 * 78. 子集
 */
public class Solution2 {
    private List<List<Integer>> resList = new ArrayList<>();
    private boolean[] visited;

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return resList;
        }
        visited = new boolean[nums.length];
        subsets(nums, 0, new ArrayList<>());
        return resList;
    }

    private void subsets(int[] nums, int start, List<Integer> list) {
        resList.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            if (!visited[i]) {
                list.add(nums[i]);
                visited[i] = true;
                subsets(nums, i + 1, list);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }


    public static void main(String[] args) {
        Solution2 test = new Solution2();
        System.out.println(test.subsets(new int[]{1, 2, 3}));
    }
}
