package com.q416_partition_equal_subset_sum;

/**
 * @author xjn
 * @since 2020-02-07
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/
 * 416. 分割等和子集
 * 典型的背包问题:n个物品中选出一定物品,填满sum/2的背包
 */
public class Solution {

    //memo[i][c]表示使用索引为[0..i]的这些元素,是否可以完全填充一个容量为c的背包
    //-1表示未计算,0表示不可以填充,1表示可以填充
    private int[][] memo;

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 != 0) {
            return false;
        }
        memo = new int[nums.length][sum / 2 + 1];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[i].length; j++) {
                memo[i][j] = -1;
            }
        }
        return canPartition(nums, nums.length - 1, sum / 2);
    }

    private boolean canPartition(int[] nums, int index, int c) {
        if (index < 0 || c < 0) {
            return false;
        }
        if (memo[index][c] == 1) {
            return true;
        }
        if (memo[index][c] == 0) {
            return false;
        }
        if (c == 0) {
            return true;
        }
        boolean a = canPartition(nums, index - 1, c);
        boolean b = canPartition(nums, index - 1, c - nums[index]);

        if (memo[index][c] == -1) {
            memo[index][c] = a || b ? 1 : 0;
        }
        return a || b;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(solution.canPartition(new int[]{2, 2, 3, 5}));
    }

}
