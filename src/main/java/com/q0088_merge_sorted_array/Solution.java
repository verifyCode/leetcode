package com.q0088_merge_sorted_array;

import java.util.Arrays;

/**
 * @author xjn
 * @since 2020-01-19
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int right = nums1.length - 1;
        int p1 = m - 1;
        int p2 = n - 1;
        while (p1 >= 0 || p2 >= 0 || right >= 0) {
            if (p1 < 0 && p2 >= 0) {
                nums1[right] = nums2[p2];
                p2--;
                right--;
            } else if (p2 < 0 && p1 >= 0) {
                nums1[right] = nums1[p1];
                p1--;
                right--;
            } else if (nums1[p1] >= nums2[p2]) {
                nums1[right] = nums1[p1];
                p1--;
                right--;
            } else if (nums1[p1] < nums2[p2]) {
                nums1[right] = nums2[p2];
                right--;
                p2--;
            }
        }

    }

    public static void main(String[] args) {
        Solution test = new Solution();
        int[] nums = new int[]{1, 2, 3, 0, 0, 0};
//        test.merge(nums, 3, new int[]{2, 5, 6}, 3);
        int[] array = new int[]{0};
        int[] array2 = new int[]{1};
//        test.merge(nums, 3, new int[]{2, 5, 6}, 3);
        test.merge(array, 0, array2, 1);
//        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(array));
    }
}
