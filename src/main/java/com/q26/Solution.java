package com.q26;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author xjn
 * @since 2020-06-01
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * 26. 删除排序数组中的重复项
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int index = nextDifferentPos(nums, 1);
        int res = 0;
        int i = 1;
        while (index < nums.length) {
            res++;
            nums[i] = nums[index];
            i++;
            index = nextDifferentPos(nums, index + 1);
        }
        return res;
    }


    private int nextDifferentPos(int[] nums, int p) {
        for (; p < nums.length; p++) {
            if (nums[p] != nums[p - 1]) {
                break;
            }
        }
        return p;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        //0   1  2  3  4  5  6  7  8
//        System.out.println(solution.removeDuplicates(new int[]{1, 2, 2, 2, 3, 4, 5, 6, 7}));

        System.out.println(solution.removeDuplicates(new int[]{1, 1, 2}));
    }
}
