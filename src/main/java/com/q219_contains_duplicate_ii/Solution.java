package com.q219_contains_duplicate_ii;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author xjn
 * @since 2020-01-22
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }

        }
        return false;
    }


    public static void main(String[] args) {
        Solution test = new Solution();
        System.out.println(test.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
//        System.out.println(test.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
//        System.out.println(test.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
//        System.out.println(test.containsNearbyDuplicate(new int[]{4, 1, 2, 3, 1, 5}, 3));
    }
}
