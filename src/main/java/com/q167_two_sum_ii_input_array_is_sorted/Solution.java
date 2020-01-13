package com.q167_two_sum_ii_input_array_is_sorted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xjn
 * @since 2020-01-10
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * <p>
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * <p>
 * 说明:
 * <p>
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 * <p>
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
//    public int[] twoSum(int[] numbers, int target) {
//        int[] res = new int[2];
//        for (int i = 0; i < numbers.length; i++) {
//            int a = numbers[i];
//            if (a > target) {
//                break;
//            } else {
//                System.out.println(target - a);
//                int search = search(numbers, i + 1, numbers.length - 1, target - a);
//                if (search != -1) {
//                    res[0] = i + 1;
//                    res[1] = search + 1;
//                    break;
//                }
//            }
//
//        }
//        return res;
//    }
//
//    public int search(int[] array, int l, int r, int k) {
//        if (l >= r) {
//            return -1;
//        }
//        int mid = (l + r) / 2;
//        if (array[mid] == k) {
//            return mid;
//        } else if (array[mid] > k) {
//            return search(array, l, mid - 1, k);
//        } else {
//            return search(array, mid + 1, r, k);
//        }
//    }
//
//    public static void main(String[] args) {
//        Solution test = new Solution();
//        int[] nums = new int[]{2, 7, 11, 15};
//        int[] ints = test.twoSum(nums, 9);
//        System.out.println(Arrays.toString(ints));
//    }
}
