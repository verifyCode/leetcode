package com.q04median_of_two_sorted_arrays;

/**
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * 则中位数是 2.0
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 则中位数是 (2 + 3)/2 = 2.5
 * <p>
 *
 * @author xjn
 * @since 2019-12-23
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int left = 0;
        int right = 0;
        int l = 0;
        int r = 0;
        if (nums1 != null) {
            left = nums1.length;
        }
        if (nums2 != null) {
            right = nums2.length;
        }
        boolean flag = (left + right) % 2 == 0;
        int mid = (left + right) / 2;
        int[] aux = new int[mid + 1];
        for (int i = 0; i <= mid; i++) {
            if (l >= left) {
                aux[i] = nums2[r];
                r++;
            } else if (r >= right) {
                aux[i] = nums1[l];
                l++;
            } else if (l < left && nums1[l] < nums2[r]) {
                aux[i] = nums1[l];
                l++;
            } else {
                aux[i] = nums2[r];
                r++;
            }
        }
        //是偶数
        return flag ? (aux[mid] + aux[mid - 1]) / 2.0 : aux[mid];

    }

    public static void main(String[] args) {
        Solution test = new Solution();

//        System.out.println(test.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(test.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }


}
