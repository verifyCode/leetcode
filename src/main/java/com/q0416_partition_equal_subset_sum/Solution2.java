package com.q0416_partition_equal_subset_sum;

import java.util.Arrays;

/**
 * @author xjn
 * @since 2020-02-09
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/
 * 416. 分割等和子集
 * 典型的背包问题:n个物品中选出一定物品,填满sum/2的背包
 */
public class Solution2 {

    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 == 1) {
            return false;
        }
        Arrays.sort(nums);
        return canPartition(nums, nums.length - 1, sum / 2, sum / 2);
    }

    //up上界
    //down 下界
    private boolean canPartition(int[] nums, int index, int up, int down) {
        if (up == 0 || down == 0) {
            return true;
        } else if (up < 0 || down < 0) {
            return false;
        }
        boolean a = canPartition(nums, index - 1, up - nums[index], down);
        boolean b = canPartition(nums, index - 1, up, down - nums[index]);
        return a || b;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(solution.canPartition(new int[]{2, 2, 3, 5}));
    }
}
