package com.q0350_intersection_of_two_arrays_ii;

import java.util.*;

/**
 * @author xjn
 * @since 2020-01-21
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 示例 1:
 * <p>
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 * <p>
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 */
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            Integer count = map.get(nums1[i]);
            if (count == null) {
                count = 1;
            } else {
                count++;
            }
            map.put(nums1[i], count);
        }
        for (int i = 0; i < nums2.length; i++) {
            Integer count = map.get(nums2[i]);
            if (count != null && count > 0) {
                res.add(nums2[i]);
                count--;
                map.put(nums2[i], count);
            }
        }
        int[] resArray = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArray[i] = res.get(i);
        }
        return resArray;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        int[] nums = new int[]{4, 9, 5};
        int[] nums2 = new int[]{9, 4, 9, 8, 4};
        int[] intersect = test.intersect(nums, nums2);
        System.out.println(Arrays.toString(intersect));
    }
}
