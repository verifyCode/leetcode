package com.q220_contains_duplicate_iii;

import java.util.TreeSet;

/**
 * @author xjn
 * @since 2020-01-22
 * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,1], k = 3, t = 0
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: nums = [1,0,1,1], k = 1, t = 2
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long ceiling = set.ceiling(new Long(nums[i]) - new Long(t));
                                                         //整型溢出
            if (ceiling != null && ceiling <= (new Long(nums[i]) + new Long(t))) {
                return true;
            }
            set.add(new Long(nums[i]));
            if (set.size() > k) {
                set.remove(new Long(nums[i - k]));
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
//        System.out.println(test.containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0));
//        System.out.println(test.containsNearbyAlmostDuplicate(new int[]{1, 0, 1, 1}, 1, 2));
//        System.out.println(test.containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));
        System.out.println(test.containsNearbyAlmostDuplicate(new int[]{0, 2147483647}, 1, 2147483647));
    }
}
