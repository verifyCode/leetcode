package com.q136_single_number;

/**
 * @author xjn
 * @since 2020-02-02
 * https://leetcode-cn.com/problems/single-number/
 * 136. 只出现一次的数字
 */
public class Solution {
    public int singleNumber(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[0] = nums[i] ^ nums[0];
        }
        return nums[0];
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        System.out.println(test.singleNumber(new int[]{2, 2, 1}));
    }
}
