package com.q0268_missing_number;

/**
 * @author xjn
 * @since 2020-02-08
 * https://leetcode-cn.com/problems/missing-number/
 * 268. 缺失数字
 */
public class Solution {
    public int missingNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = i ^ nums[i] ^ res;
        }
        return res ^ nums.length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.missingNumber(new int[]{0, 2, 3}));
    }
}
