package com.q0213_house_robber_ii;

/**
 * @author xjn
 * @since 2020-02-09
 * https://leetcode-cn.com/problems/house-robber-ii/
 * 213. 打家劫舍 II
 */
public class Solution2 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int a = rob(nums, 0, nums.length - 2);
        int b = rob(nums, 1, nums.length - 1);
        return Math.max(a, b);
    }

    private int rob(int[] nums, int start, int end) {

        int pre = 0;
        int cur = 0;
        int temp;
        for (int i = start; i <= end; i++) {
            temp = cur;
            cur = Math.max(pre + nums[i], cur);
            pre = temp;
        }
        return cur;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.rob(new int[]{2, 3, 2}));//3
        System.out.println(solution.rob(new int[]{1, 2, 3, 1}));//4
        System.out.println(solution.rob(new int[]{1, 3, 1, 3, 100}));//103
    }
}
