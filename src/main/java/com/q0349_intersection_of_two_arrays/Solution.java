package com.q0349_intersection_of_two_arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * @author xjn
 * @since 2019-12-26
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * <p>
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < nums1.length; i++) {
            treeSet.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (treeSet.contains(nums2[i])) {
                list.add(nums2[i]);
                treeSet.remove(nums2[i]);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 2};
        int[] nums3 = new int[]{4, 9, 5};
        int[] nums4 = new int[]{9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(test.intersection(nums1, nums2)));
        System.out.println(Arrays.toString(test.intersection(nums3, nums4)));

    }
}
