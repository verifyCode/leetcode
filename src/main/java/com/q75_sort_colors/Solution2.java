package com.q75_sort_colors;

import java.util.Arrays;

/**
 * @author xjn
 * @since 2020-01-09
 * 三路partition
 * 收件复杂度O(n)
 * 空间复杂度O(1)
 */
public class Solution2 {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int leftRange = -1;
        int rightRange = nums.length;

        int i = 0;
        while (i < rightRange) {
            if (nums[i] == 0) {
                swap(nums, i, leftRange + 1);
                leftRange++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, rightRange - 1);
                rightRange--;
            }
        }

    }

    private void swap(int nums[], int a, int b) {
        int c = nums[a];
        nums[a] = nums[b];
        nums[b] = c;
    }

    public static void main(String[] args) {
        Solution2 test = new Solution2();
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        int[] nums2 = new int[]{1, 2, 0};
        test.sortColors(nums);
        test.sortColors(nums2);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(nums2));
    }
}