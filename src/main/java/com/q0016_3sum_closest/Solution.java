package com.q0016_3sum_closest;

import java.util.Arrays;

/**
 * @author xjn
 * @since 2020-01-21
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * <p>
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 时间复杂度:O(n^2)
 * 空间复杂度:O(1)
 */
public class Solution {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (Math.abs(target - sum) < Math.abs(target - res)) {
                    res = sum;
                }
                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                }
                if (sum == target) {
                    return sum;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        int[] nums = new int[]{-1, 2, 1, -4};//2
//        int[] nums = new int[]{1, 1, 1, 0};
//        int[] nums = new int[]{0,1,2};
        int target = 1;
        System.out.println(test.threeSumClosest(nums, target));
    }
}
