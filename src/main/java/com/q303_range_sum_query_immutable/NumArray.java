package com.q303_range_sum_query_immutable;

/**
 * @author xjn
 * @since 2019-12-28
 * https://leetcode-cn.com/problems/range-sum-query-immutable/
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 * <p>
 * 示例：
 * <p>
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 * <p>
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 */
// TODO: 2020-01-03
public class NumArray {
    private int[] data;

    public NumArray(int[] nums) {
        this.data = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            data[i] = nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (j == i) {
            return data[i];
        }
        return sumRange(i + 1, j) + data[i];
    }

    public static void main(String[] args) {
        int[] ints = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
        NumArray array = new NumArray(ints);
        System.out.println(array.sumRange(0, 2));
    }
}
