package com.q0209_minimum_size_subarray_sum;

/**
 * @author xjn
 * @since 2020-01-20
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 * <p>
 * 示例: 
 * <p>
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int l = 0;
        int r = -1;
        int res = nums.length + 1;
        int sum = 0;
        while (l < nums.length) {
            if (r < nums.length - 1 && sum < s) {
                r++;
                sum += nums[r];
            } else {
                sum -= nums[l];
                l++;
            }
            if (sum >= s) {
                res = Math.min(r - l + 1, res);
            }
        }
        if (res == nums.length + 1) {
            return 0;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        System.out.println(test.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }
}
