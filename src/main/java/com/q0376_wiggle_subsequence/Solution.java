package com.q0376_wiggle_subsequence;

/**
 * @author xjn
 * @since 2020-02-14
 * https://leetcode-cn.com/problems/wiggle-subsequence/
 * 376. 摆动序列
 */
public class Solution {
    public int wiggleMaxLength(int[] nums) {
        return wiggleMaxLength(nums, 0, 1);
    }

    //
    private int wiggleMaxLength(int[] nums, int prePos, int curPos) {
        if (curPos == nums.length) {
            return 0;
        }
        int up = 1;
        if (nums[prePos] < nums[curPos]) {
            up = wiggleMaxLength(nums, curPos, curPos + 1) + 1;
        }
        int down = 1;
        if (nums[prePos] > nums[curPos]) {
            down = wiggleMaxLength(nums, curPos, curPos + 1) + 1;
        }
        return Math.max(up, down);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.wiggleMaxLength(new int[]{1, 7, 4, 9, 2, 5}));
    }
}
