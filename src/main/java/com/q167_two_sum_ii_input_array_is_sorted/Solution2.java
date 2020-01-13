package com.q167_two_sum_ii_input_array_is_sorted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xjn
 * @since 2020-01-10
 */
public class Solution2 {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            if (numbers[r] + numbers[l] == target) {
                res[0] = l + 1;
                res[1] = r + 1;
                l++;
                r--;
            } else if (numbers[r] + numbers[l] < target) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution2 test = new Solution2();
        int[] nums = new int[]{2, 7, 11, 15};
        int[] ints = test.twoSum(nums, 9);
        System.out.println(Arrays.toString(ints));
    }
}